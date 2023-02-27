package neu.edu.data;

public class UserSession {
	private String username;
	private String email;
	
	private String role;
	private String current_page;
	
	public UserSession(){
		
	}
	
//	
//
//	public UserSession(String username, String email) {
//		super();
//		this.username = username;
//		this.email = email;
//	}



	public UserSession(String username, String email, String role, String current_page) {
		super();
		this.username = username;
		this.email = email;
		this.role = role;
		this.current_page = current_page;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(String current_page) {
		this.current_page = current_page;
	}
	
}
