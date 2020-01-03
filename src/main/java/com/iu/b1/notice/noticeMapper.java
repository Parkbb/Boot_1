package com.iu.b1.notice;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface noticeMapper {
	
	public int noticeInsert(NoticeVO noticeVO) throws Exception;
}
