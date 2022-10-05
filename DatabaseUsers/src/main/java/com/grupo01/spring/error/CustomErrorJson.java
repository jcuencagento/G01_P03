package com.grupo01.spring.error;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;


@Data
public class CustomErrorJson {

	private String timestamp;
	private int status;
	private String error;
	private String trace;
	private List<String> message;
	private String path;

	// Extras
	private String jdk;

	public CustomErrorJson() {
		super();
		this.timestamp = "";
		this.status = 0;
		this.error = "";
		this.trace = "";
		this.message = new ArrayList<>();
		this.path = "";
		this.jdk = "ND";
	}

	public CustomErrorJson(Date timestamp, int status, String error, String trace, List<String> message, String path,
			String jdk) {
		super();
		this.timestamp = this.changeTimeStamp(timestamp);
		this.status = status;
		this.error = error;
		this.trace = trace;
		this.message = message;
		this.path = path;
		this.jdk = jdk;
	}

	

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = this.changeTimeStamp(timestamp);
	}	
	

	@Override
	public String toString() {
		return "CustomErrorJson [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", trace="
				+ trace + ", message=" + message + ", path=" + path + ", jdk=" + jdk + "]";
	}

	private String changeTimeStamp(Date d) {

		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		return dateFormat.format(d);
	}

}
