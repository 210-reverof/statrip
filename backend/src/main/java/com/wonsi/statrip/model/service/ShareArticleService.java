package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.ShareArticleDto;

import java.util.List;
import java.util.Map;

public interface ShareArticleService {
    void writeArticle(ShareArticleDto shareArticleDto) throws Exception;
    List<ShareArticleDto> listArticle() throws Exception;
    ShareArticleDto getArticle(int articleNo) throws Exception;
    void likeArticle(String userId, int articleNo) throws Exception;
	void deleteArticle(int no) throws Exception;
	boolean doILike(String userId, int articleNo);
}
