package com.foodtruck.review.service;

import java.util.List;

import com.foodtruck.review.dao.ReviewDAO;
import com.foodtruck.review.dto.ReviewDTO;
import com.foodtruck.util.ServiceInterface;
import com.webjjang.util.PageObject2;

public class ReviewListService implements ServiceInterface {

	private ReviewDAO ReviewDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.ReviewDAO = (ReviewDAO) obj;
	}

	@Override
	public List<ReviewDTO> execute(Object obj) throws Exception {
		// TODO Auto-generated method stub
		// list이므로 obj는 필요 없다.
		// list객체 생성
		List<ReviewDTO> list = null;
		// DAO에서 list를 받아온다.
		list = ReviewDAO.list((PageObject2) obj);
		return list;

	}
}
