package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.HotspotArticleDto;

import java.util.List;
import java.util.Map;

public interface HotspotArticleService {
    void writeArticle(HotspotArticleDto hotspotArticleDto) throws Exception;
    List<HotspotArticleDto> listArticle() throws Exception;
    HotspotArticleDto getArticle(int articleNo) throws Exception;
}
