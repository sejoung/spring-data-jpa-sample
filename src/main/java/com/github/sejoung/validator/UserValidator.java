package com.github.sejoung.validator;

import com.github.sejoung.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserValidator {

	private final UserRepository userRepository;

	public void validate(Long userId) {
		if (userRepository.findById(userId).isEmpty()) {
			throw new IllegalArgumentException("잘못된 사용자 입니다.");
		}
	}

}
