package com.example.reactspringproject.board.service;

import java.util.List;
import java.util.Map;

import com.example.reactspringproject.board.model.boardVO;

public interface boardService {
	
	//boardList
	public List<boardVO> selectBoardList(Map<String,Object> paramMap);
	
	//boardListCnt
	public int selectBoardListCnt(Map<String,Object> paramMap);
	
	//boardDetail
	public boardVO selectBoardDetail(Map<String,Object> paramMap);
	
	//boardInsert
	public int insertBoard(Map<String,Object> paramMap);
	
	//boardUpdate
	public int updateBoard(Map<String,Object> paramMap);
	
}
