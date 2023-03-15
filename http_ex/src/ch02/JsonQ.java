package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonQ {

	public static void main(String[] args) {

//		Q1.
		JsonArray jsonArray1 = new JsonArray();
		JsonObject jsonObject1 = new JsonObject();
		jsonObject1.addProperty("name", "홍길동");
		jsonObject1.addProperty("age", 20);
		jsonObject1.addProperty("address", "부산");

		JsonObject jsonObject2 = new JsonObject();
		jsonObject2.addProperty("name", "이순신");
		jsonObject2.addProperty("age", 33);
		jsonObject2.addProperty("address", "서울");

		JsonObject jsonObject3 = new JsonObject();
		jsonObject3.addProperty("name", "세종대왕");
		jsonObject3.addProperty("age", 59);
		jsonObject3.addProperty("address", "세종시");

		jsonArray1.add(jsonObject1);
		jsonArray1.add(jsonObject2);
		jsonArray1.add(jsonObject3);
		System.out.println(jsonArray1);

		System.out.println("-----------");

//		Q2.
		JsonObject outObject = new JsonObject();
		JsonArray todoArray = new JsonArray();
		JsonObject todoObject1 = new JsonObject();
		todoObject1.addProperty("id", 1);
		todoObject1.addProperty("title", "청소");
		todoObject1.addProperty("complete", false);

		JsonObject todoObject2 = new JsonObject();
		todoObject2.addProperty("id", 2);
		todoObject2.addProperty("title", "영어공부");
		todoObject2.addProperty("complete", true);

		todoArray.add(todoObject1);
		todoArray.add(todoObject2);
		
		outObject.add("todoList", todoArray);
		outObject.addProperty("server_name", "server_1");
		
		System.out.println(outObject);

	}

}
