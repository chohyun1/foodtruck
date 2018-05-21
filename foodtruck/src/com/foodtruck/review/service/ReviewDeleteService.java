package com.foodtruck.review.service;

import com.foodtruck.review.dao.ReviewDAO;
import com.foodtruck.util.ServiceInterface;

public class ReviewDeleteService implements ServiceInterface {

	private ReviewDAO ReviewDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.ReviewDAO = (ReviewDAO) obj;
	}

	@Override
	public Object execute(Object no) throws Exception {
		// TODO Auto-generated method stub

		// 전달 받은 데이터를 DAO로 넘겨주기 위해서 Object를 캐스팅
		// DAO로 넘겨 삭제를 진행한다.
		ReviewDAO.delete((int) no);

		return no;
	}
}
