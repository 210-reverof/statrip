package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.ShareArticleDto;
import com.wonsi.statrip.model.repository.CommentRepository;
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
    	String thumbnail = session.getMapper(ShareArticleRepository.class).getThumbnail(shareArticleDto.getPlanId());
    	if (thumbnail != null) shareArticleDto.setThumbnail(thumbnail);
        session.getMapper(ShareArticleRepository.class).writeArticle(shareArticleDto);
    }

    @Override
    public List<ShareArticleDto> listArticle() throws Exception {
        return session.getMapper(ShareArticleRepository.class).listArticle();
    }

    @Override
    public ShareArticleDto getArticle(int articleNo) throws Exception {
    	session.getMapper(ShareArticleRepository.class).updateHit(articleNo);
        return session.getMapper(ShareArticleRepository.class).getArticle(articleNo);
    }

    @Override
    public void likeArticle(String userId, int articleNo) throws Exception {
        session.getMapper(ShareArticleRepository.class).likeArticle(userId, articleNo);
    }

	@Override
	public void deleteArticle(int no) throws Exception {
		session.getMapper(ShareArticleRepository.class).deleteLikeByArticle(no);
		session.getMapper(CommentRepository.class).deleteCommentByShareId(no);
		session.getMapper(ShareArticleRepository.class).deleteArticle(no);
		
	}

	@Override
	public boolean doILike(String userId, int articleNo) {
		String u = session.getMapper(ShareArticleRepository.class).doILike(userId, articleNo);
		if (u == null) return false;
		return true;
		
	}
}
