package com.wonsi.statrip.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountDto {
	private int postCnt;
	private int likeCnt;
	
	public CountDto(int postCnt, int likeCnt) {
		this.postCnt = postCnt;
		this.likeCnt = likeCnt;
	}
	
	public CountDto() {}

}
