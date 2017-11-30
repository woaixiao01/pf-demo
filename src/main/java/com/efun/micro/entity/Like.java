package com.efun.micro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;

/**
 * Like
 * 点赞实体类
 *
 * @author Galen
 * @since 2016/8/4
 */
@Table(name = "t_pf_like")
public class Like implements Serializable {

    private static final long serialVersionUID = 1L;

    //唯一标识
    private String id;

    //创建时间
    private Date createdTime;

    //最后修改时间
    private Date lastModifiedTime;

    //用户id
    private String uid;

    //模块 cartoon, video, news
    private String module;

    //点赞类型 like,dislike,cancelLike
    private String type;

    //父记录id
    private String parentId;

    //删除标识
    private int deleted;
    
    //删除标识
    private String platform;

    public enum modules{
    	cartoon, video, news, topic
    }
    
    public enum likeType{
    	like,dislike,cancelLike
    }
    
    public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public Like() {

    }
	

    public Like(String module, String type, String parentId, String uid) {
        this.module = module;
        this.type = type;
        this.parentId = parentId;
        this.uid = uid;
        this.createdTime = new Date();
        this.lastModifiedTime = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setIsDelete(int delete) {
        this.deleted = deleted;
    }

	@Override
	public String toString() {
		return "Like [id=" + id + ", createdTime=" + createdTime + ", lastModifiedTime=" + lastModifiedTime + ", uid="
				+ uid + ", module=" + module + ", type=" + type + ", parentId=" + parentId + ", deleted=" + deleted
				+ ", platform=" + platform + "]";
	}
}
