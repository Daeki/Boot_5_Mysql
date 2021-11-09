package com.iu.b5.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.iu.b5.board.BoardMapper;
@Mapper
public interface QnaRepository extends BoardMapper {
	
	public int setReplyInsert(QnaVO qnaVO)throws Exception;

}
