package com.sanhang.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public class DataTablesResult<T> {
	
	int draw = 0;

	int recordsTotal = 0;

	int recordsFiltered = 0;

	List<T> data = new ArrayList<T>();
	
	String error;
	
	public DataTablesResult() {
		super();
	}
	
	public DataTablesResult(int draw, PageInfo<T> page) {
		super();

		setDraw(draw);
		setRecordsTotal((int) page.getTotal());
		addData(page.getList());
	}

	public DataTablesResult(Query query, PageInfo<T> page) {
		this(query.getPage().getDraw(), page);
	}
	
	public DataTablesResult(int draw, String error) {
		super();
		
		setDraw(draw);
		setError(error);
	}
	
	public DataTablesResult(PageParameter para, String error) {
		this(para.getDraw(), error);
	}
	
	public DataTablesResult(Query query, String error) {
		this(query.getPage().getDraw(), error);
	}

	public DataTablesResult(int draw, int recordsTotal) {
		super();

		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsTotal;
	}

	/**
	 * @return the draw
	 */
	public int getDraw() {
		return draw;
	}

	/**
	 * @param draw
	 *            the draw to set
	 */
	public void setDraw(int draw) {
		this.draw = draw;
	}

	/**
	 * @return the recordsTotal
	 */
	public int getRecordsTotal() {
		return recordsTotal;
	}

	/**
	 * @param recordsTotal
	 *            the recordsTotal to set
	 */
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
		setRecordsFiltered(recordsTotal);
	}

	/**
	 * @return the recordsFiltered
	 */
	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	/**
	 * @param recordsFiltered
	 *            the recordsFiltered to set
	 */
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	public void addData(T t) {
		this.data.add(t);
	}

	public Iterator<T> dataIterator() {
		return this.data.iterator();
	}

	public void clearData() {
		this.data.clear();
	}

	public void addData(List<T> list) {
		this.data.addAll(list);
	}

	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageData [draw=" + draw + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered
				+ ", data=" + data.size() + ", error=" + error + "]";
	}

}
