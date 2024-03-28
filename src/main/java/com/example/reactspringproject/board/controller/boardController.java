package com.example.reactspringproject.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactspringproject.board.model.boardVO;
import com.example.reactspringproject.board.service.boardService;


@RestController
@RequestMapping("/board")
@CrossOrigin("http://localhost:8089")
public class boardController {
	@Autowired
	boardService boardservice;
	
	@RequestMapping(value="/",method= {RequestMethod.GET})
	public Map<String,Object> openServer() {
		Map<String,Object> hello = new HashMap<>();
		
		hello.put("hello", "world");
		
		return hello;
	}
	
	//boardList
	@RequestMapping(value="/selectBoardList",method = {RequestMethod.POST})
	public Map<String,Object> selectBoardList(@RequestBody Map<String,Object> paramMap) {
		String getPageOffset = null;
		int pageOffset = 0;
		
		if(paramMap.get("pageOffset") != null && paramMap.get("pageOffset") != "") {
			getPageOffset = paramMap.get("pageOffset").toString();
			pageOffset = Integer.parseInt(getPageOffset) != 1 ? Integer.parseInt(getPageOffset)*10 : 0;
		}
		
		paramMap.put("pageOffset",pageOffset);
		List<boardVO> result = boardservice.selectBoardList(paramMap);
		int allPage = boardservice.selectBoardListCnt(paramMap);
		
		Map<String,Object> mappingResult = new HashMap<>();
		
		mappingResult.put("boardList", result);
		mappingResult.put("allCnt", allPage);
		
		return mappingResult;
	}
	
	//boardDetail
	@RequestMapping(value="/selectBoardDetail",method = {RequestMethod.POST})
	public boardVO selectBoardDetail(@RequestBody Map<String, Object> paramMap) {
		boardVO result = boardservice.selectBoardDetail(paramMap);
		return result;
	}
	
	//boardMerge(delete,update)
	@RequestMapping(value="/mergeBoard",method = {RequestMethod.POST})
	public int mergeBoard(@RequestBody Map<String, Object> paramMap) {
		int result = 0;
		
		if(paramMap.get("seq") != null && paramMap.get("seq") != "") {
			result = boardservice.updateBoard(paramMap);
		}else {
			result = boardservice.insertBoard(paramMap);
		}
		
		return result;
	}
}
