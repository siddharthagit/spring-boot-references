package example.restapi.dto;

public class APIError {
	
	int code;
	String message;
	
	public APIError(int c, String m) {
		this.code = c;
		this.message = m;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
