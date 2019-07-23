package com.github.sejoung.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public class ReservationKey implements Serializable {

	@OneToOne
	private MeetingRoom meetingRoom;

	@Column
	private LocalDateTime reservationStartTime;

	@Column
	private LocalDateTime reservationEndTime;

	@Builder
	private ReservationKey(MeetingRoom meetingRoom, LocalDateTime reservationStartTime,
			LocalDateTime reservationEndTime) {
		this.meetingRoom = meetingRoom;
		this.reservationStartTime = reservationStartTime;
		this.reservationEndTime = reservationEndTime;
	}
}
