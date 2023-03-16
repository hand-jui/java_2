package albums2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import albums2.controller.Controller;
import albums2.dto.DTO;

public class MainTest1 {

	public static void main(String[] args) {

		Controller controller = new Controller();

		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/albums");
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
				DTO[] dto = gson.fromJson(str, DTO[].class);
				controller.saveTitle(dto);

				System.out.println(dto[0].getId());
				System.out.println(dto[0].getUserId());
				System.out.println(dto[0].getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
