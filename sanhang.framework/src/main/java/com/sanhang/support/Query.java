package com.sanhang.support;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Query {
	
	PageParameter page;
	
	String jsonPage;

	String keyword;
	
	public Query() {
		super();
	}

	public Query(PageParameter page) {
		super();
		this.page = page;
	}

	public Query(String json) throws Exception {
		super();
		setJsonPage(json);
	}

	public void bindPage(String json) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		PageParameter _page = mapper.readValue(json, PageParameter.class);
		this.page = _page;
	}
	
	@JsonIgnore
	public PageParameter getPage() {
		return page;
	}

	public void setPage(PageParameter page) {
		this.page = page;
	}

	public String getJsonPage() {
		return jsonPage;
	}

	public void setJsonPage(String jsonPage) throws Exception {
		this.jsonPage = jsonPage;
		bindPage(jsonPage);
	}

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword
	 *            the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOtherOrderCondition(){
		return "id";
	}

}
