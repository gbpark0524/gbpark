package kr.pe.gbpark.main.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.pe.gbpark.main.dto.NotionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.*;

import okhttp3.*;

@Service
public class NotionService {
	final Logger logger = LoggerFactory.getLogger(ToMeService.class);

	@Value("${notion.config.authorization}")
	private String AUTHORIZATION;

	public List<NotionDto> getNewNotionList() {
		final String version = "2021-07-27";
		final String index = "log";

		List<NotionDto> results = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		OkHttpClient client = new OkHttpClient().newBuilder()
				.build();
		MediaType mediaType = MediaType.parse("application/json");
		String jsonStr = "{\"query\":\"" + index + "\",\"sort\":{\"direction\":\"descending\",\"timestamp\":\"last_edited_time\"},\"filter\":{\"property\":\"object\",\"value\":\"page\"}}";
		RequestBody body = RequestBody.create(jsonStr, mediaType);
		Request request = new Request.Builder()
				.url("https://api.notion.com/v1/search")
				.method("POST", body)
				.addHeader("Notion-Version", version)
				.addHeader("Authorization", AUTHORIZATION)
				.addHeader("Content-Type", "application/json")
				.build();

		try {
			Response response = client.newCall(request).execute();
			if(response.code() != HttpStatus.OK.value()) throw new Exception("code : " + response.code());

			String strObj = Objects.requireNonNull(response.body()).string();
			Map<String, Object> map = new HashMap<>();
			map = objectMapper.readValue(strObj, new TypeReference<Map<String, Object>>() {});

			if(map.isEmpty()) throw new Exception("returned empty map");

			results = (List<NotionDto>) map.get("results");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return results;
	}
}

