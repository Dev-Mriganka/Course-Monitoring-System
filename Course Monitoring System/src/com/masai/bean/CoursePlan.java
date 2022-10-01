package com.masai.bean;

public class CoursePlan {
	
	private int planId;
	private String batchId;
	private int daynumber;
	private String topic;
	private String date;
	private boolean status;
	
	
	
	public CoursePlan(int planId, String batchId, int daynumber, String topic, String date, boolean status) {
		super();
		this.planId = planId;
		this.batchId = batchId;
		this.daynumber = daynumber;
		this.topic = topic;
		this.date = date;
		this.status = status;
	}
	

	public CoursePlan(int planId, String batchId, int daynumber, String topic, boolean status) {
		super();
		this.planId = planId;
		this.batchId = batchId;
		this.daynumber = daynumber;
		this.topic = topic;
		this.status = status;
	}
	
	
	
	
	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}


	public String getBatchId() {
		return batchId;
	}


	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}


	public int getDaynumber() {
		return daynumber;
	}

	public void setDaynumber(int daynumber) {
		this.daynumber = daynumber;
	}


	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public CoursePlan(int daynumber, String topic) {
		super();
		this.daynumber = daynumber;
		this.topic = topic;
	}


	
	public CoursePlan(String batchId) {
		super();
		this.batchId = batchId;
	}


	@Override
	public String toString() {
		return "CoursePlan [planId=" + planId + ", batchId=" + batchId + ", daynumber=" + daynumber + ", topic=" + topic
				+ ", date=" + date + ", status=" + status + "]";
	}

	
}
