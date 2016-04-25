package cn.tyrone.security.core.bean;

public class ResponseBean {
	
	/**
	 * 响应状态码
	 */
	private String state;
	
	/**
	 * 响应消息
	 */
	private String message;
	
	public ResponseBean(){}
	
	public ResponseBean(String state,String message){
		this.state = state;
		this.message = message;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
