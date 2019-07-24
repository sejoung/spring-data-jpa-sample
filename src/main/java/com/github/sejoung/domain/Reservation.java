package com.github.sejoung.domain;

import com.github.sejoung.validator.ReservationValidator;
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
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

	public void booking(ReservationValidator validator) {
		validator.validate(this);
	}


	public boolean equals(Reservation reservation) {
		boolean isEquals = false;
		log.debug("this = {}", this);
		log.debug("reservation = {}", reservation);

		if (this.meetingRoomId == reservation.getMeetingRoomId() && this.reservationEndTime
				.isAfter(reservation.getReservationStartTime()) && (
				this.reservationStartTime.isBefore(reservation.getReservationStartTime())
						|| this.reservationStartTime.isEqual(reservation.getReservationStartTime()))) {
			isEquals = true;
		}

		return isEquals;
	}
}
