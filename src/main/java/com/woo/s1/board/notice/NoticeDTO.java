package com.woo.s1.board.notice;

import java.util.List;

import com.woo.s1.board.BoardDTO;
import com.woo.s1.board.BoardFileDTO;

public class NoticeDTO extends BoardDTO {
	
	private List<BoardFileDTO> boardFileDTOs;

	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}

	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
	
}
