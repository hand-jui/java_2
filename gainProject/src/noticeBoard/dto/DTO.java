package noticeBoard.dto;

public class DTO {

	private int no;
	private String title;
	private String content;
	private String nickname;
	private String password;

	public DTO() {
	}

	public DTO(int no, String title, String nickname) {
		this.no = no;
		this.title = title;
		this.nickname = nickname;
	}
	

	public DTO(String title, String content, String nickname, String password) {
		this.title = title;
		this.content = content;
		this.nickname = nickname;
		this.password = password;
	}

	public DTO(int no, String title, String content, String nickname, String password) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.nickname = nickname;
		this.password = password;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
