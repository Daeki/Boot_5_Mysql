package com.iu.b5.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b5.util.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private FileManager fileManager;
	
	public int setInsert(MemberVO memberVO, MultipartFile files)throws Exception{
		int result = memberRepository.setInsert(memberVO);
		
		if(!files.isEmpty()) {
			String fileName = fileManager.getUseServletContext("upload/member", files);
			MemberFilesVO memberFilesVO = new MemberFilesVO();
			memberFilesVO.setMember_id(memberVO.getId());
			memberFilesVO.setFileName(fileName);
			memberFilesVO.setOriName(files.getOriginalFilename());
			result = memberRepository.setFileInsert(memberFilesVO);
		}
		return result;
	}

}
