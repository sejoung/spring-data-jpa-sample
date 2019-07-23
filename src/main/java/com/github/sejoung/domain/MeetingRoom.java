package com.github.sejoung.domain;

import com.github.sejoung.constants.RoomSize;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Entity
@Table(name = "TB_MEETING_ROOM")
public class MeetingRoom extends AbstractTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MEETING_ROOM_ID")
	private Long id;

	@Column
	private String name;

	@Column
	@Enumerated(EnumType.STRING)
	private RoomSize roomSize;

	@Builder
	private MeetingRoom(String name, RoomSize roomSize) {
		this.name = name;
		this.roomSize = roomSize;
	}
}
