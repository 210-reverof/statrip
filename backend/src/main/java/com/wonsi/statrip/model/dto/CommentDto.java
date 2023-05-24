package com.wonsi.statrip.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private int commentId;
    private String userId;
    private int shareId;
    private String content;

    public CommentDto() {}

    public CommentDto(String userId, int shareId, String content) {
        this.userId = userId;
        this.shareId = shareId;
        this.content = content;
    }

    public CommentDto(int commentId, String userId, int shareId, String content) {
        this.commentId = commentId;
        this.userId = userId;
        this.shareId = shareId;
        this.content = content;
    }
}
