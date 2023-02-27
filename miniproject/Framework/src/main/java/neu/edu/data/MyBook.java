package neu.edu.data;

public class MyBook {
	private String id;
	private String username;
	private int isbn;
	private String purchase_date;
	private String return_date;
	private String due_date;
	private float ratings;
	
	public MyBook() {
		
	}
//	public MyBook(String username, int isbn, String purchase_date, String return_date) {
//		super();
//		this.username = username;
//		this.isbn = isbn;
//		this.purchase_date = purchase_date;
//		this.return_date = return_date;
//	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
//	@Override
//	public String toString() {
//		return "MyBook [username=" + username + ", isbn=" + isbn + ", purchase_date=" + purchase_date + ", return_date="
//				+ return_date + "]";
//	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "MyBook [id=" + id + ", username=" + username + ", isbn=" + isbn + ", purchase_date=" + purchase_date
				+ ", return_date=" + return_date + ", due_date=" + due_date + ", ratings=" + ratings + "]";
	}
	
	
	
	
} 
