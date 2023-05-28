package com.wonsi.statrip.model.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CloudDto {
	private String name;
	private int value;
	
	public CloudDto(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public CloudDto() {}

}
