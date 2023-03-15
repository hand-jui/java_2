package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dto.Todo;

public class MainTest2 {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/10");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // 다운캐스팅
//			http 요청 --> 2가지 방식(GET, POST)
			conn.setRequestMethod("GET");
			conn.connect();
			int statusCode = conn.getResponseCode();
//			System.out.println(statusCode);
//			200: 통신, 404: 요청 URL이 없다.
			if (statusCode == 200) {
//				conn
//				기반 스트림 + 보조 스트림 : 데코레이션 패턴
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = null;
				StringBuffer sb = new StringBuffer();
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				String str = sb.toString();
//				System.out.println(sb.toString());
//				JSON parsing 해보기 -> 형식이 있는 문자열 -> Java Object로 변경
				TypeToken<Todo> typeToken = new TypeToken<Todo>() {};
				Gson gson = new Gson();
//				Todo todo = gson.fromJson(str, typeToken.getType());
				Todo todo = gson.fromJson(str, Todo.class);
				System.out.println("id : "+todo.getId());
				System.out.println("userId : "+todo.getUserId());
				System.out.println("title : "+todo.getTitle());
				System.out.println("completed : "+todo.isCompleted());
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
