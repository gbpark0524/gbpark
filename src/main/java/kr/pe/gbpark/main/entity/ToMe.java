package kr.pe.gbpark.main.entity;

import kr.pe.gbpark.util.entity.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ToMe extends Board {
	private String tel;

	public ToMe(String title, String content, String tel) {
		super(title, content);
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Project{" +
				"id='" + super.getId() + '\'' +
				"title='" + super.getTitle() + '\'' +
				"content='" + super.getContent() + '\'' +
				"tel='" + tel +
				'}';
	}
}
