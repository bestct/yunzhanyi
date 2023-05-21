package net.yunzhanyi.client.domain.vo;

import java.util.List;

/**
 * @author bestct
 * @date 2022/11/10
 * @type 类
 */
public class YunZi {
    private String shiJu;
    private char zi;
    private List<String> yunBu;

    public String getShiJu() {
        return shiJu;
    }

    public void setShiJu(String shiJu) {
        this.shiJu = shiJu;
    }

    public char getZi() {
        return zi;
    }

    public void setZi(char zi) {
        this.zi = zi;
    }

    public List<String> getYunBu() {
        return yunBu;
    }

    public void setYunBu(List<String> yunBu) {
        this.yunBu = yunBu;
    }
}
