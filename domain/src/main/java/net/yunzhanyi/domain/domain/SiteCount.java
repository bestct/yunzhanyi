package net.yunzhanyi.domain.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName site_count
 */
public class SiteCount implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 收集日期
     */
    private Date collectionDate;

    /**
     * 页面访问次数
     */
    private Integer pv;

    /**
     * 用户访问数
     */
    private Integer uv;

    /**
     * 独立ip访问数
     */
    private Integer ip;

    /**
     * 总页面访问数
     */
    private Integer sumPv;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 收集日期
     */
    public Date getCollectionDate() {
        return collectionDate;
    }

    /**
     * 收集日期
     */
    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    /**
     * 页面访问次数
     */
    public Integer getPv() {
        return pv;
    }

    /**
     * 页面访问次数
     */
    public void setPv(Integer pv) {
        this.pv = pv;
    }

    /**
     * 用户访问数
     */
    public Integer getUv() {
        return uv;
    }

    /**
     * 用户访问数
     */
    public void setUv(Integer uv) {
        this.uv = uv;
    }

    /**
     * 独立ip访问数
     */
    public Integer getIp() {
        return ip;
    }

    /**
     * 独立ip访问数
     */
    public void setIp(Integer ip) {
        this.ip = ip;
    }

    /**
     * 总页面访问数
     */
    public Integer getSumPv() {
        return sumPv;
    }

    /**
     * 总页面访问数
     */
    public void setSumPv(Integer sumPv) {
        this.sumPv = sumPv;
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
        SiteCount other = (SiteCount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCollectionDate() == null ? other.getCollectionDate() == null : this.getCollectionDate().equals(other.getCollectionDate()))
            && (this.getPv() == null ? other.getPv() == null : this.getPv().equals(other.getPv()))
            && (this.getUv() == null ? other.getUv() == null : this.getUv().equals(other.getUv()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getSumPv() == null ? other.getSumPv() == null : this.getSumPv().equals(other.getSumPv()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCollectionDate() == null) ? 0 : getCollectionDate().hashCode());
        result = prime * result + ((getPv() == null) ? 0 : getPv().hashCode());
        result = prime * result + ((getUv() == null) ? 0 : getUv().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getSumPv() == null) ? 0 : getSumPv().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", collectionDate=").append(collectionDate);
        sb.append(", pv=").append(pv);
        sb.append(", uv=").append(uv);
        sb.append(", ip=").append(ip);
        sb.append(", sumPv=").append(sumPv);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}