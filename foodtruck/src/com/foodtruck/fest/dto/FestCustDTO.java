package com.foodtruck.fest.dto;

import java.util.Date;

public class FestCustDTO {

	private int custno;
	private String applyname, applytel;
	private int applyno;
	private String applyloc;
	private String applytime;
	private Date applydate;
	private String festjoin;
	private String truckjoin;
	private int hit;

	// 초기화 블럭
	public FestCustDTO() {

	}

	// 소비자 신청서 리스트용
	public FestCustDTO(int custno, String applyname, String applytel, Date applydate, int hit) {
		this.custno = custno;
		this.applyname = applyname;
		this.applytel = applytel;
		this.applydate = applydate;
		this.hit = hit;
	}

	// 소비자 신청서 글보기용
	public FestCustDTO(int custno, String festjoin, String truckjoin, String applyname, String applytel, int applyno,
			String applyloc, String applytime, Date applydate, int hit) {
		this.festjoin = festjoin;
		this.truckjoin = truckjoin;
		this.custno = custno;
		this.applyname = applyname;
		this.applytel = applytel;
		this.applyno = applyno;
		this.applyloc = applyloc;
		this.applytime = applytime;
		this.applydate = applydate;
		this.hit = hit;
	}

	// 소비자 신청서 글등록 및 수정용
	public FestCustDTO(String festjoin, String truckjoin, String applyname, String applytel, int applyno,
			String applyloc, String applytime) {
		this.festjoin = festjoin;
		this.truckjoin = truckjoin;
		this.applyname = applyname;
		this.applytel = applytel;
		this.applyno = applyno;
		this.applyloc = applyloc;
		this.applytime = applytime;
	}

	// 수정용
	public FestCustDTO(int custno, String festjoin, String truckjoin, String applyname, String applytel, int applyno,
			String applyloc, String applytime) {
		this.custno = custno;
		this.festjoin = festjoin;
		this.truckjoin = truckjoin;
		this.applyname = applyname;
		this.applytel = applytel;
		this.applyno = applyno;
		this.applyloc = applyloc;
		this.applytime = applytime;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getApplyname() {
		return applyname;
	}

	public void setApplyname(String applyname) {
		this.applyname = applyname;
	}

	public String getApplytel() {
		return applytel;
	}

	public void setApplytel(String applytel) {
		this.applytel = applytel;
	}

	public int getApplyno() {
		return applyno;
	}

	public void setApplyno(int applyno) {
		this.applyno = applyno;
	}

	public String getApplyloc() {
		return applyloc;
	}

	public void setApplyloc(String applyloc) {
		this.applyloc = applyloc;
	}

	public String getApplytime() {
		return applytime;
	}

	public void setApplytime(String applytime) {
		this.applytime = applytime;
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

	public String getFestjoin() {
		return festjoin;
	}

	public void setFestjoin(String festjoin) {
		this.festjoin = festjoin;
	}

	public String getTruckjoin() {
		return truckjoin;
	}

	public void setTruckjoin(String truckjoin) {
		this.truckjoin = truckjoin;
	}

	@Override
	public String toString() {
		return "FestCustDTO [custno=" + custno + ", applyname=" + applyname + ", applytel=" + applytel + ", applyno="
				+ applyno + ", applyloc=" + applyloc + ", applytime=" + applytime + ", applydate=" + applydate
				+ ", festjoin=" + festjoin + ", truckjoin=" + truckjoin + ", hit=" + hit + "]";
	}

}
