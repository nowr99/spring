package org.nowr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.nowr.dto.GalleryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GalleryDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public int galleryInsert(GalleryDTO dto) {
		return sqlSession.insert("gallery.galleryInsert", dto);
	}


	public List<GalleryDTO> galleryList() {
		return sqlSession.selectList("gallery.galleryList");
	}
}
