package com.example.reactspringproject.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.example.reactspringproject.board.model.boardVO;

@Mapper
public interface boardMapper {
	//boardList
	List<boardVO> selectBoardList(Map<String, Object> paramMap);
	
	//boardListCnt
	int selectBoardListcnt(Map<String,Object> paramMap);
	
	//boardDetail
	boardVO selectBoardDetail(Map<String, Object> paramMap);
	
	//boardInsert
	int insertBoard(Map<String,Object> paramMap);
	
	//boardUpdate
	int updateBoard(Map<String,Object> paramMap);
	
}
