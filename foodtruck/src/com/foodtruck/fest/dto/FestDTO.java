package com.foodtruck.fest.dto;

import java.util.Date;

public class FestDTO {

	private int festno;
	private String festname, festcomp;
	private String festdate;
	private String festloc;
	private String festtime;
	private Date applydate;
	private int hit;

	// 초기화 블럭
	public FestDTO() {

	}

	// 행사일정 리스트용
	public FestDTO(int festno, String festname, String festdate, String festloc, Date applydate, int hit) {
		this.festno = festno;
		this.festname = festname;
		this.festdate = festdate;
		this.festloc = festloc;
		this.applydate = applydate;
		this.hit = hit;
	}

	// 행사일정 글보기용
	public FestDTO(int festno, String festname, String festcomp, String festdate, String festloc, String festtime,
			Date applydate, int hit) {
		this.festno = festno;
		this.festname = festname;
		this.festcomp = festcomp;
		this.festdate = festdate;
		this.festloc = festloc;
		this.festtime = festtime;
		this.applydate = applydate;
		this.hit = hit;
	}

	// 행사일정 글등록용
	public FestDTO(String festname, String festcomp, String festdate, String festloc, String festtime) {
		this.festname = festname;
		this.festcomp = festcomp;
		this.festdate = festdate;
		this.festloc = festloc;
		this.festtime = festtime;
	}

	// 행사일정 글 수정용
	public FestDTO(int festno, String festcomp, String festname, String festdate, String festloc, String festtime) {
		this.festno = festno;
		this.festcomp = festcomp;
		this.festname = festname;
		this.festdate = festdate;
		this.festloc = festloc;
		this.festtime = festtime;
	}

	public int getFestno() {
		return festno;
	}

	public void setFestno(int festno) {
		this.festno = festno;
	}

	public String getFestname() {
		return festname;
	}

	public void setFestname(String festname) {
		this.festname = festname;
	}

	public String getFestcomp() {
		return festcomp;
	}

	public void setFestcomp(String festcomp) {
		this.festcomp = festcomp;
	}

	public String getFestdate() {
		return festdate;
	}

	public void setFestdate(String festdate) {
		this.festdate = festdate;
	}

	public String getFestloc() {
		return festloc;
	}

	public void setFestloc(String festloc) {
		this.festloc = festloc;
	}

	public String getFesttime() {
		return festtime;
	}

	public void setFesttime(String festtime) {
		this.festtime = festtime;
	}

	public Date getApplydate() {
		return applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "FestDTO [no=" + festno + ", festname=" + festname + ", festcomp=" + festcomp + ", festdate=" + festdate
				+ ", festloc=" + festloc + ", festtime=" + festtime + ", applydate=" + applydate + ", hit=" + hit + "]";
	}
}
