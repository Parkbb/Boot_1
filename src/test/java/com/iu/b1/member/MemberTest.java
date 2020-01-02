package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback
class MemberTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void memberJoinTest() throws Exception{
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu10");
		memberVO.setPw("iu10");
		memberVO.setEmail("iu10");
		memberVO.setName("iu10");
		int result=memberMapper.memberJoin(memberVO);
		
		assertEquals(1, result);
	}
	
}
