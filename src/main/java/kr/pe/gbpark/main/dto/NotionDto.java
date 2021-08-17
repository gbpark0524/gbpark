package kr.pe.gbpark.main.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class NotionDto {

	@JsonProperty("has_more")
	private boolean hasMore;
	@JsonProperty("results")
	private List<Results> results;
	@JsonProperty("object")
	private String object;
	@JsonProperty("next_cursor")
	private String nextCursor;

	@Data
	public static class Results {
		@JsonProperty("url")
		private String url;
		@JsonProperty("properties")
		private Properties properties;
		@JsonProperty("archived")
		private boolean archived;
		@JsonProperty("parent")
		private Parent parent;
		@JsonProperty("last_edited_time")
		private String lastEditedTime;
		@JsonProperty("created_time")
		private String createdTime;
		@JsonProperty("id")
		private String id;
		@JsonProperty("object")
		private String object;
	}

	@Data
	public static class Properties {
		@JsonProperty("title")
		private Title title;
	}

	@Data
	public static class Title {
		@JsonProperty("title")
		private List<TitleInTitle> title;
		@JsonProperty("type")
		private String type;
		@JsonProperty("id")
		private String id;
	}

	@Data
	public static class TitleInTitle {
		@JsonProperty("plain_text")
		private String plainText;
		@JsonProperty("annotations")
		private Annotations annotations;
		@JsonProperty("text")
		private Text text;
		@JsonProperty("type")
		private String type;
		@JsonProperty("href")
		private String href;
	}

	@Data
	public static class Annotations {
		@JsonProperty("color")
		private String color;
		@JsonProperty("code")
		private boolean code;
		@JsonProperty("underline")
		private boolean underline;
		@JsonProperty("strikethrough")
		private boolean strikethrough;
		@JsonProperty("italic")
		private boolean italic;
		@JsonProperty("bold")
		private boolean bold;
	}

	@Data
	public static class Text {
		@JsonProperty("content")
		private String content;
		@JsonProperty("link")
		private String link;
	}

	@Data
	public static class Parent {
		@JsonProperty("page_id")
		private String pageId;
		@JsonProperty("type")
		private String type;
	}
}
