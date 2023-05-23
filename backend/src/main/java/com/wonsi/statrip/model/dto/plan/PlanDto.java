package com.wonsi.statrip.model.dto.plan;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PlanDto {
    int planId;
    String userId;
    String title;
    List<Integer> attractions;
    String createdAt;
    int present1;
    int present2;
    int present3;
    int attractionWeight = 0;
    

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

	public PlanDto(int planId, String userId, String title, List<Integer> attractions, String createdAt, int present1, int present2, int present3) {
		this.planId = planId;
		this.userId = userId;
		this.title = title;
		this.attractions = attractions;
		this.createdAt = createdAt;
		this.present1 = present1;
		this.present2 = present2;
		this.present3 = present3;
	}
}
