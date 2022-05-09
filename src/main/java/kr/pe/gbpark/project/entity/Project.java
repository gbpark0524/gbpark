package kr.pe.gbpark.project.entity;

import kr.pe.gbpark.util.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project extends BaseTimeEntity {
	@Id
	@GeneratedValue
	@Column(name = "project_id")
	private Long id;

	private int orderNumber;
	private String title;
	private String link;
	private String colorCode;
	private String description;

	public Project(String title, String link, String colorCode, String description) {
		this.title = title;
		this.link = link;
		this.colorCode = colorCode;
		this.description = description;
		this.orderNumber = 0;
	}
}
