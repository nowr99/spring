package org.nowr.service;

import java.util.List;

import org.nowr.dao.AdminDAO;
import org.nowr.dto.BoardDTO;
import org.nowr.dto.NoticeDTO;
import org.nowr.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl extends AbstractService implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public List<BoardDTO> boardList(SearchDTO searchDTO) {
		return adminDAO.boardList(searchDTO);
	}

	@Override
	public int totalRecordCount(SearchDTO searchDTO) {
		return adminDAO.totalRecordCount(searchDTO);
	}

	@Override
	public int postDel(int no) {
		return adminDAO.postDel(no);
	}

	@Override
	public List<NoticeDTO> noticeList() {
		return adminDAO.noticeList();
	}
}