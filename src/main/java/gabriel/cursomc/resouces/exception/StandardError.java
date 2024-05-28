package gabriel.cursomc.resouces.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Long timeStemp;
	
	
	public StandardError(Integer status, String msg, Long timeStemp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStemp = timeStemp;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Long getTimeStemp() {
		return timeStemp;
	}


	public void setTimeStemp(Long timeStemp) {
		this.timeStemp = timeStemp;
	}
	
	
	
	
}
