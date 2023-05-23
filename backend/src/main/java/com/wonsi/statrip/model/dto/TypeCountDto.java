package com.wonsi.statrip.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeCountDto {
    private int typeId;
    private int cnt;

    public TypeCountDto() {
    }

    public TypeCountDto(int typeId, int cnt) {
        this.typeId = typeId;
        this.cnt = cnt;
    }
}
