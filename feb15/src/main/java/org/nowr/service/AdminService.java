package org.nowr.service;

import java.util.List;

import org.nowr.dto.BoardDTO;
import org.nowr.dto.NoticeDTO;
import org.nowr.dto.SearchDTO;

public interface AdminService {

	List<BoardDTO> boardList(SearchDTO searchDTO);

	int totalRecordCount(SearchDTO searchDTO);

	int postDel(int no);

	List<NoticeDTO> noticeList( );

}
