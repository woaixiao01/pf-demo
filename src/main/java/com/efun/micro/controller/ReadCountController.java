package com.efun.micro.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efun.common.utils.R;
import com.efun.micro.entity.ReadCount;
import com.efun.micro.service.ReadCountService;
/**
 * 阅读量模块
 * @author 钟镇豪
 */
@RestController
public class ReadCountController {
	
	@Autowired
	ReadCountService readCountService;
	
	/**
	 * 增加阅读量
	 */
	@RequestMapping({"readCount/addReadCount", "readCount_addReadCount"})
	public Object addReadCount(HttpServletRequest request) {
		String sourceId = request.getParameter("sourceId");// 数据id
		String sourceType = request.getParameter("sourceType");// 数据类型
		
		//校验IP
		
		
		//校验参数
		
		
		long count = readCountService.addReadCount(sourceId,sourceType);
		return R.ok(count);
		
	}
	
	
	/**
	 * 获取阅读量
	 */
	@RequestMapping({"readCount/getReadCount", "readCount_getReadCount"})
	public Object getReadCount(HttpServletRequest request) {
		String sourceId = request.getParameter("sourceId");// 数据id
		String sourceType = request.getParameter("sourceType");// 数据类型

		//校验参数
		
		long count = readCountService.getReadCount(sourceId, sourceType);
		return R.ok(count);
	}

}
