package com.github.sejoung.validator;

import com.github.sejoung.domain.Reservation;
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
	}

	private void timeValidate() {

	}


}
