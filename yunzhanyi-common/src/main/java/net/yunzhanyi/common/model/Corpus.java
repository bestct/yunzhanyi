package net.yunzhanyi.common.model;

import java.io.Serializable;

public class Corpus implements Serializable {
    /**
     * 文集的id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 文集名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 文集的朝代
     *
     * @mbg.generated
     */
    private String dynasty;

    /**
     * 文集的介绍
     *
     * @mbg.generated
     */
    private String introduction;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", dynasty=").append(dynasty);
        sb.append(", introduction=").append(introduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}