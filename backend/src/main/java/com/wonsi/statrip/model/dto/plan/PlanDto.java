package com.wonsi.statrip.model.dto.plan;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlanDto {
    int planId;
    String userId;
    String title;
    List<Integer> attractions;
    String createdAt;
    
    

    public PlanDto(int planId, String userId, String title, String createdAt) {
        this.planId = planId;
        this.userId = userId;
        this.title = title;
        this.createdAt = createdAt;
    }

    public PlanDto(String userId, String title, List<Integer> attractions) {
        this.userId = userId;
        this.title = title;
        this.attractions = attractions;
    }

    public PlanDto(int planId, String userId, String title, List<Integer> attractions, String createdAt) {
        this.planId = planId;
        this.userId = userId;
        this.title = title;
        this.attractions = attractions;
        this.createdAt = createdAt;
    }

	public PlanDto() {
		super();
	}
}
