package net.yunzhanyi.domain.pojo;

import java.io.Serializable;

/**
 * 
 * @TableName rhyme
 */
public class Rhyme implements Serializable {
    /**
     * 韵部id
     */
    private Integer rhymeId;

    /**
     * 韵部名
     */
    private String rhymeName;

    /**
     * 韵字
     */
    private String rhymeCharacter;

    /**
     * 平仄(0: 平;1:仄)
     */
    private Integer pingZe;

    /**
     * 所属韵书id
     */
    private Integer rhymeBookId;

    private static final long serialVersionUID = 1L;

    /**
     * 韵部id
     */
    public Integer getRhymeId() {
        return rhymeId;
    }

    /**
     * 韵部id
     */
    public void setRhymeId(Integer rhymeId) {
        this.rhymeId = rhymeId;
    }

    /**
     * 韵部名
     */
    public String getRhymeName() {
        return rhymeName;
    }

    /**
     * 韵部名
     */
    public void setRhymeName(String rhymeName) {
        this.rhymeName = rhymeName;
    }

    /**
     * 韵字
     */
    public String getRhymeCharacter() {
        return rhymeCharacter;
    }

    /**
     * 韵字
     */
    public void setRhymeCharacter(String rhymeCharacter) {
        this.rhymeCharacter = rhymeCharacter;
    }

    /**
     * 平仄(0: 平;1:仄)
     */
    public Integer getPingZe() {
        return pingZe;
    }

    /**
     * 平仄(0: 平;1:仄)
     */
    public void setPingZe(Integer pingZe) {
        this.pingZe = pingZe;
    }

    /**
     * 所属韵书id
     */
    public Integer getRhymeBookId() {
        return rhymeBookId;
    }

    /**
     * 所属韵书id
     */
    public void setRhymeBookId(Integer rhymeBookId) {
        this.rhymeBookId = rhymeBookId;
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
        Rhyme other = (Rhyme) that;
        return (this.getRhymeId() == null ? other.getRhymeId() == null : this.getRhymeId().equals(other.getRhymeId()))
            && (this.getRhymeName() == null ? other.getRhymeName() == null : this.getRhymeName().equals(other.getRhymeName()))
            && (this.getRhymeCharacter() == null ? other.getRhymeCharacter() == null : this.getRhymeCharacter().equals(other.getRhymeCharacter()))
            && (this.getPingZe() == null ? other.getPingZe() == null : this.getPingZe().equals(other.getPingZe()))
            && (this.getRhymeBookId() == null ? other.getRhymeBookId() == null : this.getRhymeBookId().equals(other.getRhymeBookId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRhymeId() == null) ? 0 : getRhymeId().hashCode());
        result = prime * result + ((getRhymeName() == null) ? 0 : getRhymeName().hashCode());
        result = prime * result + ((getRhymeCharacter() == null) ? 0 : getRhymeCharacter().hashCode());
        result = prime * result + ((getPingZe() == null) ? 0 : getPingZe().hashCode());
        result = prime * result + ((getRhymeBookId() == null) ? 0 : getRhymeBookId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rhymeId=").append(rhymeId);
        sb.append(", rhymeName=").append(rhymeName);
        sb.append(", rhymeCharacter=").append(rhymeCharacter);
        sb.append(", pingZe=").append(pingZe);
        sb.append(", rhymeBookId=").append(rhymeBookId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}