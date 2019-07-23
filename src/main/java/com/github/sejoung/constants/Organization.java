package com.github.sejoung.constants;

import lombok.Getter;

@Getter
public enum Organization {
	OPERATIONS("운영팀"), DEVELOPER("개발팀"), HR("인사팀");

	private String description;

	Organization(String description) {
		this.description = description;
	}

}
