package net.yunzhanyi.client.domain.vo;

import java.util.List;

/**
 * @author bestct
 * @date 2022/11/9
 * @type 类
 */
public class CharCheck {
    private char hanZi;
    private boolean isDuo;
    private boolean pingZeFlag;
    private int pingZe;
    private List<String> rhymeNameList;
    private boolean isYun;

    public CharCheck(char hanZi, boolean isDuo, boolean pingZeFlag, int pingZe, List<String> rhymeNameList, boolean isYun) {
        this.hanZi = hanZi;
        this.isDuo = isDuo;
        this.pingZeFlag = pingZeFlag;
        this.pingZe = pingZe;
        this.rhymeNameList = rhymeNameList;
        this.isYun = isYun;
    }

    public char getHanZi() {
        return hanZi;
    }

    public void setHanZi(char hanZi) {
        this.hanZi = hanZi;
    }

    public boolean isDuo() {
        return isDuo;
    }

    public void setDuo(boolean duo) {
        isDuo = duo;
    }

    public boolean isPingZeFlag() {
        return pingZeFlag;
    }

    public void setPingZeFlag(boolean pingZeFlag) {
        this.pingZeFlag = pingZeFlag;
    }

    public int getPingZe() {
        return pingZe;
    }

    public void setPingZe(int pingZe) {
        this.pingZe = pingZe;
    }

    public List<String> getRhymeNameList() {
        return rhymeNameList;
    }

    public void setRhymeNameList(List<String> rhymeNameList) {
        this.rhymeNameList = rhymeNameList;
    }

    public boolean isYun() {
        return isYun;
    }

    public void setYun(boolean yun) {
        isYun = yun;
    }
}
