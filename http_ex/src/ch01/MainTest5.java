package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainTest5 {

	public static void main(String[] args) {

		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int statusCode = conn.getResponseCode();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = null;
			StringBuffer sb = new StringBuffer();
			while((line = reader.readLine())!=null) {
				sb.append(line);
			}
			String result = sb.toString();
			
			Gson gson = new Gson();
			Type listType = new TypeToken<List<User>>() {}.getType();
			System.out.println(result.toString());
			System.out.println("==========");
			ArrayList<User> userList = gson.fromJson(result, listType);
			
			for (User userDTO : userList) {
				System.out.println(userDTO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
