package com.mi.miapisdkdemo.controller;

import com.mi.miapi_client_sdk.client.MiApiClient;
import com.mi.miapi_common.common.BaseResponse;

import com.mi.miapi_common.model.request.AiMessageRequest;
import com.mi.miapi_common.model.request.GetNameRequest;
import com.mi.miapi_common.model.request.GetSimilarityRequest;
import com.mi.miapi_common.model.request.IpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author mi11
 * @version 1.0
 * @project MiApi-SDK-Demo
 * @description 测试SDK调用
 * @ClassName InvokeSdkController
 */
@RestController
@RequestMapping("/invoke")
public class InvokeSdkController {


    @Resource
    private MiApiClient miApiClient;

    /**
     *  获取名称
     * @param getNameRequest 名称
     * @return 响应
     */
    @GetMapping("/name")
    public BaseResponse<?> getName(GetNameRequest getNameRequest){

        return miApiClient.getName(getNameRequest);
    }


    /**
     * 根据ip获取ip信息
     * @param request request
     * @return 响应
     */
    @GetMapping("/ip")
    public BaseResponse<?> ipInfo(HttpServletRequest request){
        IpRequest ipRequest = new IpRequest();
        ipRequest.setIp("127.0.0.1");
        if (request != null){
            ipRequest.setIp(request.getRemoteAddr());
        }
        return miApiClient.ipInfo(ipRequest);
    }

    /**
     * 和AI一起讨论诗词歌赋
     * @param aiMessageRequest 参数对象
     * @return 响应
     */
    @PostMapping("/aiMessage")
    public BaseResponse<?> aiMessage(AiMessageRequest aiMessageRequest){
        return miApiClient.aiMessage(aiMessageRequest);
    }

    /**
     *  根据指定匹配字符串在字符串列表中，获取最相似的limit个字符串
     * @param getSimilarityRequest 参数对象
     * @return 响应
     */
    @PostMapping("/getSimilarity")
    public BaseResponse<?> getSimilarity(GetSimilarityRequest getSimilarityRequest){
        return miApiClient.getSimilarity(getSimilarityRequest);
    }
}
