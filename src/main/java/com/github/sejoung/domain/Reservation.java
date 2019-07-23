package com.github.sejoung.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "TB_RESERVATION")
public class Reservation extends AbstractTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESERVATION_ID")
	private Long id;

	@Column(name = "MEETING_ROOM_ID")
	private Long meetingRoomId;

	@Column(name = "USER_ID")
	private Long userId;

	@Column
	private LocalDateTime reservationStartTime;

	@Column
	private LocalDateTime reservationEndTime;

	@Builder
	private Reservation(Long meetingRoomId, Long userId, LocalDateTime reservationStartTime,
			LocalDateTime reservationEndTime) {
		this.meetingRoomId = meetingRoomId;
		this.userId = userId;
		this.reservationStartTime = reservationStartTime;
		this.reservationEndTime = reservationEndTime;
	}
}
