package kr.pe.gbpark.util.entity;

import kr.pe.gbpark.util.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Board extends BaseEntity {
	@Id
	@GeneratedValue
	@Column(name = "board_id")
	private Long id;

	private String title;
	private String content;

	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
