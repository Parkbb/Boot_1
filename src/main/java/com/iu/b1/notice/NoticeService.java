package com.iu.b1.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.util.FilePathGe;
import com.iu.b1.util.FileSaver;

@Transactional
@Service
public class NoticeService {

	@Resource(name = "noticeMapper")
	private NoticeMapper noticeMapper;
	@Resource(name="noticeFilesMapper")
	private NoticeFilesMapper noticeFilesMapper;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FilePathGe filePathGe;
	@Autowired
	private FileSaver fileSaver;
	
	
	
	public int noticeWrite(NoticeVO noticeVO, MultipartFile[] files) throws Exception{
		//notice 작성
		int result = noticeMapper.noticeInsert(noticeVO);
		
		//noticefiles 작성
		File file =filePathGe.getUseClassPathResource("upload");
		List<NoticeFilesVO> list = new ArrayList<NoticeFilesVO>();
		for (int i = 0; i < files.length; i++) {
			if(files[i] != null && !files[i].getOriginalFilename().equals("")) {
				String fileName = fileSaver.save(files[i], file);
				NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
				noticeFilesVO.setNum(noticeVO.getNum());
				noticeFilesVO.setFname(fileName);
				noticeFilesVO.setOname(files[i].getOriginalFilename());
				list.add(noticeFilesVO);
				//result = result +noticeFilesMapper.noticeFilesInsert(noticeFilesVO);
				
			}
		}
		noticeFilesMapper.noticeFilesInsert2(list);
		
		return result;
	}
}
