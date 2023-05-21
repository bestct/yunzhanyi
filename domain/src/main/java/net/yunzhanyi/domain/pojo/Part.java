package net.yunzhanyi.domain.pojo;

import java.io.Serializable;

/**
 * 
 * @TableName part
 */
public class Part implements Serializable {
    /**
     * 名句主键
     */
    private Long partId;

    /**
     * 名句内容
     */
    private String partContent;

    /**
     * 原诗词
     */
    private String source;

    /**
     * 诗词id
     */
    private Long poetryId;

    private static final long serialVersionUID = 1L;

    /**
     * 名句主键
     */
    public Long getPartId() {
        return partId;
    }

    /**
     * 名句主键
     */
    public void setPartId(Long partId) {
        this.partId = partId;
    }

    /**
     * 名句内容
     */
    public String getPartContent() {
        return partContent;
    }

    /**
     * 名句内容
     */
    public void setPartContent(String partContent) {
        this.partContent = partContent;
    }

    /**
     * 原诗词
     */
    public String getSource() {
        return source;
    }

    /**
     * 原诗词
     */
    public void setSource(String source) {
        this.source = source;
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
        Part other = (Part) that;
        return (this.getPartId() == null ? other.getPartId() == null : this.getPartId().equals(other.getPartId()))
            && (this.getPartContent() == null ? other.getPartContent() == null : this.getPartContent().equals(other.getPartContent()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getPoetryId() == null ? other.getPoetryId() == null : this.getPoetryId().equals(other.getPoetryId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPartId() == null) ? 0 : getPartId().hashCode());
        result = prime * result + ((getPartContent() == null) ? 0 : getPartContent().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getPoetryId() == null) ? 0 : getPoetryId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", partId=").append(partId);
        sb.append(", partContent=").append(partContent);
        sb.append(", source=").append(source);
        sb.append(", poetryId=").append(poetryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}