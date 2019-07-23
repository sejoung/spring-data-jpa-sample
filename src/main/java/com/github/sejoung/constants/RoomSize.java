package com.github.sejoung.constants;

import lombok.Getter;

@Getter
public enum RoomSize {
	FOUR("4인"), SIX("6인"), EIGHT("8인");

	private String description;

	RoomSize(String description) {
		this.description = description;
	}


}
