package com.kobook.domain.book;

import java.sql.Date;
import java.util.Arrays;

public class BookVO {
	private Integer bookId;
	private String bookName;
	private int bookOPrice;
	private int bookMPrice;
	private String bookKind;
	private int bookEdition;
	private String bookPublish;
	private String bookHash;
	private String bookSafeYn;
	private String bookSellState;
	private String bookContent;
	private Date bookDate;
	private String bookStatus;
	private String[] files;
	private int personId;

	public BookVO(){}

	
	
	

	public BookVO(Integer bookId, String bookName, int bookOPrice, int bookMPrice, String bookKind, int bookEdition,
			String bookPublish, String bookHash, String bookSafeYn, String bookSellState, String bookContent,
			Date bookDate, String bookStatus, String[] files, int personId) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookOPrice = bookOPrice;
		this.bookMPrice = bookMPrice;
		this.bookKind = bookKind;
		this.bookEdition = bookEdition;
		this.bookPublish = bookPublish;
		this.bookHash = bookHash;
		this.bookSafeYn = bookSafeYn;
		this.bookSellState = bookSellState;
		this.bookContent = bookContent;
		this.bookDate = bookDate;
		this.bookStatus = bookStatus;
		this.files = files;
		this.personId = personId;
	}





	public String[] getFiles() {
		return files;
	}





	public void setFiles(String[] files) {
		this.files = files;
	}





	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookOPrice() {
		return bookOPrice;
	}

	public void setBookOPrice(int bookOPrice) {
		this.bookOPrice = bookOPrice;
	}

	public int getBookMPrice() {
		return bookMPrice;
	}

	public void setBookMPrice(int bookMPrice) {
		this.bookMPrice = bookMPrice;
	}

	public String getBookKind() {
		return bookKind;
	}

	public void setBookKind(String bookKind) {
		this.bookKind = bookKind;
	}

	public int getBookEdition() {
		return bookEdition;
	}

	public void setBookEdition(int bookEdition) {
		this.bookEdition = bookEdition;
	}

	public String getBookPublish() {
		return bookPublish;
	}

	public void setBookPublish(String bookPublish) {
		this.bookPublish = bookPublish;
	}

	public String getBookHash() {
		return bookHash;
	}

	public void setBookHash(String bookHash) {
		this.bookHash = bookHash;
	}

	public String getBookSafeYn() {
		return bookSafeYn;
	}

	public void setBookSafeYn(String bookSafeYn) {
		this.bookSafeYn = bookSafeYn;
	}

	public String getBookSellState() {
		return bookSellState;
	}

	public void setBookSellState(String bookSellState) {
		this.bookSellState = bookSellState;
	}

	public String getBookContent() {
		return bookContent;
	}

	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}





	@Override
	public String toString() {
		return "BookVO [bookId=" + bookId + ", bookName=" + bookName + ", bookOPrice=" + bookOPrice + ", bookMPrice="
				+ bookMPrice + ", bookKind=" + bookKind + ", bookEdition=" + bookEdition + ", bookPublish="
				+ bookPublish + ", bookHash=" + bookHash + ", bookSafeYn=" + bookSafeYn + ", bookSellState="
				+ bookSellState + ", bookContent=" + bookContent + ", bookDate=" + bookDate
				+ ", bookStatus=" + bookStatus + ", files=" + Arrays.toString(files) + ", personId=" + personId + "]";
	}


	
	
	
	
}
