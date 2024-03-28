package com.example.reactspringproject.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reactspringproject.board.mapper.boardMapper;
import com.example.reactspringproject.board.model.boardVO;
import com.example.reactspringproject.board.service.boardService;

@Service
public class boardServiceImpl implements boardService {

	// mapper 세팅
	private final boardMapper boardmapper;

	@Autowired
	public boardServiceImpl(boardMapper boardmapper) {
		this.boardmapper = boardmapper;
	}

	// boardList
	@Override
	public List<boardVO> selectBoardList(Map<String, Object> paramMap) {
		List<boardVO> boardList = boardmapper.selectBoardList(paramMap);
			
		if (boardList.size() < 0) {
			return null;
		}else {
			return boardList;
		}
	}

	// boardListCnt
	@Override
	public int selectBoardListCnt(Map<String, Object> paramMap) {
		int cnt = boardmapper.selectBoardListcnt(paramMap);
		
		if(cnt > 0) {
			return cnt;
		}else {
			return 0;
		}
	}

	// boardDetail
	@Override
	public boardVO selectBoardDetail(Map<String, Object> paramMap) {
		boardVO boardDetail = boardmapper.selectBoardDetail(paramMap);

		return boardDetail;
	}

	// insertBoard
	@Override
	public int insertBoard(Map<String, Object> paramMap) {
		int cnt = boardmapper.insertBoard(paramMap);
		return cnt;
	}

	// updateBoard
	@Override
	public int updateBoard(Map<String, Object> paramMap) {
		int cnt = boardmapper.updateBoard(paramMap);
		return cnt;
	}
}
