package org.nowr.service;

import java.util.List;

import org.nowr.dao.GalleryDAO;
import org.nowr.dto.GalleryDTO;
import org.nowr.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ("galleryService")
public class GalleryServiceImpl  extends AbstractService implements GalleryService {
	
	@Autowired
	private GalleryDAO galleryDAO;
	
	@Override
	public int galleryInsert(GalleryDTO dto) {
		// 세션추가
		if(util.getSession().getAttribute("mid") != null) {
			dto.setMid((String) util.getSession().getAttribute("mid"));
			return galleryDAO.galleryInsert(dto);
		} else {
			return 0;
		}
	}

	public List<GalleryDTO> galleryList() {
		return galleryDAO.galleryList();
	}

	public GalleryDTO galleryDetail(int no) {
		return galleryDAO.galleryDetail(no);
	}

	public int galleryDel(int no) {
		return galleryDAO.gelleryDel(no);
	}
}
