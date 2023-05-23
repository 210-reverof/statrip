package com.wonsi.statrip.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotspotArticleDto {
    private int articleNo;
    private String userId;
    private int planId;
    private int attractionId;
    private String imgPath;
    private int hit;
    private String createdAt;
    
    public HotspotArticleDto() {}
    
	public HotspotArticleDto(int articleNo, String userId, int planId, int attractionId, String imgPath, int hit,
			String createdAt) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.planId = planId;
		this.attractionId = attractionId;
		this.imgPath = imgPath;
		this.hit = hit;
		this.createdAt = createdAt;
	}
    
}
