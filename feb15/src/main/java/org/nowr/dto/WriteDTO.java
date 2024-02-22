package org.nowr.dto;

import lombok.Data;

// 글쓰기할때 사용 할 DTO
@Data
public class WriteDTO {
	private int board_no;
	private String title, content, mid, ip;
}
