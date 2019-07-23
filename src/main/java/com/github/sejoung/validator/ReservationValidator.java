package com.github.sejoung.validator;

import com.github.sejoung.domain.Reservation;
import com.github.sejoung.exception.ReservationException;
import com.github.sejoung.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
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

    protected void timeValidate(Reservation reservation) {

        reservationRepository.findAll().forEach(reservationObj -> {
            if (reservationObj.getMeetingRoomId() == reservation.getMeetingRoomId() &&
                    reservationObj.getReservationStartTime().isAfter(reservation.getReservationStartTime())
                    && reservationObj.getReservationEndTime().isBefore(reservation.getReservationStartTime())) {
                throw new ReservationException("예약된 시간이 존재 합니다.");

            }

        });

    }


}
