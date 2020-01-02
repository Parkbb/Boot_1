package com.iu.b1.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberJoin")
	public String memberJoin() throws Exception{
		return "member/memberJoin";
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile files) throws Exception{
		int result = memberService.memberJoin(memberVO, files);
		ModelAndView mv = new ModelAndView();
		String msg = "가입 실패";
		if(result >0 )
			msg = "가입 성공";
		
		String path = "../";
		mv.addObject("message", msg);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");
		return mv;
		
	}
	
	@GetMapping("memberLogin")
	public String memberLogin() throws Exception{
		return "member/memberLogin";
	}
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO, ModelAndView mv, HttpSession session) throws Exception{
		memberVO = memberService.memberLogin(memberVO);
		
		String msg = "아이디 혹은 비밀번호가 일치하지 않습니다";
		String path = "../member/memberLogin";
		if(memberVO != null) {
		
			msg = "로그인 성공";
			path = "../";
			session.setAttribute("memberVO", memberVO);
		}
		
		mv.addObject("message", msg);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");
		return mv;
	}
	
	@GetMapping("memberLogOut")
	public ModelAndView memberLogOut(MemberVO memberVO, ModelAndView mv, HttpSession session) throws Exception{
		session.invalidate();
		mv.addObject("message", "로그아웃 되었습니다.");
		mv.addObject("path", "../");
		mv.setViewName("common/commonResult");
		return mv;
	}
	@GetMapping("Mypage")
	public ModelAndView Mypage(HttpSession session, ModelAndView mv) throws Exception{
		
		MemberVO memberVO = new MemberVO();
		memberVO =(MemberVO)session.getAttribute("memberVO");
		memberVO = memberService.Mypage(memberVO);
		mv.addObject("member", memberVO);
		mv.setViewName("member/Mypage");
		
		return mv;
	}
	@GetMapping("memberFileDown")
	public ModelAndView memberFileDown(MemberFilesVO memberFilesVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberFilesVO = memberService.memberFilesSelect(memberFilesVO);
		
		if(memberFilesVO != null) {
			mv.addObject("memberfiles", memberFilesVO);
			mv.addObject("path", "upload");
			mv.setViewName("fileDown");
			
		}else {
			mv.addObject("message", "존재하지 않는 파일입니다.");
			mv.addObject("path", "../member/Mypage");
			mv.setViewName("common/commonResult");
		}
		
		return mv;
	}
	
}
