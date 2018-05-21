/*
 * NoticeUpdateService
 * 20180416 유태선
 */
package com.foodtruck.notice.service;

import com.foodtruck.notice.dao.NoticeDAO;
import com.foodtruck.notice.dto.NoticeDTO;
import com.foodtruck.util.ServiceInterface;

public class NoticeUpdateService implements ServiceInterface {

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
		// obj 캐스팅
		NoticeDTO noticeDTO = (NoticeDTO) obj;
		// DAO로 넘겨준다
		noticeDAO.update(noticeDTO);
		return null;
	}
}
