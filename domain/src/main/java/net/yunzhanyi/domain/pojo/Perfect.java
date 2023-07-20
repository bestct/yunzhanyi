package net.yunzhanyi.domain.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName perfect
 */
@Data
public class Perfect implements Serializable {
    /**
     * 建议id
     */
    private Long perfectId;

    /**
     * 用户id
     */
    private Long aid;

    /**
     * 建议标题
     */
    private String perfectTitle;

    /**
     * 建议内容
     */
    private String perfectContent;

    /**
     * 建议类型(0:网站建议,1:完善诗词,2:完善作者)
     */
    private Integer perfectType;

    /**
     * 提出时间
     */
    private Date createTime;

    /**
     * 建议状态(0:未查看,1:已查看)
     */
    private Integer perfectStatus;

    /**
     * 处理时间
     */
    private Date dealTime;

    private static final long serialVersionUID = 1L;

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
        Perfect other = (Perfect) that;
        return (this.getPerfectId() == null ? other.getPerfectId() == null : this.getPerfectId().equals(other.getPerfectId()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getPerfectTitle() == null ? other.getPerfectTitle() == null : this.getPerfectTitle().equals(other.getPerfectTitle()))
            && (this.getPerfectContent() == null ? other.getPerfectContent() == null : this.getPerfectContent().equals(other.getPerfectContent()))
            && (this.getPerfectType() == null ? other.getPerfectType() == null : this.getPerfectType().equals(other.getPerfectType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getPerfectStatus() == null ? other.getPerfectStatus() == null : this.getPerfectStatus().equals(other.getPerfectStatus()))
            && (this.getDealTime() == null ? other.getDealTime() == null : this.getDealTime().equals(other.getDealTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPerfectId() == null) ? 0 : getPerfectId().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getPerfectTitle() == null) ? 0 : getPerfectTitle().hashCode());
        result = prime * result + ((getPerfectContent() == null) ? 0 : getPerfectContent().hashCode());
        result = prime * result + ((getPerfectType() == null) ? 0 : getPerfectType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getPerfectStatus() == null) ? 0 : getPerfectStatus().hashCode());
        result = prime * result + ((getDealTime() == null) ? 0 : getDealTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", perfectId=").append(perfectId);
        sb.append(", aid=").append(aid);
        sb.append(", perfectTitle=").append(perfectTitle);
        sb.append(", perfectContent=").append(perfectContent);
        sb.append(", perfectType=").append(perfectType);
        sb.append(", createTime=").append(createTime);
        sb.append(", perfectStatus=").append(perfectStatus);
        sb.append(", dealTime=").append(dealTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
