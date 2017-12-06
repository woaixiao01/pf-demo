package com.efun.micro.param;

import org.hibernate.validator.constraints.NotEmpty;

import com.efun.micro.base.param.SignParam;

/**
 * @author Acel
 * @since 2017/10/31
 */
public class LikeParam extends SignParam {
    @NotEmpty
    private String parentId;// 数据id
    @NotEmpty
    private String module;// 数据类型 cartoon, video, news, topic
    @NotEmpty
    private String type; // 点赞类型：like,dislike,cancelLike


    public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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


}
