package com.pro.base.result;

import com.pro.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

import java.util.Locale;

/**
 * @author future
 * @Description:
 * @Package com.pro.base project-service
 * @date: Created in 2018/7/410:52
 */
@Controller
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);


    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;


    public <T> String returnResult(Integer resultCode, T data, String resultMessage) {
        ReturnResult result = ReturnResult.instantiation();
        if (resultMessage == null) {
            resultMessage = resourceBundleMessageSource.getMessage(resultCode.toString(), null, Locale.SIMPLIFIED_CHINESE);
        }
        Header header = new Header(resultCode, resultMessage);
        result.setHeader(header);
        result.setBody(data);
        return JsonUtils.objtoJson(result);
    }

    public <T> String returnSuccessResult(T data) {
        return returnResult(0, data, null);
    }

    public <T> String returnErrorResult(Integer resultCode) {
        return returnResult(resultCode, null, null);
    }

    public <T> String returnErrorResult(Integer resultCode, String resultMessage) {
        return returnResult(resultCode, null, resultMessage);
    }
}
