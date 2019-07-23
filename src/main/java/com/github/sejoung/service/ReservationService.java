package com.github.sejoung.service;

import com.github.sejoung.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationService {

	private final ReservationRepository reservationRepository;


}
