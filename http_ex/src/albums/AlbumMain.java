package albums;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import albums.controller.AlbumController;
import albums.dto.AlbumDTO;

public class AlbumMain {

	public static void main(String[] args) {
		
		AlbumController albumController = new AlbumController();

		URL url;
		try {
			url = new URL("https://jsonplaceholder.typicode.com/albums/1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int statusCode = conn.getResponseCode();
			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = null;
				StringBuffer sb = new StringBuffer();
				while((line = reader.readLine())!=null) {
					sb.append(line);
				}
				String str = sb.toString();
				
				Gson gson = new Gson();
				AlbumDTO albumDTO = gson.fromJson(str, AlbumDTO.class);
				albumController.savePhoto(albumDTO);
				
				System.out.println(albumDTO.getId());
				System.out.println(albumDTO.getUserId());
				System.out.println(albumDTO.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
