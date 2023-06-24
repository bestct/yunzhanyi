package net.yunzhanyi.domain.pojo;

import java.io.Serializable;

/**
 *
 * @TableName author
 */
public class Author implements Serializable {
    /**
     * 作者主键
     */
    private Long id;

    /**
     * 作者姓名
     */
    private String authorName;

    /**
     * 作者朝代
     */
    private String authorDynasty;

    /**
     * 作者简介
     */
    private String info;

    /**
     * 朝代id
     */
    private Integer dynastyId;

    /**
     * 收录数目
     */
    private Integer recordCount;

    private static final long serialVersionUID = 1L;

    /**
     * 作者主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 作者主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 作者姓名
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * 作者姓名
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * 作者朝代
     */
    public String getAuthorDynasty() {
        return authorDynasty;
    }

    /**
     * 作者朝代
     */
    public void setAuthorDynasty(String authorDynasty) {
        this.authorDynasty = authorDynasty;
    }

    /**
     * 作者简介
     */
    public String getInfo() {
        return info;
    }

    /**
     * 作者简介
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 朝代id
     */
    public Integer getDynastyId() {
        return dynastyId;
    }

    /**
     * 朝代id
     */
    public void setDynastyId(Integer dynastyId) {
        this.dynastyId = dynastyId;
    }

    /**
     * 收录数目
     */
    public Integer getRecordCount() {
        return recordCount;
    }

    /**
     * 收录数目
     */
    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
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
        Author other = (Author) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAuthorName() == null ? other.getAuthorName() == null : this.getAuthorName().equals(other.getAuthorName()))
            && (this.getAuthorDynasty() == null ? other.getAuthorDynasty() == null : this.getAuthorDynasty().equals(other.getAuthorDynasty()))
            && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()))
            && (this.getDynastyId() == null ? other.getDynastyId() == null : this.getDynastyId().equals(other.getDynastyId()))
            && (this.getRecordCount() == null ? other.getRecordCount() == null : this.getRecordCount().equals(other.getRecordCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAuthorName() == null) ? 0 : getAuthorName().hashCode());
        result = prime * result + ((getAuthorDynasty() == null) ? 0 : getAuthorDynasty().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        result = prime * result + ((getDynastyId() == null) ? 0 : getDynastyId().hashCode());
        result = prime * result + ((getRecordCount() == null) ? 0 : getRecordCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", authorName=").append(authorName);
        sb.append(", authorDynasty=").append(authorDynasty);
        sb.append(", info=").append(info);
        sb.append(", dynastyId=").append(dynastyId);
        sb.append(", recordCount=").append(recordCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
