package com.icia.TravelMaker.dto;

import lombok.Data;

@Data
public class CommentsListDTO {

	private int BNUMBER;
	private String BTITLE;
	private String MID;
	private String CMDATE;
	private String CMCONTENT;	
	private int COMMENTSLIKE;
	private int COMMENTSCOMPLAINT;
}
