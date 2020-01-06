package com.iu.b1.notice;

import java.util.List;

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

import com.iu.b1.util.Pager;

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
		System.out.println(noticeVO.getTitle());
		System.out.println(noticeVO.getWriter());
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getErrorCount());
			System.out.println("어");
			mv.addObject("noticeVO", noticeVO);
			mv.setViewName("notice/noticeWrite");
		}else {
			System.out.println("디");
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
	@GetMapping("noticeList")
	public ModelAndView boardList(ModelAndView mv, Pager pager) throws Exception{
		
		List<NoticeVO> list = noticeService.boardList(pager);
		mv.addObject("Pager", pager);
		mv.addObject("list", list);
		mv.setViewName("notice/noticeList");
		
		return mv;
	}
	@GetMapping("noticeSelect")
	public ModelAndView boardSelect(ModelAndView mv, NoticeVO noticeVO) throws Exception{
		noticeVO = noticeService.boardSelect(noticeVO);
		
		mv.addObject("noticeVO", noticeVO);
		mv.setViewName("notice/noticeSelect");
		return mv;
	}
}
