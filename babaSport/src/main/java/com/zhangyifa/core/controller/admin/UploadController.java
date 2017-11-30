package com.zhangyifa.core.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zhangyifa.common.utils.JsonUtils;
import com.zhangyifa.core.service.PictureService;

/**
 * 上传图片
 * @author zyf
 *
 */
@Controller
public class UploadController {
	
	@Autowired
	private PictureService pictureService;
	
	//上传图片
	@RequestMapping(value = "/upload/uploadPic.do")
	public void uploadPic(@RequestParam MultipartFile pic, HttpServletResponse response){
		Map map = pictureService.uploadPicture(pic);
		try {
	        //设置页面不缓存
	        response.setContentType("application/json");
	        response.setHeader("Pragma", "No-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out= null;
	        out = response.getWriter();
	        out.print(JsonUtils.objectToJson(map));
	        out.flush();
	        out.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
