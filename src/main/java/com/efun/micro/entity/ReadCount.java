package com.efun.micro.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Table;

@Table(name = "t_pf_readCount")
public class ReadCount implements Serializable{
	/**
	* @Fields 
	*/ 
	private static final long serialVersionUID = 1L;
	private Long id;
	private String sourceId;
	private String sourceType;
	private String uid;
	private String ext;
	private Date createdTime;
	private int totalCount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public ReadCount(String sourceId, String sourceType, String uid, String ext, Date createdTime) {
		super();
		this.sourceId = sourceId;
		this.sourceType = sourceType;
		this.uid = uid;
		this.ext = ext;
		this.createdTime = createdTime;
	}
	
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public ReadCount() {
	}



	public enum sourceType {
		newsInfo,gameItemInfo,cartoon
	}
}
