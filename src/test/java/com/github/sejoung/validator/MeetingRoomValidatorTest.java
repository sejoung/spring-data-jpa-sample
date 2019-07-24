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
public class MeetingRoomValidatorTest {

	@Autowired
	private MeetingRoomValidator meetingRoomValidator;

	@Test(expected = IllegalArgumentException.class)
	public void 잘못된_회의실() {
		meetingRoomValidator.validate(10L);
	}

	@Test
	public void 정상() {
		meetingRoomValidator.validate(1L);
	}
}