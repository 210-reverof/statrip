package com.wonsi.statrip.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShareArticleDto {
    private int articleNo;
    private String userId;
    private int planId;
    private String title;
    private String content;
    private int hit;
    private String createdAt;
    private int likeCnt;

    public ShareArticleDto() {
    }

    public ShareArticleDto(String userId, int planId, String title, String content, int likeCnt) {
        this.userId = userId;
        this.planId = planId;
        this.title = title;
        this.content = content;
        this.likeCnt = likeCnt;
    }
}
