package com.efun.micro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efun.micro.entity.Like;
import com.efun.micro.mapper.LikeMapper;

@Service
public class LikeService {
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    LikeMapper likeMapper;
    
    public void addLike(Like like) {        
    	likeMapper.insert(like);
        logger.info("Like:{}"+like.toString());
    }

}
