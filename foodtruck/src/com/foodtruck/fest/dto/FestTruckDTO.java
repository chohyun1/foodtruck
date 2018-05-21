package com.foodtruck.fest.dto;

import java.util.Date;

public class FestTruckDTO {

	private int truckno;
	private String festjoin, truckname, country, maindish;
	private int predppl, applyppl, readyfood;
	private String mngrname, mngrtel;
	private Date applydate;
	private int hit;

	// 초기화 블럭
	public FestTruckDTO() {

	}

	// 푸드트럭 신청서 리스트용
	public FestTruckDTO(int truckno, String festjoin, String truckname, String country, String maindish,
			String mngrname, String mngrtel, Date applydate, int hit) {
		this.truckno = truckno;
		this.festjoin = festjoin;
		this.truckname = truckname;
		this.country = country;
		this.maindish = maindish;
		this.mngrname = mngrname;
		this.mngrtel = mngrtel;
		this.applydate = applydate;
		this.hit = hit;
	}

	// 푸드트럭 신청서 글보기용
	public FestTruckDTO(int truckno, String festjoin, String truckname, String country, String maindish, int predppl,
			int applyppl, int readyfood, String mngrname, String mngrtel, Date applydate, int hit) {
		this.truckno = truckno;
		this.festjoin = festjoin;
		this.truckname = truckname;
		this.country = country;
		this.maindish = maindish;
		this.predppl = predppl;
		this.applyppl = applyppl;
		this.readyfood = readyfood;
		this.mngrname = mngrname;
		this.mngrtel = mngrtel;
		this.applydate = applydate;
		this.hit = hit;
	}

	// 푸드트럭 신청서 글등록 및 수정용
	public FestTruckDTO(String festjoin, String truckname, String country, String maindish, int predppl, int applyppl,
			int readyfood, String mngrname, String mngrtel) {
		this.festjoin = festjoin;
		this.truckname = truckname;
		this.country = country;
		this.maindish = maindish;
		this.predppl = predppl;
		this.applyppl = applyppl;
		this.readyfood = readyfood;
		this.mngrname = mngrname;
		this.mngrtel = mngrtel;
	}

	// 푸드트럭 신청서 글수정용
	public FestTruckDTO(int truckno, String festjoin, String truckname, String country, String maindish, int predppl,
			int applyppl, int readyfood, String mngrname, String mngrtel) {
		this.truckno = truckno;
		this.festjoin = festjoin;
		this.truckname = truckname;
		this.country = country;
		this.maindish = maindish;
		this.predppl = predppl;
		this.applyppl = applyppl;
		this.readyfood = readyfood;
		this.mngrname = mngrname;
		this.mngrtel = mngrtel;
	}

	public int getTruckno() {
		return truckno;
	}

	public void setTruckno(int truckno) {
		this.truckno = truckno;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMaindish() {
		return maindish;
	}

	public void setMaindish(String maindish) {
		this.maindish = maindish;
	}

	public int getPredppl() {
		return predppl;
	}

	public void setPredppl(int predppl) {
		this.predppl = predppl;
	}

	public int getApplyppl() {
		return applyppl;
	}

	public void setApplyppl(int applyppl) {
		this.applyppl = applyppl;
	}

	public int getReadyfood() {
		return readyfood;
	}

	public void setReadyfood(int readyfood) {
		this.readyfood = readyfood;
	}

	public String getMngrname() {
		return mngrname;
	}

	public void setMngrname(String mngrname) {
		this.mngrname = mngrname;
	}

	public String getMngrtel() {
		return mngrtel;
	}

	public void setMngrtel(String mngrtel) {
		this.mngrtel = mngrtel;
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

	public String getTruckname() {
		return truckname;
	}

	public void setTruckname(String truckname) {
		this.truckname = truckname;
	}

	public String getFestjoin() {
		return festjoin;
	}

	public void setFestjoin(String festjoin) {
		this.festjoin = festjoin;
	}

	@Override
	public String toString() {
		return "FestTruckDTO [truckno=" + truckno + ", festjoin=" + festjoin + ", truckname=" + truckname + ", country="
				+ country + ", maindish=" + maindish + ", predppl=" + predppl + ", applyppl=" + applyppl
				+ ", readyfood=" + readyfood + ", mngrname=" + mngrname + ", mngrtel=" + mngrtel + ", applydate="
				+ applydate + ", hit=" + hit + "]";
	}

}
