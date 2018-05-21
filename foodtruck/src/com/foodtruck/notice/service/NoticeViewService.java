/*
 * NoticeViewService
 * 20180416 유태선
 */
package com.foodtruck.notice.service;

import java.util.ArrayList;

import com.foodtruck.notice.dao.NoticeDAO;
import com.foodtruck.notice.dto.NoticeDTO;
import com.foodtruck.util.ServiceInterface;

public class NoticeViewService implements ServiceInterface {

	private NoticeDAO noticeDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.noticeDAO = (NoticeDAO) obj;
	}

	@Override
	public NoticeDTO execute(Object objs) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName() + ".execute()");

		// 담아온 객체를 캐스팅해준다.
		@SuppressWarnings("unchecked")
		ArrayList<Object> list = (ArrayList<Object>) objs;
		
		// 담아온 no isView를 꺼내준다.
		// noticeDTO 객체를 만든다.
		int no =(int) list.get(0);
		boolean isView = (boolean) list.get(1);
		NoticeDTO noticeDTO = null;
		
		// view로 들어왔을 때는 hit를 1 올린다. update인 경우에는 안 올린다.
		if(isView) noticeDAO.increase(no);
	
		// dao에서 담아온다.
		noticeDTO = noticeDAO.view(no);

		return noticeDTO;
	}
}
