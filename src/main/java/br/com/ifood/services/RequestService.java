package br.com.ifood.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

	private static HttpURLConnection con;

	public JSONObject request(String url, String method) throws MalformedURLException, IOException {

		try  {
			URL myurl = new URL(url);
			con = (HttpURLConnection) myurl.openConnection();

			con.setRequestMethod(method);

			StringBuffer content;

			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

				String line;
				content = new StringBuffer();

				while ((line = in.readLine()) != null) {
					content.append(line);
				}
			}

			return new JSONObject(content.toString());
		
		} finally {
			con.disconnect();
		}
	}
}
