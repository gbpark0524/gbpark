package kr.pe.gbpark.main.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public abstract class NotionDto {


	@JsonProperty("url")
	private String url;
	@JsonProperty("properties")
	private Properties properties;
	@JsonProperty("archived")
	private boolean archived;
	@JsonProperty("parent")
	private Parent parent;
	@JsonProperty("last_edited_time")
	private String last_edited_time;
	@JsonProperty("created_time")
	private String created_time;
	@JsonProperty("id")
	private String id;
	@JsonProperty("object")
	private String object;

	@Data
	public static class Properties {
		@JsonProperty("title")
		private PropertiesTitle propertiesTitle;
	}

	@Data
	public static class PropertiesTitle {
		@JsonProperty("title")
		private List<Title> title;
		@JsonProperty("type")
		private String type;
		@JsonProperty("id")
		private String id;
	}

	@Data
	public static class Title {
		@JsonProperty("plain_text")
		private String plain_text;
		@JsonProperty("annotations")
		private Annotations annotations;
		@JsonProperty("text")
		private Text text;
		@JsonProperty("type")
		private String type;
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
	}

	@Data
	public static class Parent {
		@JsonProperty("page_id")
		private String page_id;
		@JsonProperty("type")
		private String type;
	}
}
