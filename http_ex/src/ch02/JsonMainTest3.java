package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonMainTest3 {

	public static void main(String[] args) {

		JsonArray jsonArray = new JsonArray();
//		[]  <-- 이 형태
//		jsonObject
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "티모");

		System.out.println(jsonArray);
		System.out.println("-----------------");
		System.out.println(jsonObject);

		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);

		System.out.println("---------------");
		System.out.println(jsonArray);

		System.out.println("================");

		JsonArray array = new JsonArray();

		JsonObject jsonObject1 = new JsonObject();
		jsonObject1.addProperty("userId", 1);
		jsonObject1.addProperty("id", 1);
		jsonObject1.addProperty("title", "delectus aut autem");
		jsonObject1.addProperty("completed", false);

		JsonObject jsonObject2 = new JsonObject();
		jsonObject2.addProperty("userId", 1);
		jsonObject2.addProperty("id", 2);
		jsonObject2.addProperty("title", "quis ut nam facilis et officia qui");
		jsonObject2.addProperty("completed", false);

		JsonObject jsonObject3 = new JsonObject();
		jsonObject3.addProperty("userId", 1);
		jsonObject3.addProperty("id", 3);
		jsonObject3.addProperty("title", "fugiat veniam minus");
		jsonObject3.addProperty("completed", false);

		array.add(jsonObject1);
		array.add(jsonObject2);
		array.add(jsonObject3);

		System.out.println(array);

//		JsonArray에서 JsonObject 꺼내는 방법
		JsonObject targetObject = jsonArray.get(2).getAsJsonObject(); // 3-> 런타임Exception
		System.out.println(targetObject);
		String strName = targetObject.get("name").getAsString();
		System.out.println(strName);
	}

}
