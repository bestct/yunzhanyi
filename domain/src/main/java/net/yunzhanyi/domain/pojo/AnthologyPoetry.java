package net.yunzhanyi.domain.pojo;

import java.io.Serializable;

/**
 * 
 * @TableName anthology_poetry
 */
public class AnthologyPoetry implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 合集id
     */
    private Integer anthologyId;

    /**
     * 诗词id
     */
    private Long poetryId;

    /**
     * 诗词标题
     */
    private String poetryTitle;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 合集id
     */
    public Integer getAnthologyId() {
        return anthologyId;
    }

    /**
     * 合集id
     */
    public void setAnthologyId(Integer anthologyId) {
        this.anthologyId = anthologyId;
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

    /**
     * 诗词标题
     */
    public String getPoetryTitle() {
        return poetryTitle;
    }

    /**
     * 诗词标题
     */
    public void setPoetryTitle(String poetryTitle) {
        this.poetryTitle = poetryTitle;
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
        AnthologyPoetry other = (AnthologyPoetry) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAnthologyId() == null ? other.getAnthologyId() == null : this.getAnthologyId().equals(other.getAnthologyId()))
            && (this.getPoetryId() == null ? other.getPoetryId() == null : this.getPoetryId().equals(other.getPoetryId()))
            && (this.getPoetryTitle() == null ? other.getPoetryTitle() == null : this.getPoetryTitle().equals(other.getPoetryTitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAnthologyId() == null) ? 0 : getAnthologyId().hashCode());
        result = prime * result + ((getPoetryId() == null) ? 0 : getPoetryId().hashCode());
        result = prime * result + ((getPoetryTitle() == null) ? 0 : getPoetryTitle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", anthologyId=").append(anthologyId);
        sb.append(", poetryId=").append(poetryId);
        sb.append(", poetryTitle=").append(poetryTitle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}