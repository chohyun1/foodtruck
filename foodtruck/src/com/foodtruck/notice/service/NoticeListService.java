/*
 * NoticeListService
 * 20180416 유태선
 */
package com.foodtruck.notice.service;

import java.util.List;

import com.foodtruck.notice.dao.NoticeDAO;
import com.foodtruck.notice.dto.NoticeDTO;
import com.foodtruck.util.ServiceInterface;
import com.webjjang.util.PageObject2;

public class NoticeListService implements ServiceInterface {

	private NoticeDAO noticeDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.noticeDAO = (NoticeDAO) obj;
	}

	@Override
	public List<NoticeDTO> execute(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName()+".execute()");
		
		// list이므로 obj는 필요 없다.
		
		// list객체 생성
		List<NoticeDTO> list = null;
		
		// DAO에서 list를 받아온다.
		list = noticeDAO.list((PageObject2) obj);
		
		return list;
	}
}
