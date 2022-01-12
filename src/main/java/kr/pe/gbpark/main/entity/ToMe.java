package kr.pe.gbpark.main.entity;

import kr.pe.gbpark.util.entity.BaseEntity;
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
public class ToMe extends BaseEntity {
	@Id
	@GeneratedValue
	@Column(name = "to_me_id")
	private Long id;

	private String title;
	private String tel;
	private String message;

	public ToMe(String title, String tel, String message) {
		this.title = title;
		this.tel = tel;
		this.message = message;
	}
}
