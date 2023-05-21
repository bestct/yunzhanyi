package net.yunzhanyi.domain.pojo;

import java.io.Serializable;

/**
 *
 * @TableName dynasty
 */
public class Dynasty implements Serializable {
    /**
     *
     */
    private Integer dynastyId;

    /**
     *
     */
    private String dynastyName;

    private static final long serialVersionUID = 1L;

    public Dynasty(Integer dynastyId, String dynastyName) {
        this.dynastyId = dynastyId;
        this.dynastyName = dynastyName;
    }

    public Dynasty() {
    }

    /**
     *
     */
    public Integer getDynastyId() {
        return dynastyId;
    }

    /**
     *
     */
    public void setDynastyId(Integer dynastyId) {
        this.dynastyId = dynastyId;
    }

    /**
     *
     */
    public String getDynastyName() {
        return dynastyName;
    }

    /**
     *
     */
    public void setDynastyName(String dynastyName) {
        this.dynastyName = dynastyName;
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
        Dynasty other = (Dynasty) that;
        return (this.getDynastyId() == null ? other.getDynastyId() == null : this.getDynastyId().equals(other.getDynastyId()))
            && (this.getDynastyName() == null ? other.getDynastyName() == null : this.getDynastyName().equals(other.getDynastyName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDynastyId() == null) ? 0 : getDynastyId().hashCode());
        result = prime * result + ((getDynastyName() == null) ? 0 : getDynastyName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dynastyId=").append(dynastyId);
        sb.append(", dynastyName=").append(dynastyName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
