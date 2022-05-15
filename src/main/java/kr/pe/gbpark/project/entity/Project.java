package kr.pe.gbpark.project.entity;

import kr.pe.gbpark.util.entity.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project extends Board {
	private String linkAddress;
	private String mainColor;
	private int displayOrder;
	//todo - make join badge entity
	//private String badge;


	public Project(String title, String content, String linkAddress, String mainColor, int displayOrder) {
		super(title, content);
		this.linkAddress = linkAddress;
		// todo - need random color generator??
		this.mainColor = StringUtils.isNotBlank(mainColor) ? mainColor : "black";
		this.displayOrder = displayOrder;
	}

	public boolean isBlank() {
		return StringUtils.isAnyBlank(this.getTitle(), this.getContent());
	}
}
