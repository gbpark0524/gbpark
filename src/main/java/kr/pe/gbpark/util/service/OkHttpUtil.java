package kr.pe.gbpark.util.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OkHttpUtil {

	// okhttp rest service
	public static Response okHttpJson(String json, String[] headers) throws Exception{
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(json, mediaType);

		Request.Builder builder = new Request.Builder()
				.url("https://api.notion.com/v1/search")
				.method("POST", body)
				.addHeader("Content-Type", "application/json");

		for (int i = 0; i < headers.length/2; i++) {
			builder.addHeader(headers[i*2],headers[i*2+1]);
		}

		return client.newCall( builder.build()).execute();
	}
}
