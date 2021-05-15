package net.yunzhanyi.common.model;

import java.io.Serializable;

public class Authority implements Serializable {
    /**
     * 权限id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 权限名
     *
     * @mbg.generated
     */
    private String power;

    /**
     * 权限描述
     *
     * @mbg.generated
     */
    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", power=").append(power);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}