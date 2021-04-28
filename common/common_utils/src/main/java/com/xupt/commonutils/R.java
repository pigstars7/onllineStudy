package com.xupt.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class R {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    private R(){}

    public static com.xupt.commonutils.R ok(){
        com.xupt.commonutils.R r = new com.xupt.commonutils.R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static com.xupt.commonutils.R error(){
        com.xupt.commonutils.R r = new com.xupt.commonutils.R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public com.xupt.commonutils.R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public com.xupt.commonutils.R message(String message){
        this.setMessage(message);
        return this;
    }

    public com.xupt.commonutils.R code(Integer code){
        this.setCode(code);
        return this;
    }

    public com.xupt.commonutils.R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public com.xupt.commonutils.R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
