package com.foodtruck.member.dto;

import java.util.Date;

public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String birthDate;
	private String gender;
	private String mobile;
	private String email;
	private String address;
	private String add2;
	private Date regDate;
	private Date idupdate;
	private int gradeno;
	
	public MemberDTO() {}

// 회원가입 
	public MemberDTO(String id, String pw, String name, String birthDate, String gender, String mobile, String email,
			String address, String add2, Date regDate, Date idupdate, int gradeno) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.add2 = add2;
		this.regDate = regDate;
		this.idupdate = idupdate;
		this.gradeno = gradeno;
	}
	
//비밀번호 변경
	public MemberDTO(String id, String pw) {
	super();
	this.id = id;
	this.pw = pw;
}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getIdupdate() {
		return idupdate;
	}

	public void setIdupdate(Date idupdate) {
		this.idupdate = idupdate;
	}

	public int getGradeno() {
		return gradeno;
	}

	public void setGradeno(int gradeno) {
		this.gradeno = gradeno;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", birthDate=" + birthDate + ", gender="
				+ gender + ", mobile=" + mobile + ", email=" + email + ", address=" + address + ", add2=" + add2
				+ ", regDate=" + regDate + ", idupdate=" + idupdate + ", gradeno=" + gradeno + "]";
	}


	
	
	
	
}