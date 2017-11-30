package com.efun.micro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efun.common.utils.R;
import com.efun.micro.entity.Like;
import com.efun.micro.param.LikeParam;
import com.efun.micro.service.LikeService;

@RestController
public class LikeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    LikeService likeService;
	
	@RequestMapping({"addLike"})
	public Object addLike(@Validated LikeParam likeParam){
		
        Like like = new Like(likeParam.getDataType(), likeParam.getLikeType(),
                likeParam.getDataId(), likeParam.getUid());
        
		likeService.addLike(like);
		
		return R.ok();
	}

}
