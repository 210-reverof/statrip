package com.wonsi.statrip.model.dto.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphDto {
	List<Integer> boy;
	List<Integer> girl;
	
	public GraphDto(List<Integer> boy, List<Integer> girl) {
		this.boy = boy;
		this.girl = girl;
	}

	public GraphDto() {}
	
}
