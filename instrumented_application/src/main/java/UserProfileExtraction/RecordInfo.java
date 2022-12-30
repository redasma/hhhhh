package UserProfileExtraction;

import com.example.tp3.Product;
import com.example.tp3.User;

public class RecordInfo {
	
	private String timestamp;
	private String level;
	private String thread;
	private String logger;
	private String message;
	private String userInfo;
	private String operation;
	private String userID;
	private String parameters;
	
	public RecordInfo() {
		super();

	}

	public RecordInfo(String timestamp, String level, String thread, String logger, String message, String userInfo,
			String operation, String userID, String parameters) {
		super();
		this.timestamp = timestamp;
		this.level = level;
		this.thread = thread;
		this.logger = logger;
		this.message = message;
		this.userInfo = userInfo;
		operation = operation;
		this.userID = userID;
		this.parameters = parameters;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getLogger() {
		return logger;
	}

	public void setLogger(String logger) {
		this.logger = logger;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		operation = operation;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	
	
     

}
