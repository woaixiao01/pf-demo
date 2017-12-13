package com.efun.micro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efun.common.utils.R;
import com.efun.common.utils.Rcode;
import com.efun.micro.entity.Like;
import com.efun.micro.param.LikeParam;
import com.efun.micro.repository.LikeRepository;
import com.efun.micro.service.LikeService;

/**
 * 点赞模块 
 * @author 钟镇豪
 */
@RestController
public class LikeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	LikeService likeService;
	
	@Autowired
	LikeRepository likeRepository;

	/**
	 * 点赞模块
	 * 
	 * @param likeParam
	 * @return
	 */
	@RequestMapping({ "addLike" })
	public Object addLike(@Validated LikeParam likeParam) {

		// 加入校验逻辑

		Like like = new Like(likeParam.getModule(), likeParam.getType(), likeParam.getParentId(), likeParam.getUid());

		if (likeService.isCanlike(like)) {
			return R.code(Rcode.EXIST);
		}

		try {
			likeService.addLike(like);
		} catch (Exception e) {
			return R.error();
		}
		return R.ok();
	}

	/**
	 * 统计点赞总数
	 * 
	 * @param like
	 *            上送like.getUid(), like.getDataType(),
	 *            Like.modules.topic.toString()
	 * @return
	 */
	@RequestMapping(value = "likeDetail")
	public Object countLike(@Validated LikeParam likeParam) {
		int num = likeService.countLike(likeParam.getUid(), likeParam.getParentId(), Like.modules.topic.toString());
		return R.ok(num);
	}

	/**
	 * 删除点赞
	 * 
	 * @param likeParam
	 * @return
	 */
	@RequestMapping(value = "deleteLike")
	public Object deleteLike(@Validated LikeParam likeParam) {

		// 加入校验逻辑

		Like like = new Like(likeParam.getModule(), likeParam.getType(), likeParam.getParentId(), likeParam.getUid());
		return likeService.deleteLike(like);

	}
	
	@RequestMapping(value = "testLike")
	public void testLike(String name) {
		
		List<Like> findAll = likeRepository.findAll();
		System.out.println(findAll.toString());
		
		
		
	}

}
