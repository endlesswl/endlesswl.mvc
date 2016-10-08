package com.palm.lingcai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.palm.lingcai.entity.Result;
import com.palm.lingcai.util.upload.FileuploadUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * 标题：文件上传
 * 项目名称：operation-web
 * 类名称：FileuploadController
 * 类描述：
 * 创建人：xpj
 * 创建时间：2015年8月11日 下午3:00:56
 * 公司：北京零彩宝网络技术有限公司
 * 版权：Copyright (c) 2015
 * 修改备注：
 *
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/fileupload")
public class FileuploadController {
    private static Logger logger = LoggerFactory.getLogger(FileuploadController.class);
    private String temp = "/uploadfile";
    private long fileMaxSize = 1024000;
    private String errorMsg = "{\"resultCode\":\"50001\",\"retultMsg\":\"不是multipart/form-data类型\"}";
    private String otherMsg = "{\"resultCode\":\"50002\",\"retultMsg\":\"请选择文件\"}";

    @RequestMapping(value = "/uploadRu", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFileRU(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Result result;
        logger.debug("图片上传.........................");
        String path = FileuploadUtil.uploadFile(request);
        logger.debug("path" + path);
        JSONObject json = JSONObject.parseObject(path);
        if (!StringUtils.equals(json.getString("resultCode"), "0")) {
            result = new Result(false, json.getString("retultMsg"), null);
            return JSON.toJSONString(result);
        }
        JSONArray jsonArray = json.getJSONArray("retultMsg");
        JSONObject info = jsonArray.getJSONObject(0);
        logger.debug("info:{}", info.toJSONString());
        String fileName = info.getString("filePath");
        logger.debug("fileName:{}", fileName);
        String url = fileName.substring(fileName.indexOf("uploadfile"), fileName.length());
        ServletContext application = request.getSession().getServletContext();
        logger.debug("url:{}", url);
        result = new Result(true, application.getAttribute("ctx")+"/"+url, null);
        logger.info("response:{}", JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }

}
