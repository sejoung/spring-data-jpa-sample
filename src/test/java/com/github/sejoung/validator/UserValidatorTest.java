package com.github.sejoung.validator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserValidatorTest {

	@Autowired
	private UserValidator userValidator;

	@Test(expected = IllegalArgumentException.class)
	public void 등록된_사용자가_아니다() {
		userValidator.validate(10L);
	}

	@Test
	public void 정상() {
		userValidator.validate(1L);
	}

}