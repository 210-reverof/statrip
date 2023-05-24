package com.wonsi.statrip.model.dto.plan;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PlanListResDto {
    int planId;
    String userId;
    String title;
    List<Integer> attractions;
    String createdAt;
    int present1;
    String img1;
    int present2;
    String img2;
    int present3;
    String img3;
    int attractionCnt;
    int attractionWeight = 0;

	public PlanListResDto() {
		super();
	}

    public PlanListResDto(int planId, String userId, String title, List<Integer> attractions, String createdAt, int present1, String img1, int present2, String img2, int present3, String img3) {
        this.planId = planId;
        this.userId = userId;
        this.title = title;
        this.attractions = attractions;
        this.createdAt = createdAt;
        this.present1 = present1;
        this.img1 = img1;
        this.present2 = present2;
        this.img2 = img2;
        this.present3 = present3;
        this.img3 = img3;
    }

	public PlanListResDto(int planId, String userId, String title, List<Integer> attractions, String createdAt,
			int present1, String img1, int present2, String img2, int present3, String img3, int attractionCnt,
			int attractionWeight) {
		super();
		this.planId = planId;
		this.userId = userId;
		this.title = title;
		this.attractions = attractions;
		this.createdAt = createdAt;
		this.present1 = present1;
		this.img1 = img1;
		this.present2 = present2;
		this.img2 = img2;
		this.present3 = present3;
		this.img3 = img3;
		this.attractionCnt = attractionCnt;
		this.attractionWeight = attractionWeight;
	}
}
