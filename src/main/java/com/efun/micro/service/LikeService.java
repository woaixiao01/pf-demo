package com.efun.micro.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.efun.cache.CacheType;
import com.efun.cache.ExpireTime;
import com.efun.cache.annotation.MixCachePut;
import com.efun.cache.annotation.MixCacheable;
import com.efun.common.redis.RedisUtil;
import com.efun.micro.entity.Like;
import com.efun.micro.mapper.LikeMapper;

@Service
public class LikeService {
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    LikeMapper likeMapper;
    
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    /**
     * 增加点赞的Service
     * @param like
     * @return
     */
    public Like addLike(Like like) {        
    	likeMapper.insert(like);
        logger.info("Like:{}"+like.toString());        
        
        String cacheKey = getlikeModuleCacheKey(like.getModule(), like.getParentId(), like.getUid());
    	BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps(cacheKey);    	
    	boundValueOps.set("true");
    	boundValueOps.expire(150, TimeUnit.DAYS);
    	
        return like;
    }
    
    public String getlikeModuleCacheKey(String module, String id, String uid) {
		return "pf_canLike_" + id + module + uid;
	}
    
    /**
     * 点赞规则控制
     * @param like
     */
    public boolean isCanlike(Like like) {
    	String cacheKey = getlikeModuleCacheKey(like.getModule(), like.getParentId(), like.getUid());
    	
    	BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps(cacheKey);  	
    	
        String result = boundValueOps.get();
        if ("true".equals(result)) {
            return true;
        }
    	return false;
    }
    
    
    public long countUidLike(String uid, String dataType, String modules){    	
    	Like like = new Like();
    	like.setId(uid);
    	
    	return likeMapper.templateCount(like);
    }

}
