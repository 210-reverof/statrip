package com.wonsi.statrip.model.repository;

import com.wonsi.statrip.model.dto.ShareArticleDto;

import java.util.List;
import java.util.Map;

public interface ShareArticleRepository {
    void writeArticle(ShareArticleDto shareArticleDto) throws Exception;
    List<ShareArticleDto> listArticle(Map<String, String> map) throws Exception;
    ShareArticleDto getArticle(int articleNo) throws Exception;
    void updateHit(int articleNo) throws Exception;
}
