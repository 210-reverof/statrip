package com.wonsi.statrip.model.service;

import com.wonsi.statrip.model.dto.CommentDto;
import com.wonsi.statrip.model.repository.CommentRepository;
import com.wonsi.statrip.model.repository.plan.PlanRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private SqlSession session;

    @Override
    public void addComment(CommentDto commentDto) throws Exception {
        session.getMapper(CommentRepository.class).addComment(commentDto);
    }

    @Override
    public List<CommentDto> commentByShareId(int shareId) throws Exception {
        return session.getMapper(CommentRepository.class).commentByShareId(shareId);
    }

    @Override
    public void deleteCommentById(int commentId) throws Exception {
        session.getMapper(CommentRepository.class).deleteCommentById(commentId);
    }

    @Override
    public void deleteCommentByUserId(String userId) throws Exception {
        session.getMapper(CommentRepository.class).deleteCommentByUserId(userId);
    }

    @Override
    public void deleteCommentByShareId(int shareId) throws Exception {
        session.getMapper(CommentRepository.class).deleteCommentByShareId(shareId);
    }
}
