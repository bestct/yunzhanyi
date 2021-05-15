package net.yunzhanyi.common.model;

import java.io.Serializable;

/**
 * @author TingChang
 */
public class Writing implements Serializable {
    /**
     * 作品的编号
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 作品的标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 作品的朝代
     *
     * @mbg.generated
     */
    private String dynasty;

    /**
     * 作品的作者名
     *
     * @mbg.generated
     */
    private String author;

    /**
     * 作品的文集名
     *
     * @mbg.generated
     */
    private String corpus;

    /**
     * 作品的题材
     *
     * @mbg.generated
     */
    private String type;

    /**
     * 作品的片段
     *
     * @mbg.generated
     */
    private String part;

    /**
     * 作品标签
     *
     * @mbg.generated
     */
    private String tags;

    /**
     * 作者id
     *
     * @mbg.generated
     */
    private Integer authorId;

    /**
     * 所属文集id
     *
     * @mbg.generated
     */
    private Integer corpusId;

    /**
     * 作品的内容
     *
     * @mbg.generated
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCorpus() {
        return corpus;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getCorpusId() {
        return corpusId;
    }

    public void setCorpusId(Integer corpusId) {
        this.corpusId = corpusId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", dynasty=").append(dynasty);
        sb.append(", author=").append(author);
        sb.append(", corpus=").append(corpus);
        sb.append(", type=").append(type);
        sb.append(", part=").append(part);
        sb.append(", tags=").append(tags);
        sb.append(", authorId=").append(authorId);
        sb.append(", corpusId=").append(corpusId);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}