package com.foodtruck.notice.dto;

/*
 * 게시판 데이터를 저장하는 객체
 * 20180213
 * 유태선
 * 번호, 제목, 내용, 작성자, 작성일, 조회수
 */
public class NoticeDTO {

	private int no;
	private String title;
	private String content;
	private String id;
	private String writeDate;
	private int hit;
	
	public NoticeDTO() {
		super();
	}

	// 전부 다
	public NoticeDTO(int no, String title, String content, String id, String writeDate, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.id = id;
		this.writeDate = writeDate;
		this.hit = hit;
	}

	// 글쓰기
	public NoticeDTO(String title, String content, String id) {
		super();
		this.title = title;
		this.content = content;
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "NoticeDTO [no=" + no + ", title=" + title + ", content=" + content + ", id=" + id + ", writeDate="
				+ writeDate + ", hit=" + hit + "]";
	}

	

}
