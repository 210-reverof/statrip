package com.wonsi.statrip.model.service.plan;

import com.wonsi.statrip.model.dto.plan.AttractionDto;
import com.wonsi.statrip.model.dto.plan.GugunDto;
import com.wonsi.statrip.model.dto.plan.SidoDto;
import com.wonsi.statrip.model.repository.plan.AttractionRepository;
import com.wonsi.statrip.model.service.plan.AttractionService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService {

	@Autowired
	private SqlSession session;

	@Override
	public AttractionDto selectOne(int contentId) {
		return session.getMapper(AttractionRepository.class).selectOne(contentId);
	}


	@Override
	public List<AttractionDto> selectList(int sidoCode, int gugunCode, int[] types) {
		return session.getMapper(AttractionRepository.class).selectList(sidoCode, gugunCode, types);
	}


	@Override
	public List<SidoDto> selectSidoList() {
		return session.getMapper(AttractionRepository.class).selectSidoList();
	}


	@Override
	public List<GugunDto> selectGugunList(int sidoCode) {
		return session.getMapper(AttractionRepository.class).selectGugunList(sidoCode);
	}


	@Override
	public List<AttractionDto> selectIdList(int[] types) {
		return session.getMapper(AttractionRepository.class).selectIdList(types);
	}
}
