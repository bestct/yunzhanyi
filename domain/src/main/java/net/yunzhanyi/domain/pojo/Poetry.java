package net.yunzhanyi.domain.pojo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @TableName poetry
 */
public class Poetry implements Serializable {
    /**
     * 诗词主键
     */
    private Long poetryId;

    /**
     * 诗词标题
     */
    private String poetryTitle;

    /**
     * 诗词朝代
     */
    private String poetryDynasty;

    /**
     * 诗词类型
     */
    private String poetryType;

    /**
     * 诗词作者
     */
    private String poetryAuthor;

    /**
     * 诗词内容
     */
    private String poetryContent;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 标签集合
     */
    private String tags;

    /**
     * 诗词
     */
    private Integer dynastyId;

    private static final long serialVersionUID = 1L;

    /**
     * 诗歌细节
     */
    private List<PoetryDetail> poetryDetails;

    /**
     * 诗词主键
     */
    public Long getPoetryId() {
        return poetryId;
    }

    /**
     * 诗词主键
     */
    public void setPoetryId(Long poetryId) {
        this.poetryId = poetryId;
    }

    /**
     * 诗词标题
     */
    public String getPoetryTitle() {
        return poetryTitle;
    }

    /**
     * 诗词标题
     */
    public void setPoetryTitle(String poetryTitle) {
        this.poetryTitle = poetryTitle;
    }

    /**
     * 诗词朝代
     */
    public String getPoetryDynasty() {
        return poetryDynasty;
    }

    /**
     * 诗词朝代
     */
    public void setPoetryDynasty(String poetryDynasty) {
        this.poetryDynasty = poetryDynasty;
    }

    /**
     * 诗词类型
     */
    public String getPoetryType() {
        return poetryType;
    }

    /**
     * 诗词类型
     */
    public void setPoetryType(String poetryType) {
        this.poetryType = poetryType;
    }

    /**
     * 诗词作者
     */
    public String getPoetryAuthor() {
        return poetryAuthor;
    }

    /**
     * 诗词作者
     */
    public void setPoetryAuthor(String poetryAuthor) {
        this.poetryAuthor = poetryAuthor;
    }

    /**
     * 诗词内容
     */
    public String getPoetryContent() {
        return poetryContent;
    }

    /**
     * 诗词内容
     */
    public void setPoetryContent(String poetryContent) {
        this.poetryContent = poetryContent;
    }

    /**
     * 作者id
     */
    public Long getAuthorId() {
        return authorId;
    }

    /**
     * 作者id
     */
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    /**
     * 标签集合
     */
    public String getTags() {
        return tags;
    }

    /**
     * 标签集合
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 诗词
     */
    public Integer getDynastyId() {
        return dynastyId;
    }

    /**
     * 诗词
     */
    public void setDynastyId(Integer dynastyId) {
        this.dynastyId = dynastyId;
    }


    public List<PoetryDetail> getPoetryDetails() {
        return poetryDetails;
    }

    public void setPoetryDetails(List<PoetryDetail> poetryDetails) {
        this.poetryDetails = poetryDetails;
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
        Poetry other = (Poetry) that;
        return (this.getPoetryId() == null ? other.getPoetryId() == null : this.getPoetryId().equals(other.getPoetryId()))
            && (this.getPoetryTitle() == null ? other.getPoetryTitle() == null : this.getPoetryTitle().equals(other.getPoetryTitle()))
            && (this.getPoetryDynasty() == null ? other.getPoetryDynasty() == null : this.getPoetryDynasty().equals(other.getPoetryDynasty()))
            && (this.getPoetryType() == null ? other.getPoetryType() == null : this.getPoetryType().equals(other.getPoetryType()))
            && (this.getPoetryAuthor() == null ? other.getPoetryAuthor() == null : this.getPoetryAuthor().equals(other.getPoetryAuthor()))
            && (this.getPoetryContent() == null ? other.getPoetryContent() == null : this.getPoetryContent().equals(other.getPoetryContent()))
            && (this.getAuthorId() == null ? other.getAuthorId() == null : this.getAuthorId().equals(other.getAuthorId()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getDynastyId() == null ? other.getDynastyId() == null : this.getDynastyId().equals(other.getDynastyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPoetryId() == null) ? 0 : getPoetryId().hashCode());
        result = prime * result + ((getPoetryTitle() == null) ? 0 : getPoetryTitle().hashCode());
        result = prime * result + ((getPoetryDynasty() == null) ? 0 : getPoetryDynasty().hashCode());
        result = prime * result + ((getPoetryType() == null) ? 0 : getPoetryType().hashCode());
        result = prime * result + ((getPoetryAuthor() == null) ? 0 : getPoetryAuthor().hashCode());
        result = prime * result + ((getPoetryContent() == null) ? 0 : getPoetryContent().hashCode());
        result = prime * result + ((getAuthorId() == null) ? 0 : getAuthorId().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getDynastyId() == null) ? 0 : getDynastyId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", poetryId=").append(poetryId);
        sb.append(", poetryTitle=").append(poetryTitle);
        sb.append(", poetryDynasty=").append(poetryDynasty);
        sb.append(", poetryType=").append(poetryType);
        sb.append(", poetryAuthor=").append(poetryAuthor);
        sb.append(", poetryContent=").append(poetryContent);
        sb.append(", authorId=").append(authorId);
        sb.append(", tags=").append(tags);
        sb.append(", dynastyId=").append(dynastyId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
