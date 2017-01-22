package com.sanhang.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageParameter {
	
	int draw = 0;

	int start = 0;

	int length = 20;
	
	Search search;

	List<Column> columns = new ArrayList<>();
	
	List<Order> order = new ArrayList<>();
	
	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public static class Column implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		String data;
		String name;
		boolean searchable;
		boolean orderable;
		Search search;

		public Column() {
			super();
		}

		/**
		 * @return the data
		 */
		public String getData() {
			return data;
		}

		/**
		 * @param data
		 *            the data to set
		 */
		public void setData(String data) {
			this.data = data;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the searchable
		 */
		public boolean isSearchable() {
			return searchable;
		}

		/**
		 * @param searchable
		 *            the searchable to set
		 */
		public void setSearchable(boolean searchable) {
			this.searchable = searchable;
		}

		/**
		 * @return the orderable
		 */
		public boolean isOrderable() {
			return orderable;
		}

		/**
		 * @param orderable
		 *            the orderable to set
		 */
		public void setOrderable(boolean orderable) {
			this.orderable = orderable;
		}

		/**
		 * @return the search
		 */
		public Search getSearch() {
			return search;
		}

		/**
		 * @param search
		 *            the search to set
		 */
		public void setSearch(Search search) {
			this.search = search;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Column [data=" + data + ", name=" + name + ", searchable=" + searchable + ", orderable=" + orderable
					+ ", search=" + search + "]";
		}

	}
	
	public static class Search implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		String value;
		boolean regex;

		public Search() {
			super();
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * @return the regex
		 */
		public boolean isRegex() {
			return regex;
		}

		/**
		 * @param regex
		 *            the regex to set
		 */
		public void setRegex(boolean regex) {
			this.regex = regex;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Search [value=" + value + ", regex=" + regex + "]";
		}

	}
	
	public static class Order implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		int column;
		String dir;

		public Order() {
			super();
		}

		/**
		 * @return the column
		 */
		public int getColumn() {
			return column;
		}

		/**
		 * @param column
		 *            the column to set
		 */
		public void setColumn(int column) {
			this.column = column;
		}

		/**
		 * @return the dir
		 */
		public String getDir() {
			return dir;
		}

		/**
		 * @param dir
		 *            the dir to set
		 */
		public void setDir(String dir) {
			this.dir = dir;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Order [column=" + column + ", dir=" + dir + "]";
		}

	}
	
}
