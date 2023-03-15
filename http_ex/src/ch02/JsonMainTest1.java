package ch02;

import com.google.gson.JsonObject;

public class JsonMainTest1 {

	public static void main(String[] args) {

//		출발
//		JSON 형식의 문자열을 만드는 방법
//		1. 직접 형식을 지켜서 만든다.
		String myJson = "{\r\n"
				+ "	\"name\" : \"티모\"\r\n"
				+ "}";
		System.out.println(myJson);
		
		
		
		JsonObject jsonObject1 = new JsonObject();
//		{ } <-- 여기까지 만들어 줌
		jsonObject1.addProperty("name", "티모");
		System.out.println(jsonObject1);
	}

}
