package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.HotspotArticleDto;
import com.wonsi.statrip.model.dto.ShareArticleDto;
import com.wonsi.statrip.model.repository.HotspotArticleRepository;
import com.wonsi.statrip.model.repository.ShareArticleRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HotspotArticleServiceImpl implements HotspotArticleService {
    @Autowired
    SqlSession session;

    @Override
    public void writeArticle(HotspotArticleDto hotspotArticleDto) throws Exception {
    	System.out.println(hotspotArticleDto.toString());
    	session.getMapper(HotspotArticleRepository.class).writeArticle(hotspotArticleDto);
    }

    @Override
    public List<HotspotArticleDto> listArticle() throws Exception {
        return session.getMapper(HotspotArticleRepository.class).listArticle();
    }

    @Override
    public HotspotArticleDto getArticle(int articleNo) throws Exception {
    	System.out.println("getArticlegetArticle : " + articleNo);
    	session.getMapper(HotspotArticleRepository.class).updateHit(articleNo);
        return session.getMapper(HotspotArticleRepository.class).getArticle(articleNo);
    }

	@Override
	public void deleteArticle(int articleNo) throws Exception {
    	System.out.println("deleteArticledeleteArticle : "+articleNo);
        session.getMapper(HotspotArticleRepository.class).deleteArticle(articleNo);
	}
}
