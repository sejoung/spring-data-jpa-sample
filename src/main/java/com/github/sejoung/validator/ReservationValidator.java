package com.github.sejoung.validator;

import com.github.sejoung.domain.Reservation;
import com.github.sejoung.exception.ReservationException;
import com.github.sejoung.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReservationValidator {

	private final ReservationRepository reservationRepository;

	private final UserValidator userValidator;

	private final MeetingRoomValidator meetingRoomValidator;

	public void validate(Reservation reservation) {
		userValidator.validate(reservation.getUserId());
		meetingRoomValidator.validate(reservation.getMeetingRoomId());
		this.timeValidate(reservation);
	}

	private void timeValidate(Reservation reservation) {
		if (reservationRepository
				.findAllByReservationEndTimeBeforeAndMeetingRoomId(reservation.getReservationStartTime(),
						reservation.getMeetingRoomId()).size() > 0) {
			throw new ReservationException("이미 예약된 회의실 입니다.");
		}
	}


}
