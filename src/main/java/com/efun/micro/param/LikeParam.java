package com.efun.micro.param;

import org.hibernate.validator.constraints.NotEmpty;

import com.efun.micro.base.param.SignParam;

/**
 * @author Acel
 * @since 2017/10/31
 */
public class LikeParam extends SignParam {
    @NotEmpty
    private String dataId;// 数据id
    @NotEmpty
    private String dataType;// 数据类型 cartoon, video, news, topic
    @NotEmpty
    private String likeType; // 点赞类型：like,dislike,cancelLike

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getLikeType() {
        return likeType;
    }

    public void setLikeType(String likeType) {
        this.likeType = likeType;
    }
}
