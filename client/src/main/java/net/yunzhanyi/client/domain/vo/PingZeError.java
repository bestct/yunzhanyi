package net.yunzhanyi.client.domain.vo;

/**
 * @author bestct
 * @date 2022/11/11
 * @type 类
 */
public class PingZeError {
    private int hang;
    private int lie;
    private String des;

    public int getHang() {
        return hang;
    }

    public void setHang(int hang) {
        this.hang = hang;
    }

    public int getLie() {
        return lie;
    }

    public void setLie(int lie) {
        this.lie = lie;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
