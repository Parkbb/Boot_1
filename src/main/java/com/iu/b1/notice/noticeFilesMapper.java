package com.iu.b1.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface NoticeFilesMapper {

	
	public int noticeFilesInsert(NoticeFilesVO noticeFilesVO) throws Exception;
	
	public int noticeFilesInsert2(List<NoticeFilesVO> list) throws Exception;
}
