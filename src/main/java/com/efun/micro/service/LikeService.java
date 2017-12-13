package com.efun.micro.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.SQLReady;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.efun.cache.ExpireTime;
import com.efun.cache.annotation.MixCacheable;
import com.efun.common.utils.R;
import com.efun.common.utils.Rcode;
import com.efun.micro.entity.Like;
import com.efun.micro.mapper.LikeMapper;

@Service
public class LikeService {
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
//    @Autowired
//    LikeMapper likeMapper;
    
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    
//    @Autowired
//    SQLManager sqlManager;
    /**
     * 增加点赞的Service
     * @param like
     * @return
     */
    public Like addLike(Like like) {        
//    	likeMapper.insert(like);
        logger.info("Like:{}"+like.toString());        
        
        String cacheKey = getlikeModuleCacheKey(like.getModule(), like.getParentId(), like.getUid());
    	BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps(cacheKey);    	
    	boundValueOps.set("true");
    	boundValueOps.expire(150, TimeUnit.DAYS);
    	
        return like;
    }
    
    private String getlikeModuleCacheKey(String module, String id, String uid) {
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
    /**
     * 统计点赞数
     * @param uid
     * @param parentId
     * @param module
     * @return
     */
    @MixCacheable(value = "countLike",key = "#uid + #parentId + #module", expire = ExpireTime.FIVE_MIN)
    public int countLike(String uid, String parentId, String module){    	
    	
//		List<Like> list = sqlManager.execute(new SQLReady("select * from t_pf_like t "
//				+ "where t.parentId = ? and t.deleted = 0 and t.module = ? and t.uid = ?",parentId,module,uid),Like.class);
    	
//    	return list.size();
    	return 1;
    }
    /**
     * 删除点赞数
     * @param like
     * @return
     */
    public Object deleteLike(Like like){
    	
//    	//更新数据表
//    	int executeUpdate = likeMapper.executeUpdate("update t_pf_like set deleted='1' where module=? and type=? and parentId=? and uid=?", 
//    			like.getModule(),like.getType(),like.getParentId(),like.getUid());
//    	
//    	if(executeUpdate <= 0){
//    		return R.code(Rcode.DELETE_FAILURE);
//    	}
    	
    	//删除redis
    	String cacheKey = getlikeModuleCacheKey(like.getModule(), like.getParentId(), like.getUid());
    	BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps(cacheKey);
    	boundValueOps.expireAt(new Date());
    	
    	return R.ok();
    }

}
