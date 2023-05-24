package com.wonsi.statrip.model.repository;

import com.wonsi.statrip.model.dto.ShareArticleDto;

import java.util.List;

public interface ShareArticleRepository {
	String getThumbnail(int planId) throws Exception;
    void writeArticle(ShareArticleDto shareArticleDto) throws Exception;
    List<ShareArticleDto> listArticle() throws Exception;
    ShareArticleDto getArticle(int articleNo) throws Exception;
    void updateHit(int articleNo) throws Exception;
    void likeArticle(String userId, int articleNo);
    void deleteArticle(int articleNo);
    void deleteLikeByArticle(int articleNo);
    String doILike(String userId, int articleNo);
}
