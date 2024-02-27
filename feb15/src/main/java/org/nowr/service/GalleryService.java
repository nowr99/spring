package org.nowr.service;

import java.util.List;

import org.nowr.dto.GalleryDTO;

public interface GalleryService {
	
	// 인터페이스에서는 추상 메소드
	public int galleryInsert(GalleryDTO dto);
	
	public List<GalleryDTO> galleryList();
	
	public GalleryDTO galleryDetail(int no);
	
	public int galleryDel(int no);
}
