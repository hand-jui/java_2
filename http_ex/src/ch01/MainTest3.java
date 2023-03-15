package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class MainTest3 {

	public static void main(String[] args) {

//		URL
//		.. I/O
//		POST <==단 ch01 패키지에서 
//		값을 담아 콘솔창에 출력

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/19");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int statusCode = conn.getResponseCode();
			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = null;
				StringBuffer sb = new StringBuffer();
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				String str = sb.toString();
				
				Gson gson = new Gson();
				Todo todo = gson.fromJson(str, Todo.class);
				System.out.println("userId : "+todo.getUserId());
				System.out.println("id : "+todo.getId());
				System.out.println("title : "+todo.getTitle());
//				System.out.println("body : "+todo.getBody());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
