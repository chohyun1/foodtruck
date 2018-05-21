package test;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.foodtruck.util.GetJsonData;
import com.foodtruck.util.MongoDBUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {

	public static void main(String[] args) throws Exception {
		// mlab에 접속해서 사용 할 때의 코드
		// mLab 온라인 database에 접속
		MongoDatabase mongodb = MongoDBUtil.getConnection("seoulpopulation");
		// mongocollection을 이용하여 database에 있는 컬렉션에 접근
		MongoCollection<Document> collection = mongodb.getCollection("population");

		// collection에 넣기 위한 방법
		GetJsonData getJsonData = new GetJsonData();
		// 1년치 데이터를 수집하기 위한 date array 설정
		String[] date = { "201611", "201612", "201701", "201702", "201703", "201704", "201705", "201706", "201707",
				"201708", "201709", "201710", "201711" };
		List<Document> list = null;
		for (int i = 0; i <= 12; i++) {
			if (list == null)
				list = new ArrayList<Document>(); // list가 null이면 리스트를 생성
			String dateInfo = date[i]; // yyyymm을 설정해준다.
			list = getJsonData.getListDocument(dateInfo, "population");

			collection.insertMany(list);
		} // end of for;

	}// end of main()

}// end of class Main{}