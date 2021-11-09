package com.iu.b5.board;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BoardVO {
	private Integer num;
	@NotBlank(message = "다 써")
	private String title;
	private String contents;
	@Size(min = 3, max = 6)
	private String writer;
	private Integer hit;
	private Date regDate;
	
	private List<BoardFileVO> fileList;
	

}
