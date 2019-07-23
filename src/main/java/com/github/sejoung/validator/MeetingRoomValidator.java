package com.github.sejoung.validator;

import com.github.sejoung.repositories.MeetingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MeetingRoomValidator {
	private final MeetingRoomRepository meetingRoomRepository;

	public void validate(Long meetingRoomId) {
		if (meetingRoomRepository.findById(meetingRoomId).isEmpty()) {
			throw new IllegalArgumentException("잘못된 회의실 입니다.");
		}
	}

}
