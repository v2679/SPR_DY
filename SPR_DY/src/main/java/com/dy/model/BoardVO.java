package com.dy.model;

public class BoardVO {
	//글번호
	private int no;  
    //글 제목
	private String subject; 
    //글 내용
	private String content;  
    //글 작성자
	private String writer;  
    //글 작성일자
	private String write_date;  
    //글 조회수
	private int cnt;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", subject=" + subject + ", content=" + content + ", writer=" + writer
				+ ", write_date=" + write_date + ", cnt=" + cnt + "]";
	}
}
