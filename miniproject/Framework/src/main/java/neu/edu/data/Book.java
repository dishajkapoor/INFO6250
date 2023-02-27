package neu.edu.data;

public class Book {
	private String id;
	private int isbn;
	private String name;
	private int count;
	private int ratings;
	private String desc;
	private String author;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
//	public Book(String id, int isbn, String name, int count, float ratings, String desc) {
//		super();
//		this.id = id;
//		this.isbn = isbn;
//		this.name = name;
//		this.count = count;
//		this.ratings = ratings;
//		this.desc = desc;
//	}
	
	public String getId() {
		return id;
	}
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setId(String id) {
		this.id = id;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
	public int getRatings() {
		return ratings;
	}
	

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", name=" + name + ", count=" + count + ", ratings=" + ratings
				+ ", desc=" + desc + "]";
	}
	
	
	
}
