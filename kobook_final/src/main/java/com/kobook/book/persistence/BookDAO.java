package com.kobook.book.persistence;

import java.util.HashMap;
import java.util.List;

import com.kobook.book.domain.PickVO;
import com.kobook.book.domain.RankingVO;
import com.kobook.book.domain.ReviewVO;
import com.kobook.book.domain.BookVO;
import com.kobook.book.domain.DateDTO;
import com.kobook.book.domain.PersonDTO;
import com.kobook.book.domain.SearchCriteria;
import com.kobook.mypage.domain.DeliveryVO;
import com.kobook.person.domain.PersonVO;

public interface BookDAO {

	public void create(BookVO vo)throws Exception;

	public List<BookVO> listCriteria(SearchCriteria cri) throws Exception;
	
	public List<BookVO> directListCriteria(SearchCriteria cri) throws Exception;
	
	public List<BookVO> safeListCriteria(SearchCriteria cri) throws Exception;
	
	//��留ㅼ���� �ㅻⅨ���� 由ъ�ㅽ��
	public List<BookVO> sellPersonList(int person_id) throws Exception;
	
	//��留ㅼ�� ��湲� 由ъ�ㅽ��
	public List<ReviewVO> reviewList(int person_id,SearchCriteria cri)throws Exception;
	
	
	//��留ㅼ����蹂�
	public PersonDTO readSellPerson(int person_id) throws Exception;
	

	
	public int countPaging(SearchCriteria cri)throws Exception;
	
	public BookVO read(Integer book_id) throws Exception;
	
	public void update(BookVO vo) throws Exception;
	
	public void pick(PickVO pick) throws Exception;
	
	public int getPersonIdByBookId(int book_id) throws Exception;
	
	//由щ럭 ���깆��
	public String writeName(int person_id)throws Exception;

	public void reviewCreate(ReviewVO review)throws Exception;
	
	//������ ���� 由щ럭媛���
	public int countReview(int person_id)throws Exception;
	
	//������ ���� 珥�蹂���
	public int countStar(int person_id)throws Exception;
	
	//5��,4,3,2,1,
	public int fivestar(int person_id)throws Exception;
	public int fourstar(int person_id)throws Exception;
	public int threestar(int person_id)throws Exception;
	public int twostar(int person_id)throws Exception;
	public int onestar(int person_id)throws Exception;
	
	//���ш굅�� 諛곗�〓━�ㅽ��
	public List<HashMap<String, String>> deliveryList(SearchCriteria cri);
	
	//諛곗�〓━�ㅽ�� 移댁�댄��
	public int countdelList()throws Exception;
	
	//諛곗�≪���� ���곗�댄��
	public void delstateUpdate(DeliveryVO delivery)throws Exception;
	
	public void registerkeyword(SearchCriteria cri)throws Exception;
	
	public List<RankingVO> rankingList() throws Exception;
	
	public int directListCount() throws Exception;
	
	public int safeListCount() throws Exception;
	
	//public List<HashMap<String, String>> selectDate(DateDTO dto) throws Exception;
	
	public int wpercent() throws Exception;
	public int ipercent() throws Exception;
	public int cpercent() throws Exception;
	
	public int month(int m) throws Exception;
	
	public int todayMoney()throws Exception;
	
	
	//챗봇용
	public List<BookVO> getRecentList() throws Exception;
	public String getNameById(int book_id) throws Exception;
	public List<BookVO> getMyBookList(int person_id) throws Exception;

}