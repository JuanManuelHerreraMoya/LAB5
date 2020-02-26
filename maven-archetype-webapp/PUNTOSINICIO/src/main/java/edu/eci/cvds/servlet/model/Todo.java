package edu.eci.cvds.servlet.model;


public class Todo {
	private int id;
	private int userId;
	private String title;
	private boolean completed;
	
	public Todo() {
	}
	
	public int getId() {
		return id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getTitle() {
		return title;
	}

	public boolean getCompleted() {
		return completed;
	}
	
	public void setId(int value) {
		id = value;
	}
	
	public void setUserId(int value) {
		userId = value;
	}
	

	
}

