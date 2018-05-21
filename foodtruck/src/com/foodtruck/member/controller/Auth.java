package com.foodtruck.member.controller;

import java.util.HashMap;
import java.util.Map;

public class Auth {

	// uri와 허용 권한을 넣어 두는 map 객체
	private static Map<String, Integer> authMap = new HashMap<>();

	// uri에 대해 권한을 셋팅하는 메서드
	public static void addAuth(String uri, Integer gradeno) {
		authMap.put(uri, gradeno);
	}

	// uri의 등급과 사용자 등급을 비교헤서 사용자 등급이 허용되는 등급이면 true를 리턴한다.
	public static boolean isAuth(String uri, Integer gradeno) {
		Integer pageGradeno = authMap.get(uri);
		if (pageGradeno == null || pageGradeno == 0) // 현재보여주는 page의 등급이 없다. 즉, 권한이 필요없다.
			return true;
		else { // pageGrade 존재하지만, 0이 아니면 계산해서 리턴한다.
			if (gradeno == null || gradeno == 0)
				return false; // 사용자가 로그인을 하지 않았다.
			return pageGradeno <= gradeno;
		}
	}

	public static boolean isGoLogin(String uri, Integer gradeno) {
		Integer pageGradeno = authMap.get(uri);
		if (pageGradeno == null || pageGradeno == 0)
			return false; // 로그인이 필요하지 않는 경우
		return pageGradeno > 0 && (gradeno == null || gradeno == 0); // 로그인을 하지 않아서 로그인이 필요하다.
	}
}
