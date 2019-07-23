package com.github.sejoung.validator;

import com.github.sejoung.domain.Reservation;
import com.github.sejoung.repositories.ReservationRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.Assert.*;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationValidatorTest {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationValidator reservationValidator;

    @Test
    public void timeValidate() {
        var reservation = Reservation.builder().meetingRoomId(1L).userId(1L).reservationEndTime(LocalDateTime.now().plusMinutes(20)).reservationStartTime(LocalDateTime.now()).build();
        reservationRepository.save(reservation);
        var reservation2 = Reservation.builder().meetingRoomId(1L).userId(1L).reservationEndTime(LocalDateTime.now().plusMinutes(30)).reservationStartTime(LocalDateTime.now().plusMinutes(20)).build();

        reservationValidator.timeValidate(reservation);


    }
}