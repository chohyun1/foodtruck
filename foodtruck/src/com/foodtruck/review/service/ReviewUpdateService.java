package com.foodtruck.review.service;


import java.util.List;

import com.foodtruck.review.dao.ReviewDAO;
import com.foodtruck.review.dto.ReviewDTO;
import com.foodtruck.util.ServiceInterface;

public class ReviewUpdateService implements ServiceInterface {

	private ReviewDAO reviewDAO;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub
		this.reviewDAO = (ReviewDAO) obj;
	}
	@Override
	public Integer execute(Object obj) throws Exception {
		System.out.println("ReviewUpdateService.execute()");
		// 객체 생성하고 호출

		System.out.println(obj);
		System.out.println(obj);
		System.out.println(obj);
		System.out.println(obj);
		ReviewDTO reviewDTO =(ReviewDTO) obj;
		
		int no =reviewDTO.getRno();
		System.out.println(no);
		System.out.println(no);
		System.out.println(no);
		System.out.println(no);
		System.out.println(no);
		
		reviewDAO.update(reviewDTO,no);
		return 1;
		
	}

}
