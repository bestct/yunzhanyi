package net.yunzhanyi.domain.pojo;

import java.io.Serializable;

/**
 * 
 * @TableName poetry_tag_map
 */
public class PoetryTagMap implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Integer tagId;

    /**
     * 
     */
    private Long poetryId;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * 
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * 
     */
    public Long getPoetryId() {
        return poetryId;
    }

    /**
     * 
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
        PoetryTagMap other = (PoetryTagMap) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTagId() == null ? other.getTagId() == null : this.getTagId().equals(other.getTagId()))
            && (this.getPoetryId() == null ? other.getPoetryId() == null : this.getPoetryId().equals(other.getPoetryId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTagId() == null) ? 0 : getTagId().hashCode());
        result = prime * result + ((getPoetryId() == null) ? 0 : getPoetryId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tagId=").append(tagId);
        sb.append(", poetryId=").append(poetryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}