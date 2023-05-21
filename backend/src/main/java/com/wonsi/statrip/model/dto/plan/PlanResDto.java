package com.wonsi.statrip.model.dto.plan;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class PlanResDto {
    private int planId;
    private String userId;
    private String title;
    private List<PlanAttrDto> attractions = new ArrayList<>();
    private String createdAt;

    public PlanResDto(int planId, String userId, String title,  String createdAt) {
        this.planId = planId;
        this.userId = userId;
        this.title = title;
        this.createdAt = createdAt;
    }

    public PlanResDto(int planId, String userId, String title, List<PlanAttrDto> attractions, String createdAt) {
        this.planId = planId;
        this.userId = userId;
        this.title = title;
        this.attractions = attractions;
        this.createdAt = createdAt;
    }

    public PlanResDto(int planId) {
        this.planId = planId;
    }
}
