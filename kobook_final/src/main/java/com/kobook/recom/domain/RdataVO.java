package com.kobook.recom.domain;

//데이터 마이닝한 결과를 적용해서 추천도서를 추출하기 위해 필요한 VO객체. 새로운 RDATA테이블과 관련 있다.
public class RdataVO {

	private int rdata_id;
	private String rdata_m;
	private String rdata_o;
	private double rdata_support;
	
	public RdataVO(){}
	
	public RdataVO(int rdata_id, String rdata_m, String rdata_o, double rdata_support) {
		super();
		this.rdata_id = rdata_id;
		this.rdata_m = rdata_m;
		this.rdata_o = rdata_o;
		this.rdata_support = rdata_support;
	}

	public int getRdata_id() {
		return rdata_id;
	}

	public void setRdata_id(int rdata_id) {
		this.rdata_id = rdata_id;
	}

	public String getRdata_m() {
		return rdata_m;
	}

	public void setRdata_m(String rdata_m) {
		this.rdata_m = rdata_m;
	}

	public String getRdata_o() {
		return rdata_o;
	}

	public void setRdata_o(String rdata_o) {
		this.rdata_o = rdata_o;
	}

	public double getRdata_support() {
		return rdata_support;
	}

	public void setRdata_support(double rdata_support) {
		this.rdata_support = rdata_support;
	}

	@Override
	public String toString() {
		return "RdataVO [rdata_id=" + rdata_id + ", rdata_m=" + rdata_m + ", rdata_o=" + rdata_o + ", rdata_support="
				+ rdata_support + "]";
	}
	
	
}
