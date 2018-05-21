package com.foodtruck.fest.CustService;

import com.foodtruck.fest.dao.FestCustDAO;
import com.foodtruck.fest.dto.FestCustDTO;
import com.foodtruck.util.ServiceInterface;

public class CustUpdateService implements ServiceInterface {

	private FestCustDAO custDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.custDAO = (FestCustDAO) obj;
	}

	@Override
	public Integer execute(Object custDTO) throws Exception {
		System.out.println("FestUpdateService.excute()");
		// 객체 생성하고 호출
		custDAO.update((FestCustDTO) custDTO);
		return 1;
	}
}
