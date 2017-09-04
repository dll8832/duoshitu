package com.shop.model;


import com.shop.base.BaseModel;

/**
 * Entity - 文章
 */
@SuppressWarnings("serial")
public class Article extends BaseModel {

	/** 标题 */
	private String title;

	/** 作者 */
	private String author;

	/** 内容 */
	private String content;

	/** 页面标题 */
	private String seoTitle;

	/** 页面关键词 */
	private String seoKeywords;

	/** 页面描述 */
	private String seoDescription;

	/** 是否发布 */
	private Boolean isPublication;

	/** 是否置顶 */
	private Boolean isTop;

	/** 点击数 */
	private Long hits;

	/** 静态生成方式 */
	private int generateMethod; // 0=无 1=及时 2=延迟

	/** 文章分类 */
	private Integer articleCategory;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSeoTitle() {
		return seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public Boolean getIsPublication() {
		return isPublication;
	}

	public void setIsPublication(Boolean isPublication) {
		this.isPublication = isPublication;
	}

	public Boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public int getGenerateMethod() {
		return generateMethod;
	}

	public void setGenerateMethod(int generateMethod) {
		this.generateMethod = generateMethod;
	}

	public Integer getArticleCategory() {
		return articleCategory;
	}

	public void setArticleCategory(Integer articleCategory) {
		this.articleCategory = articleCategory;
	}
}
