/*
 * NoticeWriteService
 * 20180416 유태선
 */
package com.foodtruck.notice.service;

import com.foodtruck.notice.dao.NoticeDAO;
import com.foodtruck.notice.dto.NoticeDTO;
import com.foodtruck.util.ServiceInterface;

public class NoticeWriteService implements ServiceInterface{
	
	// NullPointException이 나지 않도록 선언
	private NoticeDAO noticeDAO;
	
	
	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.noticeDAO = (NoticeDAO) obj;
	}

	@Override
	public Object execute(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName()+".execute()");
		
		//캐스팅을 하여 사용 가능하게 바꾼다.
		NoticeDTO noticeDTO = (NoticeDTO) obj;
		//DAO로 넘겨준다.
		noticeDAO.write(noticeDTO);
		
		return null;
	}
}
