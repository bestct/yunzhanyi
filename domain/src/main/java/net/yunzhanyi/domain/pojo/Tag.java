package net.yunzhanyi.domain.pojo;

import java.io.Serializable;

/**
 *
 * @TableName tag
 */
public class Tag implements Serializable {
    /**
     * 标签主键
     */
    private Integer tagId;

    /**
     * 标签名
     */
    private String tagName;

    private static final long serialVersionUID = 1L;

    public Tag(Integer tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    public Tag() {
    }

    /**
     * 标签主键
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * 标签主键
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * 标签名
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * 标签名
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
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
        Tag other = (Tag) that;
        return (this.getTagId() == null ? other.getTagId() == null : this.getTagId().equals(other.getTagId()))
            && (this.getTagName() == null ? other.getTagName() == null : this.getTagName().equals(other.getTagName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTagId() == null) ? 0 : getTagId().hashCode());
        result = prime * result + ((getTagName() == null) ? 0 : getTagName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tagId=").append(tagId);
        sb.append(", tagName=").append(tagName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
