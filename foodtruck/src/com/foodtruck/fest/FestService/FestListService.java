package com.foodtruck.fest.FestService;

import java.util.List;

import com.foodtruck.fest.dao.FestDAO;
import com.foodtruck.fest.dto.FestDTO;
import com.foodtruck.util.ServiceInterface;
import com.webjjang.util.PageObject2;

public class FestListService implements ServiceInterface {

	private FestDAO festDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.festDAO = (FestDAO) obj;
	}

	@Override
	public List<FestDTO> execute(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FestListService.excute()");
		List<FestDTO> list = null;
		// list에 데이터를 가져와서 채우는 프로그램 작성
		// 호출만
		list = festDAO.list((PageObject2) obj);
		return list;
	}
}
