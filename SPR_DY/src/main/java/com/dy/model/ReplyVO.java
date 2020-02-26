package com.dy.model;

public class ReplyVO {
	private int rno; 
    private int no; 
    private String rtext; 
    private String replyer; 
    private String write_date;
    private String updatedate;
    
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRtext() {
		return rtext;
	}
	public void setRtext(String rtext) {
		this.rtext = rtext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", no=" + no + ", rtext=" + rtext + ", replyer=" + replyer + ", write_date="
				+ write_date + ", updatedate=" + updatedate + "]";
	}
}
