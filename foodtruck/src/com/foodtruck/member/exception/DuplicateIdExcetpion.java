package com.foodtruck.member.exception;

public class DuplicateIdExcetpion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DuplicateIdExcetpion() {
		super("아이디가 중복되었습니다.");
	}

}
