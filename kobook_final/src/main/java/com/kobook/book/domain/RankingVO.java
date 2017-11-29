package com.kobook.book.domain;

public class RankingVO {

	private int ranking_id;
	private String ranking_keyword;
	
	public RankingVO(){}

	public RankingVO(int ranking_id, String ranking_keyword) {
		super();
		this.ranking_id = ranking_id;
		this.ranking_keyword = ranking_keyword;
	}

	public int getRanking_id() {
		return ranking_id;
	}

	public void setRanking_id(int ranking_id) {
		this.ranking_id = ranking_id;
	}

	public String getRanking_keyword() {
		return ranking_keyword;
	}

	public void setRanking_keyword(String ranking_keyword) {
		this.ranking_keyword = ranking_keyword;
	}

	@Override
	public String toString() {
		return "RankingVO [ranking_id=" + ranking_id + ", ranking_keyword=" + ranking_keyword + "]";
	};
	
	
	
}
