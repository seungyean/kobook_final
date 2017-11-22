package com.kobook.board.domain;

import java.util.Arrays;

public class SearchVO {

	private String[] area;
	private String searchKey;
	
	public SearchVO(String[] area, String searchKey) {
		super();
		this.area = area;
		this.searchKey = searchKey;
	}

	public String[] getArea() {
		return area;
	}

	public void setArea(String[] area) {
		this.area = area;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	@Override
	public String toString() {
		return "SearchVO [area=" + Arrays.toString(area) + ", searchKey=" + searchKey + "]";
	}
	
	
	
}
