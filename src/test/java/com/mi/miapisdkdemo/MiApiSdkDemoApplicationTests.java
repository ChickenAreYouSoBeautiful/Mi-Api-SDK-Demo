package com.mi.miapisdkdemo;

import cn.hutool.json.JSONUtil;
import com.mi.miapi_common.common.BaseResponse;
import com.mi.miapi_common.model.request.AiMessageRequest;
import com.mi.miapisdkdemo.controller.InvokeSdkController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MiApiSdkDemoApplicationTests {


    @Resource
    private InvokeSdkController invokeSdkController;

    @Test
    void contextLoads() {
        AiMessageRequest aiMessageRequest = new AiMessageRequest();
        aiMessageRequest.setPrompt("请用一句话来描述什么是诗词。");
        BaseResponse<?> baseResponse = invokeSdkController.aiMessage(aiMessageRequest);
        System.out.println(JSONUtil.toJsonStr(baseResponse));
    }


}
