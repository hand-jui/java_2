package dto;

import java.lang.reflect.Type;

public class Todo implements Type{

	private int userId;
	private int id;
	private String title;
	private String body;
	private boolean completed;
	
//	public Todo() {
//	}

//	public Todo(int userId, int id, String title, boolean completed) {
//		super();
//		this.userId = userId;
//		this.id = id;
//		this.title = title;
//		this.completed = completed;
//	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	

}
