package net.yunzhanyi.client.domain.vo;


import net.yunzhanyi.domain.pojo.Poetry;

import java.util.List;

/**
 * @author bestct
 * @date 2022/9/30
 * @type 类
 */
public class AuthorVo {
    /**
     * 作者主键
     */
    private Long id;

    /**
     * 作者姓名
     */
    private String authorName;

    /**
     * 作者朝代
     */
    private String authorDynasty;

    /**
     * 作者简介
     */
    private String info;

    /**
     * 朝代id
     */
    private Integer dynastyId;

    /**
     * 记录数目
     */
    private Integer recordCount;

    private Boolean collection;

    List<Poetry> poetryList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorDynasty() {
        return authorDynasty;
    }

    public void setAuthorDynasty(String authorDynasty) {
        this.authorDynasty = authorDynasty;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getDynastyId() {
        return dynastyId;
    }

    public void setDynastyId(Integer dynastyId) {
        this.dynastyId = dynastyId;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }


    public Boolean getCollection() {
        return collection;
    }

    public void setCollection(Boolean collection) {
        this.collection = collection;
    }

    public List<Poetry> getPoetryList() {
        return poetryList;
    }

    public void setPoetryList(List<Poetry> poetryList) {
        this.poetryList = poetryList;
    }
}
