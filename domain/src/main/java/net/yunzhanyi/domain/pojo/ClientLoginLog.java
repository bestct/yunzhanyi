package net.yunzhanyi.domain.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName client_login_log
 */
@Data
public class ClientLoginLog implements Serializable {
    /**
     * 记录ID
     */
    private Long id;

    /**
     * 账号id
     */
    private Long aid;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 登录IP
     */
    private String ip;

    /**
     * IP所在地区
     */
    private String ipLocation;

    /**
     * 登录设备
     */
    private String loginDevice;

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
        ClientLoginLog other = (ClientLoginLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getIpLocation() == null ? other.getIpLocation() == null : this.getIpLocation().equals(other.getIpLocation()))
            && (this.getLoginDevice() == null ? other.getLoginDevice() == null : this.getLoginDevice().equals(other.getLoginDevice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getIpLocation() == null) ? 0 : getIpLocation().hashCode());
        result = prime * result + ((getLoginDevice() == null) ? 0 : getLoginDevice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", aid=").append(aid);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", ip=").append(ip);
        sb.append(", ipLocation=").append(ipLocation);
        sb.append(", loginDevice=").append(loginDevice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
