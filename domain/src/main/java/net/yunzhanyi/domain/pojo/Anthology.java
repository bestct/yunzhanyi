package net.yunzhanyi.domain.pojo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @TableName anthology
 */
public class Anthology implements Serializable {
    /**
     * 诗集的id
     */
    private Integer anthologyId;

    /**
     * 诗集的父id
     */
    private Integer parentId;

    /**
     * 诗集名字
     */
    private String anthologyName;

    /**
     * 诗集简介
     */
    private String anthologyInfo;

    /**
     * 诗集副标题
     */
    private String subtitle;

    private static final long serialVersionUID = 1L;

    private List<AnthologyPoetry> anthologyPoetryList;


    /**
     * 诗集的id
     */
    public Integer getAnthologyId() {
        return anthologyId;
    }

    /**
     * 诗集的id
     */
    public void setAnthologyId(Integer anthologyId) {
        this.anthologyId = anthologyId;
    }

    /**
     * 诗集的父id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 诗集的父id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 诗集名字
     */
    public String getAnthologyName() {
        return anthologyName;
    }

    /**
     * 诗集名字
     */
    public void setAnthologyName(String anthologyName) {
        this.anthologyName = anthologyName;
    }

    /**
     * 诗集简介
     */
    public String getAnthologyInfo() {
        return anthologyInfo;
    }

    /**
     * 诗集简介
     */
    public void setAnthologyInfo(String anthologyInfo) {
        this.anthologyInfo = anthologyInfo;
    }

    /**
     * 诗集副标题
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * 诗集副标题
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<AnthologyPoetry> getAnthologyPoetryList() {
        return anthologyPoetryList;
    }

    public void setAnthologyPoetryList(List<AnthologyPoetry> anthologyPoetryList) {
        this.anthologyPoetryList = anthologyPoetryList;
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
        Anthology other = (Anthology) that;
        return (this.getAnthologyId() == null ? other.getAnthologyId() == null : this.getAnthologyId().equals(other.getAnthologyId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getAnthologyName() == null ? other.getAnthologyName() == null : this.getAnthologyName().equals(other.getAnthologyName()))
            && (this.getAnthologyInfo() == null ? other.getAnthologyInfo() == null : this.getAnthologyInfo().equals(other.getAnthologyInfo()))
            && (this.getSubtitle() == null ? other.getSubtitle() == null : this.getSubtitle().equals(other.getSubtitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAnthologyId() == null) ? 0 : getAnthologyId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getAnthologyName() == null) ? 0 : getAnthologyName().hashCode());
        result = prime * result + ((getAnthologyInfo() == null) ? 0 : getAnthologyInfo().hashCode());
        result = prime * result + ((getSubtitle() == null) ? 0 : getSubtitle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", anthologyId=").append(anthologyId);
        sb.append(", parentId=").append(parentId);
        sb.append(", anthologyName=").append(anthologyName);
        sb.append(", anthologyInfo=").append(anthologyInfo);
        sb.append(", subtitle=").append(subtitle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
