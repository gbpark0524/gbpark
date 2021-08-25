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

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WaitingMail extends BaseTimeEntity{
	@Id
	@GeneratedValue
	@Column(name = "w_mail_id")
	private Long id;

	private String email;
	private boolean certification;
}
