package net.yunzhanyi.domain.pojo;

import java.io.Serializable;

/**
 * 
 * @TableName poetry_form
 */
public class PoetryForm implements Serializable {
    /**
     * 格律id
     */
    private Integer formsId;

    /**
     * 格律名
     */
    private String formsName;

    /**
     * 格律类型
     */
    private Integer formType;

    /**
     * 首句类型
     */
    private Integer firstType;

    /**
     * 格律代码(0:平;1:仄,2:推荐平;3:推荐仄;4:平韵;5:仄韵)
     */
    private String formsCode;

    /**
     * 实例
     */
    private String formsExample;

    /**
     * 字数
     */
    private Integer formsNum;

    private static final long serialVersionUID = 1L;

    /**
     * 格律id
     */
    public Integer getFormsId() {
        return formsId;
    }

    /**
     * 格律id
     */
    public void setFormsId(Integer formsId) {
        this.formsId = formsId;
    }

    /**
     * 格律名
     */
    public String getFormsName() {
        return formsName;
    }

    /**
     * 格律名
     */
    public void setFormsName(String formsName) {
        this.formsName = formsName;
    }

    /**
     * 格律类型
     */
    public Integer getFormType() {
        return formType;
    }

    /**
     * 格律类型
     */
    public void setFormType(Integer formType) {
        this.formType = formType;
    }

    /**
     * 首句类型
     */
    public Integer getFirstType() {
        return firstType;
    }

    /**
     * 首句类型
     */
    public void setFirstType(Integer firstType) {
        this.firstType = firstType;
    }

    /**
     * 格律代码(0:平;1:仄,2:推荐平;3:推荐仄;4:平韵;5:仄韵)
     */
    public String getFormsCode() {
        return formsCode;
    }

    /**
     * 格律代码(0:平;1:仄,2:推荐平;3:推荐仄;4:平韵;5:仄韵)
     */
    public void setFormsCode(String formsCode) {
        this.formsCode = formsCode;
    }

    /**
     * 实例
     */
    public String getFormsExample() {
        return formsExample;
    }

    /**
     * 实例
     */
    public void setFormsExample(String formsExample) {
        this.formsExample = formsExample;
    }

    /**
     * 字数
     */
    public Integer getFormsNum() {
        return formsNum;
    }

    /**
     * 字数
     */
    public void setFormsNum(Integer formsNum) {
        this.formsNum = formsNum;
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
        PoetryForm other = (PoetryForm) that;
        return (this.getFormsId() == null ? other.getFormsId() == null : this.getFormsId().equals(other.getFormsId()))
            && (this.getFormsName() == null ? other.getFormsName() == null : this.getFormsName().equals(other.getFormsName()))
            && (this.getFormType() == null ? other.getFormType() == null : this.getFormType().equals(other.getFormType()))
            && (this.getFirstType() == null ? other.getFirstType() == null : this.getFirstType().equals(other.getFirstType()))
            && (this.getFormsCode() == null ? other.getFormsCode() == null : this.getFormsCode().equals(other.getFormsCode()))
            && (this.getFormsExample() == null ? other.getFormsExample() == null : this.getFormsExample().equals(other.getFormsExample()))
            && (this.getFormsNum() == null ? other.getFormsNum() == null : this.getFormsNum().equals(other.getFormsNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFormsId() == null) ? 0 : getFormsId().hashCode());
        result = prime * result + ((getFormsName() == null) ? 0 : getFormsName().hashCode());
        result = prime * result + ((getFormType() == null) ? 0 : getFormType().hashCode());
        result = prime * result + ((getFirstType() == null) ? 0 : getFirstType().hashCode());
        result = prime * result + ((getFormsCode() == null) ? 0 : getFormsCode().hashCode());
        result = prime * result + ((getFormsExample() == null) ? 0 : getFormsExample().hashCode());
        result = prime * result + ((getFormsNum() == null) ? 0 : getFormsNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", formsId=").append(formsId);
        sb.append(", formsName=").append(formsName);
        sb.append(", formType=").append(formType);
        sb.append(", firstType=").append(firstType);
        sb.append(", formsCode=").append(formsCode);
        sb.append(", formsExample=").append(formsExample);
        sb.append(", formsNum=").append(formsNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}