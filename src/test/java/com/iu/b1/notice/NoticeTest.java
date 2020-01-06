package com.iu.b1.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
//@Transactional
class NoticeTest {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	public void noticeTest() throws Exception{
		
		
		for (int i = 0; i < 30; i++) {
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setTitle("title"+i);
			noticeVO.setWriter("writer"+i);
			noticeVO.setContents("contents"+i);
			noticeMapper.noticeInsert(noticeVO);
		}
		
		
	}
	
}
