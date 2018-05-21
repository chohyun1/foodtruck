package com.foodtruck.review.dto;

/*
 * 게시판 데이터를 저장하는 객체
 * 20180410
 * 조현일
 * 번호, 제목, 내용, 작성자, 작성일, 조회수
 */
public class ReviewDTO {

	private int rno, score, hit;
	private String  id, content, writedate, starscore, fname, maindish, festloc, festdate;

	public ReviewDTO() {
		
	}
	

	//리스트
	public ReviewDTO( int rno,int score, int hit, String content, String fname, String festdate, String maindish, String festloc, 	String starscore, String id) {
		this.rno =rno;
		this.score = score;
		this.hit = hit;
		this.festdate = festdate;
		this.content = content;
		this.fname = fname;
		this.maindish = maindish;
		this.festloc = festloc;
		this.starscore = starscore;
		this.id = id;
	}
	
	//\글쓰기
public ReviewDTO(int rno,  String content, String starscore,String id, int score) {
		this.rno = rno;
//		this.id = id;
		this.content = content;
		this.starscore = starscore;
		this.id = id;
		this.score = score;
		

	}

////데이터를 넣을 때, 데이터가 다 준비 되어 있는 경우. -> 게시판 글보기 할 때 사용
	public ReviewDTO(int rno, int score, int hit, String id, String fname, String maindish, 
			String festloc, String content, String writedate, String festdate, String starscore) {
		super();
		this.rno = rno;
		this.score = score;		
		this.hit = hit;
		this.id = id;
		this.fname = fname;
		this.maindish = maindish;
		this.festloc = festloc;
		this.content = content;
		this.writedate = writedate;
		this.festdate = festdate;
		this.starscore = starscore;
	}



		public int getRno() {
			return rno;
		}

		public void setRno(int rno) {
			this.rno = rno;
		}


		public int getHit() {
			return hit;
		}

		public void setHit(int hit) {
			this.hit = hit;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getMaindish() {
			return maindish;
		}

		public void setMaindish(String maindish) {
			this.maindish = maindish;
		}

		public String getFestloc() {
			return festloc;
		}

		public void setFestloc(String festloc) {
			this.festloc = festloc;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getWritedate() {
			return writedate;
		}

		public void setWritedate(String writedate) {
			this.writedate = writedate;
		}

		public String getFestdate() {
			return festdate;
		}

		public void setFestdate(String festdate) {
			this.festdate = festdate;
		}

		public String getStarscore() {
			return starscore;
		}

		public void setStarscore(String starscore) {
			this.starscore = starscore;
		}

		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}

		@Override
		public String toString() {
			return "ReviewDTO [rno=" + rno + ", score=" + score + ", hit=" + hit + ", id=" + id + ", content=" + content
					+ ", writedate=" + writedate + ", starscore=" + starscore + ", fname=" + fname + ", maindish="
					+ maindish + ", festloc=" + festloc + ", festdate=" + festdate + "]";
		}
	
		
		
}
