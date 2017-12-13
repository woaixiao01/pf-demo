package com.efun.micro.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efun.micro.entity.ReadCount;
import com.efun.micro.mapper.ReadCountMapper;

@Service
public class ReadCountService {
	
//	@Autowired
//	ReadCountMapper readCountMapper;
	
	public long getReadCount(String sourceId, String sourceType){
		
		ReadCount readCount = new ReadCount(sourceId, sourceType, null, null, null);
//		long templateCount = readCountMapper.templateCount(readCount);
//		return templateCount;
		return 0L;
		
	}

	public long addReadCount(String sourceId, String sourceType) {
		
		ReadCount readCount = new ReadCount(sourceId, sourceType, null, null, new Date());
		long count = getReadCount(sourceId, sourceType)+1;
//		readCountMapper.insert(readCount);
		return count;
		
	}
	
	

}
