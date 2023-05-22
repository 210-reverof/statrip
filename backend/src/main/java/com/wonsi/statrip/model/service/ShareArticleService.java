package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.ShareArticleDto;

import java.util.List;
import java.util.Map;

public interface ShareArticleService {
    void writeArticle(ShareArticleDto shareArticleDto) throws Exception;
    List<ShareArticleDto> listArticle(Map<String, String> map) throws Exception;
    ShareArticleDto getArticle(int articleNo) throws Exception;
    void updateHit(int articleNo) throws Exception;
}
