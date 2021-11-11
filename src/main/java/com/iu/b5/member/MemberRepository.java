package com.iu.b5.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Repository
@Mapper
public interface MemberRepository {
	
	//Id 중복 확인
	public MemberVO getSelect(MemberVO memberVO)throws Exception;
	
	//login
	public MemberVO getSelectOne(String username)throws Exception;
	
	//회원가입
	public int setInsert(MemberVO memberVO)throws Exception;
	
	//회원파일
	public int setFileInsert(MemberFilesVO memberFilesVO)throws Exception;
	
	

}
