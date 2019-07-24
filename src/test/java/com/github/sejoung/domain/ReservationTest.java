package com.github.sejoung.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class ReservationTest {

	@Test
	public void equalsTest() {
		var reservation = Reservation.builder().meetingRoomId(1L).userId(1L).reservationEndTime(
				LocalDateTime.now().plusMinutes(20)).reservationStartTime(LocalDateTime.now()).build();
		var reservation2 = Reservation.builder().meetingRoomId(1L).userId(1L)
				.reservationEndTime(LocalDateTime.now().plusMinutes(30))
				.reservationStartTime(LocalDateTime.now().plusMinutes(20)).build();
		var reservation3 = Reservation.builder().meetingRoomId(1L).userId(1L)
				.reservationEndTime(LocalDateTime.now().plusMinutes(30))
				.reservationStartTime(LocalDateTime.now().plusMinutes(10)).build();
		var reservation4 = Reservation.builder().meetingRoomId(2L).userId(1L)
				.reservationEndTime(LocalDateTime.now().plusMinutes(30))
				.reservationStartTime(LocalDateTime.now().plusMinutes(10)).build();

		assertThat(reservation.equals(reservation2)).isFalse();
		assertThat(reservation.equals(reservation3)).isTrue();
		assertThat(reservation.equals(reservation4)).isFalse();

	}
}