package com.icia.TravelMaker.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class BoardViewDTO {
	
	private int BNUMBER;
	private String BTITLE;
	private String BCONTENT;
	private String MID;
	private String BDATE;
	private int BOARDLIKE;
	private String BOARDHIT;
	
	
	
	
	private String BIMG;
	private MultipartFile BIMGFILE;



	private String BCNAME;
	
}


