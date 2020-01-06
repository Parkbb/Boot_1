package com.iu.b1.notice;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	//noticecontroller내부 모든 메서드 실행 전에 먼저 실행
	@ModelAttribute(name = "noticeVO")
	public NoticeVO getNoticeVO() {
		return new NoticeVO();
	}
	
	@Autowired
	private NoticeService noticeService;
	
//	@GetMapping("noticeWrite")
//	public String noticeWrite(Model model,@ModelAttribute(name = "boardVO") NoticeVO noticeVO) throws Exception{
//		return "notice/noticeWrite";
//	}
	@GetMapping("noticeWrite")
	public void noticeWrite() throws Exception{
		
	}
	
	
	@PostMapping("noticeWrite")
	public ModelAndView noticeWrite(@Valid NoticeVO noticeVO,BindingResult bindingResult, MultipartFile[] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mv.addObject("boadrVO", noticeVO);
			mv.setViewName("notice/noticeWrite");
		}else {
			int result = noticeService.noticeWrite(noticeVO, files);
			String message="작성 실패";
			if(result >0) {
				message="작성 성공";
			}
			mv.addObject("message", message);
			mv.addObject("path", "../");
			mv.setViewName("common/commonResult");
		}
		
		return mv;
	}
}
