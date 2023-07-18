package net.yunzhanyi.domain.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName client_collection
 */
@Data
public class ClientCollection implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 收藏类型
     */
    private Integer collectionType;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 资源id
     */
    private Long resId;

    /**
     * 收藏时间
     */
    private Date collectionTime;

    /**
     * 收藏状态
     */
    private Integer collectionStatus;

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
        ClientCollection other = (ClientCollection) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCollectionType() == null ? other.getCollectionType() == null : this.getCollectionType().equals(other.getCollectionType()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getResId() == null ? other.getResId() == null : this.getResId().equals(other.getResId()))
            && (this.getCollectionTime() == null ? other.getCollectionTime() == null : this.getCollectionTime().equals(other.getCollectionTime()))
            && (this.getCollectionStatus() == null ? other.getCollectionStatus() == null : this.getCollectionStatus().equals(other.getCollectionStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCollectionType() == null) ? 0 : getCollectionType().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getResId() == null) ? 0 : getResId().hashCode());
        result = prime * result + ((getCollectionTime() == null) ? 0 : getCollectionTime().hashCode());
        result = prime * result + ((getCollectionStatus() == null) ? 0 : getCollectionStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", collectionType=").append(collectionType);
        sb.append(", userId=").append(userId);
        sb.append(", resId=").append(resId);
        sb.append(", collectionTime=").append(collectionTime);
        sb.append(", collectionStatus=").append(collectionStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
