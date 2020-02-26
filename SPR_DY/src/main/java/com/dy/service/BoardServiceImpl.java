package com.dy.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dy.mapper.BoardMapper;
import com.dy.model.BoardVO;
import com.dy.model.Criteria;
import com.dy.util.FileUtils;
@Service
public class BoardServiceImpl implements BoardService{
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Autowired
	BoardMapper bm;
	
	//게시판 리스트
	@Override
	public List<BoardVO> listList() throws Exception {
		System.out.println("bm.listList()="+bm.listList());
		return bm.listList();
	}
	//게시판 리스트(페이징)
	@Override
	public List<BoardVO> boardList(Criteria cri) throws Exception {
		return bm.boardList(cri);
	}
	@Override
	public int boardCount(Criteria cri) throws Exception {
		return bm.boardCount(cri);
	}
	//게시판 글 쓰기
	@Transactional
	@Override
	public void write(BoardVO board, MultipartHttpServletRequest mpRequest) throws Exception {
		bm.write(board);
		
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(board,mpRequest);
		int size = list.size();
		for(int i=0; i<size; i++) {
			System.out.println("리스트"+list.get(i));
			bm.insertFile(list.get(i));
		}
	}
	//게시판 글 내용보기
	@Override
	public BoardVO view(int no) throws Exception {
		return bm.view(no);
	}
	//게시판 글 수정
	@Override
	public void change(BoardVO board) throws Exception {
		bm.change(board);
	}
	//게시판 글 삭제
	@Override
	public void remove(BoardVO board) throws Exception {
		bm.remove(board);
	}
	//첨부파일 조회
	@Override
	public List<Map<String, Object>> filelist(int no) throws Exception {
		return bm.filelist(no);
	}


}
