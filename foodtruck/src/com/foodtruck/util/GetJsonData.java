/*

 * 서울시 열린 데이터 광장에서 json 데이터를 얻는 클래스. String타입의 json 데이터가 나오게 된다.

 */

package com.foodtruck.util;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GetJsonData {
	
	// 데이터를 월별로 파징해서 개별 JSON데이터를 얻어내는 메서드
	public List<Document> getListDocument(String date, String collectionName) throws Exception {
		List<Document> list = null;
		String json = gettingJsonDataString(date, collectionName);
		// 자료를 얻을 위치의 맨처음
		final int START = json.indexOf("[");
		// 자료를 얻을 위치의 맨끝
		final int END = json.lastIndexOf("]");
		// 데이터를 파징하기 위한 위치 자료
		int start = json.indexOf("{", START);
		int end = json.indexOf("}", START) + 1; // }를 포함시키기 위해 +1

		while (true) {
			// 리스트를 새로 생성
			if (list == null)
				list = new ArrayList<Document>();
			// start, end를 이용해서 데이터를 substring한다.
			String result = json.substring(start, end);
			// 타입을 변환시켜 리스트에 넣을 수 있도록 바꾼다. type : BSON
			Document document = Document.parse(result);
			// 리스트에 담는다.
			list.add(document);
			// 다음 데이터를 얻기 위해서 
			// 시작점은 이전 끝점부터 찾고 끝점은 기존 끝점에 +1을 한 위치에서 찾는다.
			start = json.indexOf("{", end);
			end = json.indexOf("}", start + 1) + 1; // }를 포함시키기 위해 +1
			// }] 형태를 찾아 끝낸다.
			if (end == END)
				break;
		}

		return list;
	}

	public Document gettingJsonData(String date, String collectionName) throws Exception { // yyyymm인 date값을 넣어주면
		String result = gettingJsonDataString(date, collectionName);
		Document document = Document.parse(result).append("date", date);

		return document;
	}// end of gettingJsonData()

	public String gettingJsonDataString(String date, String collectionName) throws Exception {
		// yyyymm인 date값을 넣어주면 String형태의 json파일이 나온다.
		// open api에서 json 데이터를 가져오고 MongoDB에 넣을 수 있는 String형태로 바꿔준다
		// 객체 생성
		JSONParser jsonparser = new JSONParser();
		// URL에서 얻은 json형태의 데이터를 JSONObject에 저장한다. (type : JSONObject)
		JSONObject jsonobject = (JSONObject) jsonparser.parse(readUrl(date, collectionName));
		// 얻은 JSONObject데이터를 String 형태로 바꿔 준다. (type : String)
		String result = jsonobject.toJSONString();

		return result;
	}// end of gettingJsonData()

	private String readUrl(String date, String collectionName) throws Exception {

		BufferedInputStream reader = null;

		try {

			// url을 만들기 위한 객체들
			String key = "48775349576965733639576b57676d"; // 서울 오픈데이터에서 사용되는 key
			String dataType = "json"; // 데이터 타입. jsom, xml, xls 가능
			String start = "2001"; // 얻을 데이터 시작값
			String end = "3000"; // 얻을 데이터 끝값
			String yyyymm = date; // 연도와 월을 지정
			String dataInfo = null; // 얻을 데이터의 정보
			switch (collectionName) { // 여기를 통해서 얻는 데이터가 달라진다.
			case "resident":
				dataInfo = "InfoTrdhlRepop";
				break;
			case "emp":
				dataInfo = "InfoTrdhlWrcPopltn";
				break;
			case "apart":
				dataInfo = "InfoTrdhlApt";
				break;
			case "earn":
				dataInfo = "TrdarFlpop";
				break;
			case "sales":
				dataInfo = "InfoTrdhlSelng";
				break;
			case "facility":
				dataInfo = "InfoTrdhlFclty";
				break;
			case "store":
				dataInfo = "InfoTrdhlStor";
				break;
			case "population":
				dataInfo = "InfoTrdhlFlpop";
				break;
			}
			// 실제 집어넣을 데이터를 조합한다.
			String inputUrl = "http://openapi.seoul.go.kr:8088/" + key + "/" + dataType + "/" + dataInfo + "/" + start
					+ "/" + end + "/" + yyyymm;
			// URL 타입에서 url을 뽑아내는 과정. 추후 해석.
			URL url = new URL(inputUrl);
			reader = new BufferedInputStream(url.openStream());
			StringBuilder stringBuilder = new StringBuilder();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				stringBuilder.append(new String(b, 0, i));
			}
			return stringBuilder.toString();
		} finally {
			if (reader != null)
				reader.close();
		} // end of try-catch()

	}// end of readUrl()

	// public List<Document> getJsonListData(String date) throws Exception {
	// // gson을 호출한다.
	// Gson gson = new Gson();
	// // TypeToken으로 List<Document> 타입을 저장한다.
	// TypeToken<List<Document>> token = new TypeToken<List<Document>>() {
	// };
	// // list에 주어진 자료들을 넣어 List<Document>타입으로 만든다.
	// List<Document> list = gson.fromJson(gettingJsonData(date), token.getType());
	//
	// return list;
	// }// end of getJsonListData()

}// end of getJsonData{}