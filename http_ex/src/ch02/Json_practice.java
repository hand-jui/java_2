package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Json_practice {

	public static void main(String[] args) {

		JsonObject jsonObject = new JsonObject();
		JsonArray allContentArray = new JsonArray();
		JsonObject allConObject1 = new JsonObject();
		allConObject1.addProperty("seq", 3);
		allConObject1.addProperty("title", "");
		allConObject1.addProperty("description", "");
		allConObject1.addProperty("file_Url", "contents/1669891290236_NINHO.___GROS_VENDEUR(128k).m4a");
		allConObject1.addProperty("userid", "vmorisson@gmail.com");
		allConObject1.addProperty("created_at", "2022-12-01T10:36:47.000Z");
		allConObject1.addProperty("updated_at", "2022-12-01T10:44:34.000Z");

		JsonObject allConObject2 = new JsonObject();
		allConObject2.addProperty("seq", 2);
		allConObject2.addProperty("title", "Vivaldi Winter");
		allConObject2.addProperty("description", "Winter Violin Please Another Instrument");
		allConObject2.addProperty("file_Url", "contents/1669890341097_LInvernoWinter(Solo_Violin).wav");
		allConObject2.addProperty("userid", "incopost@muzen.me");
		allConObject2.addProperty("created_at", "2022-12-01T10:25:45.000Z");
		allConObject2.addProperty("updated_at", "2022-12-01T10:27:39.000Z");
	
		JsonObject allConObject3 = new JsonObject();
		allConObject3.addProperty("seq", 1);
		allConObject3.addProperty("title", "Musement");
		allConObject3.addProperty("description", "Musement");
		allConObject3.addProperty("file_Url", "contents/1669885516389_Muzen.mp3");
		allConObject3.addProperty("userid", "incopost@muzen.me");
		allConObject3.addProperty("created_at", "2022-12-01T09:05:16.000Z");
		allConObject3.addProperty("updated_at", "2022-12-01T10:29:58.000Z");

		allContentArray.add(allConObject1);
		allContentArray.add(allConObject2);
		allContentArray.add(allConObject3);
		
		jsonObject.add("allContent", allContentArray);
		
		System.out.println(jsonObject);
	}

}
