package com.foodtruck.fest.CustService;

import java.util.List;

import com.foodtruck.fest.dao.FestCustDAO;
import com.foodtruck.fest.dto.FestCustDTO;
import com.foodtruck.util.ServiceInterface;
import com.webjjang.util.PageObject2;

public class FestCustListService implements ServiceInterface {

	private FestCustDAO custDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.custDAO = (FestCustDAO) obj;
	}

	@Override
	public List<FestCustDTO> execute(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FestCustListService.excute()");
		List<FestCustDTO> list = null;
		// list에 데이터를 가져와서 채우는 프로그램 작성
		// 호출만
		list = custDAO.list((PageObject2) obj);

		return list;
	}
}
