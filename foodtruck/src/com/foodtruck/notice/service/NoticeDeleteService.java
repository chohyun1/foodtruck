/*
 * NoticeDeleteService
 * 20180416 유태선
 */
package com.foodtruck.notice.service;

import com.foodtruck.notice.dao.NoticeDAO;
import com.foodtruck.util.ServiceInterface;

public class NoticeDeleteService implements ServiceInterface {

	private NoticeDAO noticeDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.noticeDAO = (NoticeDAO) obj;
	}

	@Override
	public Object execute(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName() + ".execute()");

		// 전달 받은 데이터를 DAO로 넘겨주기 위해서 Object를 캐스팅
		int no = (Integer) obj;
		// DAO로 넘겨 삭제를 진행한다.
		noticeDAO.delete(no);

		return null;
	}
}
