package com.github.sejoung.validator;

import com.github.sejoung.domain.Reservation;
import com.github.sejoung.exception.ReservationException;
import com.github.sejoung.repositories.ReservationRepository;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationValidatorTest {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ReservationValidator reservationValidator;

	@Test(expected = ReservationException.class)
	public void 같은시간에_예약을못한다() {
		var reservation = Reservation.builder().meetingRoomId(1L).userId(1L)
				.reservationEndTime(LocalDateTime.now().plusMinutes(20))
				.reservationStartTime(LocalDateTime.now()).build();
		reservationRepository.save(reservation);
		var reservation2 = Reservation.builder().meetingRoomId(1L).userId(1L)
				.reservationEndTime(LocalDateTime.now().plusMinutes(30))
				.reservationStartTime(LocalDateTime.now().plusMinutes(10)).build();
		reservationValidator.timeValidate(reservation2);
	}
}