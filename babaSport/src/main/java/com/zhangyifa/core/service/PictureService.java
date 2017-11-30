package com.zhangyifa.core.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

	Map uploadPicture(MultipartFile uploadFile);
	
}
