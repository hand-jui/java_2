package com.lhs.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lhs.dto.AlbumJsonDTO;

public class JsonParser<T> {
	private String url;

	public JsonParser(String url) {
		this.url = url;
	}

	public T parsing(Class<T> cls) {
		T result = null;
		try {
			URL url = new URL(this.url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int statusCode = conn.getResponseCode();
			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				String resultStr = sb.toString();
				Gson gson = new Gson();
				result = gson.fromJson(resultStr, cls);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public T[] arrayParsing(Class<T[]> cls) {
		T[] result = null;
		try {
			URL url = new URL(this.url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int statusCode = conn.getResponseCode();
			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuffer sb = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				String resultStr = sb.toString();
				Gson gson = new Gson();
				result = gson.fromJson(resultStr, cls);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
