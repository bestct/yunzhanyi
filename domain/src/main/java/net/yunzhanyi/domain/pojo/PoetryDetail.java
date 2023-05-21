package net.yunzhanyi.domain.pojo;

import java.io.Serializable;

/**
 * 
 * @TableName poetry_detail
 */
public class PoetryDetail implements Serializable {
    /**
     * 详情id
     */
    private Long detailId;

    /**
     * 详情类型
     */
    private String detailType;

    /**
     * 详情内容
     */
    private String detailContent;

    /**
     * 诗词id
     */
    private Long poetryId;

    private static final long serialVersionUID = 1L;

    /**
     * 详情id
     */
    public Long getDetailId() {
        return detailId;
    }

    /**
     * 详情id
     */
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    /**
     * 详情类型
     */
    public String getDetailType() {
        return detailType;
    }

    /**
     * 详情类型
     */
    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }

    /**
     * 详情内容
     */
    public String getDetailContent() {
        return detailContent;
    }

    /**
     * 详情内容
     */
    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    /**
     * 诗词id
     */
    public Long getPoetryId() {
        return poetryId;
    }

    /**
     * 诗词id
     */
    public void setPoetryId(Long poetryId) {
        this.poetryId = poetryId;
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
        PoetryDetail other = (PoetryDetail) that;
        return (this.getDetailId() == null ? other.getDetailId() == null : this.getDetailId().equals(other.getDetailId()))
            && (this.getDetailType() == null ? other.getDetailType() == null : this.getDetailType().equals(other.getDetailType()))
            && (this.getDetailContent() == null ? other.getDetailContent() == null : this.getDetailContent().equals(other.getDetailContent()))
            && (this.getPoetryId() == null ? other.getPoetryId() == null : this.getPoetryId().equals(other.getPoetryId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDetailId() == null) ? 0 : getDetailId().hashCode());
        result = prime * result + ((getDetailType() == null) ? 0 : getDetailType().hashCode());
        result = prime * result + ((getDetailContent() == null) ? 0 : getDetailContent().hashCode());
        result = prime * result + ((getPoetryId() == null) ? 0 : getPoetryId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", detailId=").append(detailId);
        sb.append(", detailType=").append(detailType);
        sb.append(", detailContent=").append(detailContent);
        sb.append(", poetryId=").append(poetryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}