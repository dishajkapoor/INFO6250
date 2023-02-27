package neu.edu.data.convertor;

import org.bson.Document;
import org.bson.types.ObjectId;

import neu.edu.data.Address;
import neu.edu.data.Book;
import neu.edu.data.MyBook;
import neu.edu.data.Name;
import neu.edu.data.User;

public class DataConvertors {


	/*
	 * public static Document toDocument(User user) {
	 * 
	 * Document doc = new Document("name", new Document("first",
	 * user.getName().getFirstName()) .append("last", user.getName().getLastName()))
	 * .append("address", new Document("street", user.getAddress().getLine1())
	 * .append("city", user.getAddress().getCity()) .append("state",
	 * user.getAddress().getState()) .append("zip", user.getAddress().getZip()))
	 * .append("age", user.getAge());
	 * 
	 * if (user.getId() != null) { doc.append("_id", new ObjectId(user.getId())); }
	 * return doc;
	 * 
	 * }
	 */
	
	public static Document toBookDoc(Book book) {

		Document doc = new Document("name", book.getName())
				.append("isbn", book.getIsbn())
				.append("count", book.getCount())
				.append("desc", book.getDesc())
				.append("author", book.getAuthor())
				
				.append("ratings", book.getRatings());
		if (book.getId() != null) {
			doc.append("_id", new ObjectId(book.getId()));
		}
		return doc;

	}
	
	public static Document toMyBookDoc(MyBook mybook) {

		Document doc = new Document("purchase_date", mybook.getPurchase_date())
				.append("return_date", mybook.getReturn_date())
				.append("username", mybook.getUsername())
				.append("isbn", mybook.getIsbn())
		.append("due_date", mybook.getDue_date());

		if (mybook.getId() != null) {
			doc.append("_id", new ObjectId(mybook.getId()));
		}
		return doc;

	}

	/*
	 * public static User toUser(Document userDoc) { System.out.println(userDoc);
	 * 
	 * User user = new User(); Document nameDoc = userDoc.get("name", new
	 * Document("name", new Name())); Name name = new Name();
	 * name.setFirstName((String)nameDoc.get("firstName"));
	 * name.setLastName((String)nameDoc.get("lastName")); user.setName(name);
	 * 
	 * user.setAge((Integer) userDoc.get("age",0)); Document addressDoc =
	 * userDoc.get("address", new Document("address", new Address())); Address
	 * address = new Address(); address.setLine1((String)addressDoc.get("street"));
	 * address.setCity((String)addressDoc.get("city"));
	 * address.setState((String)addressDoc.get("state"));
	 * address.setZip((String)addressDoc.get("zip")); user.setAddress(address);
	 * user.setId(((ObjectId) userDoc.get("_id")).toString());
	 * System.out.println(user); System.out.println(""); System.out.println("");
	 * 
	 * 
	 * return user; }
	 */



public static Book toBook(Document bookDoc) {
	System.out.println(bookDoc);

	Book book = new Book();
	
	book.setIsbn((Integer) bookDoc.get("isbn",0));
	book.setCount((Integer) bookDoc.get("count",0));
	book.setDesc((String) bookDoc.get("desc",""));
	book.setName((String) bookDoc.get("name",""));
	System.out.println("i am here");
	System.out.println("ratinfssss" + bookDoc.get("ratings") + bookDoc.get("ratings").getClass());
	book.setRatings((Integer) bookDoc.get("ratings",0));
	System.out.println("i am herewe");
	book.setAuthor((String) bookDoc.get("author",""));
	
	book.setId(((ObjectId) bookDoc.get("_id")).toString());
	/*
	 * System.out.println(
	 * "skjdnfdkjsbfjsbfjbsbsfjbfsbhsbfshbfhbfbfsbfhsdbfhbdsfhbdsjfbjksdbfkjsdbfkjdf"
	 * ); System.out.println(book + "send"); System.out.println("sent");
	 * System.out.println("");
	 */


	return book;
}

public static MyBook toMyBook(Document bookDoc) {
	System.out.println(bookDoc);

	MyBook book = new MyBook();
	book.setIsbn((Integer) bookDoc.get("isbn",0));
	book.setUsername((String) bookDoc.get("username",""));
	book.setPurchase_date((String) bookDoc.get("purchase_date",""));
	book.setReturn_date((String) bookDoc.get("return_date", ""));
	book.setDue_date((String) bookDoc.get("due_date", ""));
	
	book.setId(((ObjectId) bookDoc.get("_id")).toString());
		return book;
}

}