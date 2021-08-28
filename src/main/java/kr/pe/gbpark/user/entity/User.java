package kr.pe.gbpark.user.entity;

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
public class User extends BaseTimeEntity {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;

	private String mail;
	private String name;
	private String pw;
	private int gbPoint;

	public User(String mail, String name, String pw) {
		this.mail = mail;
		this.name = name;
		this.pw = pw;
		this.gbPoint = 5000;
	}

	public int changePoint(int diff) {
		this.gbPoint += diff;
		return this.gbPoint;
	}
}
