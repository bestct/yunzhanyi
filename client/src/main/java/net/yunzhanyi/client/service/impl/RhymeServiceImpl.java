package net.yunzhanyi.client.service.impl;

import cn.hutool.core.util.ObjectUtil;
import io.swagger.v3.oas.models.security.SecurityScheme;
import net.yunzhanyi.client.domain.vo.*;
import net.yunzhanyi.client.service.RhymeService;
import net.yunzhanyi.domain.mapper.PoetryFormMapper;
import net.yunzhanyi.domain.mapper.RhymeBookMapper;
import net.yunzhanyi.domain.mapper.RhymeMapper;
import net.yunzhanyi.domain.pojo.PoetryForm;
import net.yunzhanyi.domain.pojo.Rhyme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author bestct
 * @date 2023/5/9
 * description: TODO
 */
@Service
public class RhymeServiceImpl implements RhymeService {
    private static final int PING = 0;
    private static final int ZE = 1;
    private static final char N = ';';
    private static final char K = ',';
    private static final char P = '0';
    private static final char Z = '1';
    private static final char PA = '2';
    private static final char ZA = '3';
    private static final char PY = '4';
    private static final char ZY = '5';
    private static final String[] rhymeBookName = {"平水韵", "词林正韵", "中华新韵", "中华通韵"};
    @Autowired
    private RhymeBookMapper rhymeBookMapper;

    @Autowired
    private RhymeMapper rhymeMapper;

    @Autowired
    private PoetryFormMapper poetryFormMapper;

    @Override
    public CheckResultVo checkRhyme(RhymeCheckVo rhymeCheckVo) {
        String contentFilter = contentFilter(rhymeCheckVo.getCheckContent());
        Integer rhymeBookId = rhymeCheckVo.getRhymeBookId();
        List<Rhyme> rhymeList = rhymeMapper.selectByRhymeBookId(rhymeBookId);
        PoetryForm poetryForm = poetryFormMapper.selectByType(rhymeCheckVo.getFormType(), rhymeCheckVo.getFirstType());
        if (contentFilter.length() != poetryForm.getFormsNum()) {
            throw new RuntimeException("字数不符合，需要 " + poetryForm.getFormsNum() + " 字，您输入了" + contentFilter.length() + "个字。");
        }
        String formsCode = poetryForm.getFormsCode();
        return analysePoetry(formsCode, rhymeList, contentFilter);
    }

    @Override
    public Map<Integer, RhymeBookVo> searchRhyme(String hanZi) {
        String contentFilter = contentFilter(hanZi);
        if (contentFilter.length() != 1) {
            throw new RuntimeException("只能输入一个汉字");
        }
        List<Rhyme> rhymeList = rhymeMapper.selectByHanZi(hanZi);
        Map<Integer, RhymeBookVo> rhymeBookVoMap = new HashMap<>();
        for (Rhyme rhyme : rhymeList) {
            Integer rhymeBookId = rhyme.getRhymeBookId();
            String rhymeName = rhymeBookName[rhymeBookId - 1];
            RhymeBookVo orDefault = rhymeBookVoMap.getOrDefault(rhymeBookId, null);
            if (ObjectUtil.isEmpty(orDefault)) {
                orDefault = new RhymeBookVo();
                orDefault.setRhymeBookName(rhymeName);
                rhymeBookVoMap.put(rhymeBookId, orDefault);
            }
            String replace = rhyme.getRhymeCharacter().replace(hanZi, "<span  style='color:#b40000'>" + hanZi + "</span>");
            rhyme.setRhymeCharacter(replace);
            orDefault.getRhymeList().add(rhyme);
        }
        return rhymeBookVoMap;
    }


    private CheckResultVo analysePoetry(String formsCode, List<Rhyme> rhymeList, String contentFilter) {
        List<YunZi> shiList = new ArrayList<>();
        Set<Character> duoYinSet = new HashSet<>();
        List<PingZeError> pingZeErrors = new ArrayList<>();
        StringBuilder shiSB = new StringBuilder();
        int index = 0;
        YunZi yunZi = new YunZi();
        int rhymeSum = 0;
        char[] chars = formsCode.toCharArray();
        Map<String, Integer> rhymeMap = new HashMap<>();
        int hang = 1;
        int lie = 1;
        //遍历格律代码
        for (char c : chars) {
            if (c != N && c != K) {
                CharCheck charCheck = null;
                char charAt = contentFilter.charAt(index);
                switch (c) {
                    case P:
                        charCheck = checkPing(charAt, false, rhymeList);
                        break;
                    case Z:
                        charCheck = checkZe(charAt, false, rhymeList);
                        break;
                    case PA:
                        charCheck = checkPing(charAt, true, rhymeList);
                        break;
                    case ZA:
                        charCheck = checkZe(charAt, true, rhymeList);
                        break;
                    case PY:
                        charCheck = checkPingYun(charAt, rhymeList);
                        break;
                    case ZY:
                        charCheck = checkZeYun(charAt, rhymeList);
                        break;
                    default:
                }
                assert charCheck != null;
                char hanZi = charCheck.getHanZi();
                if (charCheck.isDuo()) {
                    duoYinSet.add(hanZi);
                    shiSB.append("<span style='color: rgb(52, 91, 114);'>").append(hanZi).append("</span>");
                } else {
                    if (charCheck.isPingZeFlag()) {
                        shiSB.append(hanZi);
                    } else {
                        PingZeError pingZeError = new PingZeError();
                        pingZeError.setHang(hang);
                        pingZeError.setLie(lie);
                        if (PING == charCheck.getPingZe()) {
                            pingZeError.setDes("<span style='color:blue'>" + hanZi + "&nbsp;</span>:应平");
                            shiSB.append("<span style='color:blue'>").append(hanZi).append("</span>");
                        } else {
                            pingZeError.setDes(" <span style='color:red'>" + hanZi + "&nbsp;</span>:应仄");
                            shiSB.append("<span style='color:red'>").append(hanZi).append("</span>");
                        }
                        pingZeErrors.add(pingZeError);
                    }
                }

                if (charCheck.isYun()) {
                    rhymeSum++;
                    yunZi.setZi(charCheck.getHanZi());
                    List<String> rhymeNameList = charCheck.getRhymeNameList();
                    for (String s : rhymeNameList) {
                        Integer integer = rhymeMap.get(s);
                        if (integer == null || integer == 0) {
                            integer = 0;
                        }
                        rhymeMap.put(s, integer + 1);
                    }

                    yunZi.setYunBu(rhymeNameList);
                }
                index++;
                lie++;
            } else {
                hang++;
                lie = 1;
                yunZi.setShiJu(shiSB.toString());
                shiList.add(yunZi);
                shiSB = new StringBuilder();
                yunZi = new YunZi();
            }
        }
        yunZi.setShiJu(shiSB.toString());
        shiList.add(yunZi);
        //得出压的韵部
        String rhyme = null;
        for (Map.Entry<String, Integer> entry : rhymeMap.entrySet()) {
            if (entry.getValue() > rhymeSum / 2) {
                rhyme = entry.getKey();
                break;
            }
        }
        StringBuilder shi = new StringBuilder();
        for (int i = 0; i < shiList.size(); i++) {
            YunZi yun = shiList.get(i);
            shi.append(yun.getShiJu());
            List<String> yunBuList = yun.getYunBu();
            if (yunBuList != null && yunBuList.size() != 0) {
                shi.append(" ").append(yun.getZi()).append(":").append(yunBuList);
                if (rhyme != null) {
                    boolean isYa = false;
                    for (String yunBu : yunBuList) {
                        if (rhyme.equals(yunBu)) {
                            isYa = true;
                            break;
                        }
                    }
                    if (isYa) {
                        shi.append("&nbsp;<span style='color:green'>押韵</span>");
                    } else {
                        shi.append("&nbsp;<span style='color:red'>出韵</span>");
                    }
                }
            }
            if (i < shiList.size() - 1) {
                shi.append("<br/>");
            }
        }

        StringBuilder suggestSb = new StringBuilder();
        if (!pingZeErrors.isEmpty()) {
            suggestSb.append("平仄存在").append(pingZeErrors.size()).append("个问题:").append("<br/>");
            for (PingZeError pingZeError : pingZeErrors) {
                suggestSb.append("第").append(pingZeError.getHang()).append("行").append("第").append(pingZeError.getLie()).append("个字").append(pingZeError.getDes()).append("<br/>");
            }
        } else {
            suggestSb.append("仄符合要求，请留意多音字！").append("<br/>");
        }
        if (!duoYinSet.isEmpty()) {
            suggestSb.append("存在多音字:");
            duoYinSet.forEach(character -> {
                suggestSb.append("<span style='color: rgb(52, 91, 114);'>&nbsp;").append(character).append("</span>");
            });
            suggestSb.append("，请根据词意判断平仄。");
        }
        CheckResultVo checkResultVo = new CheckResultVo();
        checkResultVo.setCodeResult(shi.toString());
        checkResultVo.setSuggest(suggestSb.toString());
        return checkResultVo;
    }

    private CharCheck checkPing(char c, boolean anyway, List<Rhyme> rhymeList) {
        return checkPingZe(PING, c, anyway, rhymeList);
    }

    private CharCheck checkZe(char c, boolean anyway, List<Rhyme> rhymeList) {
        return checkPingZe(ZE, c, anyway, rhymeList);
    }

    private CharCheck checkPingYun(char c, List<Rhyme> rhymeList) {
        return checkContentChar(PING, c, true, false, rhymeList);
    }

    private CharCheck checkZeYun(char c, List<Rhyme> rhymeList) {
        return checkContentChar(ZE, c, true, false, rhymeList);
    }

    private CharCheck checkPingZe(int pingZe, char c, boolean anyway, List<Rhyme> rhymeList) {
        return checkContentChar(pingZe, c, false, anyway, rhymeList);
    }

    private CharCheck checkContentChar(int pingZe, char c, boolean isYun, boolean anyway, List<Rhyme> rhymeList) {
        int displayCount = 0;
        List<String> rhymeNameList = new ArrayList<>(1);
        boolean pingZeFlag = false;
        //遍历韵书
        for (Rhyme rhyme : rhymeList) {
            String rhymeCharacter = rhyme.getRhymeCharacter();
            for (int i = 0; i < rhymeCharacter.length(); i++) {
                if (c == rhymeCharacter.charAt(i)) {
                    displayCount++;
                    if (isYun) {
                        rhymeNameList.add(rhyme.getRhymeName());
                    }
                    if (anyway) {
                        pingZeFlag = true;
                    } else {
                        if (rhyme.getPingZe() == pingZe) {
                            pingZeFlag = true;
                        }
                    }
                    break;
                }
            }
        }

        return new CharCheck(c, displayCount > 1, pingZeFlag, pingZe, rhymeNameList, isYun);
    }

    /**
     * 内容过滤器
     *
     * @param content
     * @return
     */
    private String contentFilter(String content) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if (Character.UnicodeScript.of(c) == Character.UnicodeScript.HAN) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

}
