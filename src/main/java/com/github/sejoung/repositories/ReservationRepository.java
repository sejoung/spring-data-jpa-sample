package com.github.sejoung.repositories;

import com.github.sejoung.domain.Reservation;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findAllByReservationEndTimeBeforeAndReservationStartTimeAfter(
			LocalDateTime startTime, LocalDateTime endTime);
}
