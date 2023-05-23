package com.wonsi.statrip.model.repository;


import java.util.List;

import com.wonsi.statrip.model.dto.HotspotArticleDto;

public interface HotspotArticleRepository {
    void writeArticle(HotspotArticleDto hotspotArticleDto) throws Exception;
    List<HotspotArticleDto> listArticle() throws Exception;
    HotspotArticleDto getArticle(int articleNo) throws Exception;
    void updateHit(int articleNo) throws Exception;
}
