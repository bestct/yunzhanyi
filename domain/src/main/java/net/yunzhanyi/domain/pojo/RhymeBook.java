package net.yunzhanyi.domain.pojo;

import java.io.Serializable;

/**
 * 
 * @TableName rhyme_book
 */
public class RhymeBook implements Serializable {
    /**
     * 韵书id
     */
    private Integer rhymeBookId;

    /**
     * 韵书名
     */
    private String rhymeBookName;

    /**
     * 韵书简介
     */
    private String rhymeBookInfo;

    private static final long serialVersionUID = 1L;

    /**
     * 韵书id
     */
    public Integer getRhymeBookId() {
        return rhymeBookId;
    }

    /**
     * 韵书id
     */
    public void setRhymeBookId(Integer rhymeBookId) {
        this.rhymeBookId = rhymeBookId;
    }

    /**
     * 韵书名
     */
    public String getRhymeBookName() {
        return rhymeBookName;
    }

    /**
     * 韵书名
     */
    public void setRhymeBookName(String rhymeBookName) {
        this.rhymeBookName = rhymeBookName;
    }

    /**
     * 韵书简介
     */
    public String getRhymeBookInfo() {
        return rhymeBookInfo;
    }

    /**
     * 韵书简介
     */
    public void setRhymeBookInfo(String rhymeBookInfo) {
        this.rhymeBookInfo = rhymeBookInfo;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RhymeBook other = (RhymeBook) that;
        return (this.getRhymeBookId() == null ? other.getRhymeBookId() == null : this.getRhymeBookId().equals(other.getRhymeBookId()))
            && (this.getRhymeBookName() == null ? other.getRhymeBookName() == null : this.getRhymeBookName().equals(other.getRhymeBookName()))
            && (this.getRhymeBookInfo() == null ? other.getRhymeBookInfo() == null : this.getRhymeBookInfo().equals(other.getRhymeBookInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRhymeBookId() == null) ? 0 : getRhymeBookId().hashCode());
        result = prime * result + ((getRhymeBookName() == null) ? 0 : getRhymeBookName().hashCode());
        result = prime * result + ((getRhymeBookInfo() == null) ? 0 : getRhymeBookInfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rhymeBookId=").append(rhymeBookId);
        sb.append(", rhymeBookName=").append(rhymeBookName);
        sb.append(", rhymeBookInfo=").append(rhymeBookInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}