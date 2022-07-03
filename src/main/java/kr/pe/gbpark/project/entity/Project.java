package kr.pe.gbpark.project.entity;

import kr.pe.gbpark.util.entity.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project extends Board {
	private String linkAddress;
	private String mainColor = "black";
	private int displayOrder = 0;
	//todo - make join badge entity
	//private String badge;

	public Project(String title, String content, String linkAddress) {
		super(title, content);
		this.linkAddress = linkAddress;
	}
	public Project(String title, String content, String linkAddress, String mainColor) {
		super(title, content);
		this.linkAddress = linkAddress;
		this.mainColor = mainColor;
	}

	public Project(String title, String content, String linkAddress, int displayOrder) {
		super(title, content);
		this.linkAddress = linkAddress;
		this.displayOrder = displayOrder;
	}

	public Project(String title, String content, String linkAddress, String mainColor, int displayOrder) {
		super(title, content);
		this.linkAddress = linkAddress;
		this.mainColor = mainColor;
		this.displayOrder = displayOrder;
	}

	public boolean isBlank() {
		return StringUtils.isAnyBlank(this.getTitle(), this.getContent());
	}

	@Override
	public String toString() {
		return "Project{" +
				"id='" + super.getId() + '\'' +
				"title='" + super.getTitle() + '\'' +
				"content='" + super.getContent() + '\'' +
				"linkAddress='" + linkAddress + '\'' +
				", mainColor='" + mainColor + '\'' +
				", displayOrder=" + displayOrder +
				'}';
	}
}
