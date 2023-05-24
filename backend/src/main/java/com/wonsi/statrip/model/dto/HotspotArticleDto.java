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
    private String imgName;
    private int hit;
    private String createdAt;
    
    public HotspotArticleDto() {}

	public HotspotArticleDto(int articleNo, String userId, int planId, int attractionId, 
			String imgName, String imgPath, int hit, String createdAt) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.planId = planId;
		this.attractionId = attractionId;
		this.imgName = imgName;
		this.imgPath = imgPath;
		this.hit = hit;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "HotspotArticleDto [articleNo=" + articleNo + ", userId=" + userId + ", planId=" + planId
				+ ", attractionId=" + attractionId + ", imgName=" + imgName + ", imgPath=" + imgPath + 
				", hit=" + hit + ", createdAt=" + createdAt + "]";
	}
    
	
    
}
