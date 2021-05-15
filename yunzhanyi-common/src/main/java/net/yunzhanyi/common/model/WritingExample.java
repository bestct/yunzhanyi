package net.yunzhanyi.common.model;

import java.util.ArrayList;
import java.util.List;

public class WritingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WritingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDynastyIsNull() {
            addCriterion("dynasty is null");
            return (Criteria) this;
        }

        public Criteria andDynastyIsNotNull() {
            addCriterion("dynasty is not null");
            return (Criteria) this;
        }

        public Criteria andDynastyEqualTo(String value) {
            addCriterion("dynasty =", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyNotEqualTo(String value) {
            addCriterion("dynasty <>", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyGreaterThan(String value) {
            addCriterion("dynasty >", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyGreaterThanOrEqualTo(String value) {
            addCriterion("dynasty >=", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyLessThan(String value) {
            addCriterion("dynasty <", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyLessThanOrEqualTo(String value) {
            addCriterion("dynasty <=", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyLike(String value) {
            addCriterion("dynasty like", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyNotLike(String value) {
            addCriterion("dynasty not like", value, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyIn(List<String> values) {
            addCriterion("dynasty in", values, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyNotIn(List<String> values) {
            addCriterion("dynasty not in", values, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyBetween(String value1, String value2) {
            addCriterion("dynasty between", value1, value2, "dynasty");
            return (Criteria) this;
        }

        public Criteria andDynastyNotBetween(String value1, String value2) {
            addCriterion("dynasty not between", value1, value2, "dynasty");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andCorpusIsNull() {
            addCriterion("corpus is null");
            return (Criteria) this;
        }

        public Criteria andCorpusIsNotNull() {
            addCriterion("corpus is not null");
            return (Criteria) this;
        }

        public Criteria andCorpusEqualTo(String value) {
            addCriterion("corpus =", value, "corpus");
            return (Criteria) this;
        }

        public Criteria andCorpusNotEqualTo(String value) {
            addCriterion("corpus <>", value, "corpus");
            return (Criteria) this;
        }

        public Criteria andCorpusGreaterThan(String value) {
            addCriterion("corpus >", value, "corpus");
            return (Criteria) this;
        }

        public Criteria andCorpusGreaterThanOrEqualTo(String value) {
            addCriterion("corpus >=", value, "corpus");
            return (Criteria) this;
        }

        public Criteria andCorpusLessThan(String value) {
            addCriterion("corpus <", value, "corpus");
            return (Criteria) this;
        }

        public Criteria andCorpusLessThanOrEqualTo(String value) {
            addCriterion("corpus <=", value, "corpus");
            return (Criteria) this;
        }

        public Criteria andCorpusLike(String value) {
            addCriterion("corpus like", value, "corpus");
            return (Criteria) this;
        }

        public Criteria andCorpusNotLike(String value) {
            addCriterion("corpus not like", value, "corpus");
            return (Criteria) this;
        }

        public Criteria andCorpusIn(List<String> values) {
            addCriterion("corpus in", values, "corpus");
            return (Criteria) this;
        }

        public Criteria andCorpusNotIn(List<String> values) {
            addCriterion("corpus not in", values, "corpus");
            return (Criteria) this;
        }

        public Criteria andCorpusBetween(String value1, String value2) {
            addCriterion("corpus between", value1, value2, "corpus");
            return (Criteria) this;
        }

        public Criteria andCorpusNotBetween(String value1, String value2) {
            addCriterion("corpus not between", value1, value2, "corpus");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPartIsNull() {
            addCriterion("part is null");
            return (Criteria) this;
        }

        public Criteria andPartIsNotNull() {
            addCriterion("part is not null");
            return (Criteria) this;
        }

        public Criteria andPartEqualTo(String value) {
            addCriterion("part =", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartNotEqualTo(String value) {
            addCriterion("part <>", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartGreaterThan(String value) {
            addCriterion("part >", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartGreaterThanOrEqualTo(String value) {
            addCriterion("part >=", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartLessThan(String value) {
            addCriterion("part <", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartLessThanOrEqualTo(String value) {
            addCriterion("part <=", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartLike(String value) {
            addCriterion("part like", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartNotLike(String value) {
            addCriterion("part not like", value, "part");
            return (Criteria) this;
        }

        public Criteria andPartIn(List<String> values) {
            addCriterion("part in", values, "part");
            return (Criteria) this;
        }

        public Criteria andPartNotIn(List<String> values) {
            addCriterion("part not in", values, "part");
            return (Criteria) this;
        }

        public Criteria andPartBetween(String value1, String value2) {
            addCriterion("part between", value1, value2, "part");
            return (Criteria) this;
        }

        public Criteria andPartNotBetween(String value1, String value2) {
            addCriterion("part not between", value1, value2, "part");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("tags like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("tags not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("tags not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Integer value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Integer value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Integer value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Integer value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Integer> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Integer> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andCorpusIdIsNull() {
            addCriterion("corpus_id is null");
            return (Criteria) this;
        }

        public Criteria andCorpusIdIsNotNull() {
            addCriterion("corpus_id is not null");
            return (Criteria) this;
        }

        public Criteria andCorpusIdEqualTo(Integer value) {
            addCriterion("corpus_id =", value, "corpusId");
            return (Criteria) this;
        }

        public Criteria andCorpusIdNotEqualTo(Integer value) {
            addCriterion("corpus_id <>", value, "corpusId");
            return (Criteria) this;
        }

        public Criteria andCorpusIdGreaterThan(Integer value) {
            addCriterion("corpus_id >", value, "corpusId");
            return (Criteria) this;
        }

        public Criteria andCorpusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("corpus_id >=", value, "corpusId");
            return (Criteria) this;
        }

        public Criteria andCorpusIdLessThan(Integer value) {
            addCriterion("corpus_id <", value, "corpusId");
            return (Criteria) this;
        }

        public Criteria andCorpusIdLessThanOrEqualTo(Integer value) {
            addCriterion("corpus_id <=", value, "corpusId");
            return (Criteria) this;
        }

        public Criteria andCorpusIdIn(List<Integer> values) {
            addCriterion("corpus_id in", values, "corpusId");
            return (Criteria) this;
        }

        public Criteria andCorpusIdNotIn(List<Integer> values) {
            addCriterion("corpus_id not in", values, "corpusId");
            return (Criteria) this;
        }

        public Criteria andCorpusIdBetween(Integer value1, Integer value2) {
            addCriterion("corpus_id between", value1, value2, "corpusId");
            return (Criteria) this;
        }

        public Criteria andCorpusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("corpus_id not between", value1, value2, "corpusId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}