package neu.edu.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import neu.edu.data.User;
import neu.edu.data.convertor.DataConvertors;

public class UserDao {

	private MongoCollection<Document> mongoCollectionUsers;

	public UserDao(MongoClient mongo) {
		this.mongoCollectionUsers = mongo.getDatabase("testdb").getCollection("users");
	}
	
	/*
	 * public User create(User user) { Document userDoc =
	 * DataConvertors.toDocument(user);
	 * this.mongoCollectionUsers.insertOne(userDoc); ObjectId id = (ObjectId)
	 * userDoc.get("_id"); user.setId(id.toString()); return user; }
	 * 
	 * public void update(User user) {
	 * this.mongoCollectionUsers.updateOne(Filters.eq("_id", new
	 * ObjectId(user.getId())), new Document("$set",
	 * DataConvertors.toDocument(user))); }
	 */
 
    public void delete(String id) {
        this.mongoCollectionUsers.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }
 
    public boolean exists(String id) {
        FindIterable<Document>  doc = this.mongoCollectionUsers.find(Filters.eq("_id", id)).limit(1);
        return doc != null;
    }
 
	/*
	 * public List<User> getList() { List<User> users = new ArrayList<User>();
	 * MongoCursor<Document> cursor = mongoCollectionUsers.find().iterator(); try {
	 * while (cursor.hasNext()) { Document doc = cursor.next(); User user =
	 * DataConvertors.toUser(doc); users.add(user); } } finally { cursor.close(); }
	 * return users; }
	 */
 
	/*
	 * public User getUser(String id) { Document doc =
	 * this.mongoCollectionUsers.find(Filters.eq("_id", new ObjectId(id))).first();
	 * return DataConvertors.toUser(doc); }
	 */

}