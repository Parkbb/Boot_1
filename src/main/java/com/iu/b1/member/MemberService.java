package com.iu.b1.member;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGe;
import com.iu.b1.util.FileSaver;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MemberFilesMapper MemberFilesMapper;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FilePathGe filePathGe;
	@Autowired
	private FileSaver fileSaver;
	
	public int memberJoin(MemberVO memberVO, MultipartFile files) throws Exception{
		//파일을 저장할 폴더
		File file =filePathGe.getUseClassPathResource("upload");
		String fileName = fileSaver.save(files, file);
		System.out.println(fileName);
		
		int result =memberMapper.memberJoin(memberVO);
		MemberFilesVO memberFilesVO = new MemberFilesVO();
		memberFilesVO.setId(memberVO.getId());
		memberFilesVO.setFname(fileName);
		memberFilesVO.setOname(files.getOriginalFilename());
		int result2 = MemberFilesMapper.memberJoin(memberFilesVO);
		
		result = result + result2;
		return result;
	}
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception{
		return memberMapper.memberLogin(memberVO);
	}
	
	public MemberVO Mypage(MemberVO memberVO) throws Exception{
		return memberMapper.Mypage(memberVO);
	}
	public MemberFilesVO memberFilesSelect(MemberFilesVO memberFilesVO) throws Exception{
		return MemberFilesMapper.memberFilesSelect(memberFilesVO);
	}
}
