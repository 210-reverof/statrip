package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.ShareArticleDto;
import com.wonsi.statrip.model.repository.ShareArticleRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShareArticleServiceImpl implements ShareArticleService {
    @Autowired
    SqlSession session;

    @Override
    public void writeArticle(ShareArticleDto shareArticleDto) throws Exception {
        session.getMapper(ShareArticleRepository.class).writeArticle(shareArticleDto);
    }

    @Override
    public List<ShareArticleDto> listArticle() throws Exception {
        return session.getMapper(ShareArticleRepository.class).listArticle();
    }

    @Override
    public ShareArticleDto getArticle(int articleNo) throws Exception {
        return session.getMapper(ShareArticleRepository.class).getArticle(articleNo);
    }

    @Override
    public void updateHit(int articleNo) throws Exception {

    }
}
