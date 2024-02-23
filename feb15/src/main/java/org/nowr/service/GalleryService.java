package org.nowr.service;

import java.util.List;

import org.nowr.dao.GalleryDAO;
import org.nowr.dto.GalleryDTO;
import org.nowr.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDAO galleryDAO;
	
	@Autowired
	private Util util;
	
	public int galleryInsert(GalleryDTO dto) {
		// 세션ㄴ추가
		if(util.getSession().getAttribute("mid") != null) {
			dto.setMid((String) util.getSession().getAttribute("mid"));
			return galleryDAO.galleryInsert(dto);
		} else {
			return 0;
		}
	}

	public List<GalleryDTO> galleryList() {
		GalleryDTO dto = new GalleryDTO();
		dto.getGtitle();
		dto.getGcontent();
		dto.getGdate();
		dto.getGfile();
		dto.getGlike();
		dto.getGno();
		dto.getMid();
		dto.getMname();
		return galleryDAO.galleryList();
	}
}
