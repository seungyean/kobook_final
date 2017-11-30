package com.kobook.mypage.domain;

public class MyPageCriteria {
	
	private int person_id;
	
	 private int page;
	  private int perPageNum;

	  public MyPageCriteria() {
	    this.page = 1;
	    this.perPageNum = 5;
	  }

	  public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public void setPage(int page) {

	    if (page <= 0) {
	      this.page = 1;
	      return;
	    }

	    this.page = page;
	  }

	  public void setPerPageNum(int perPageNum) {

	    if (perPageNum <= 0 || perPageNum > 100) {
	      this.perPageNum = 5;
	      return;
	    }

	    this.perPageNum = perPageNum;
	  }

	  public int getPage() {
	    return page;
	  }

	  // method for MyBatis SQL Mapper -
	  public int getPageStart() {

	    return (this.page - 1) * perPageNum;
	  }

	  // method for MyBatis SQL Mapper
	  public int getPerPageNum() {

	    return this.perPageNum;
	  }
	  
	@Override
	public String toString() {
		return "MyPageCriteria [page=" + page + ", perPageNum=" + perPageNum + ", person_id=" + person_id + "]";
	}
	 


	

}
