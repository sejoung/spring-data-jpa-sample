package com.github.sejoung.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
	private Long id;

	@Column
	private LocalDateTime reservationStartTime;

	@Column
	private LocalDateTime reservationEndTime;

	@OneToOne
	private MeetingRoom meetingRoom;

	@OneToOne
	private User user;

	@Builder
	private Reservation(MeetingRoom meetingRoom, LocalDateTime reservationStartTime,
			LocalDateTime reservationEndTime, User user) {
		this.meetingRoom = meetingRoom;
		this.reservationStartTime = reservationStartTime;
		this.reservationEndTime = reservationEndTime;
		this.user = user;
	}
}
