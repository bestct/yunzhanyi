package net.yunzhanyi.client.domain.vo;

/**
 * @author bestct
 * @date 2022/10/3
 * @type 类
 */
public class SexType {
    private String dictName;
    private int dictCode;

    public SexType(String dictName, int dictCode) {
        this.dictName = dictName;
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public int getDictCode() {
        return dictCode;
    }

    public void setDictCode(int dictCode) {
        this.dictCode = dictCode;
    }
}
