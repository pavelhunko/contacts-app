package model;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class User extends Model {
	@Id
	public Long id;
	public String email;
	public String password;
	

	public User(Long _id, String _email, String _pass) {
		this.id = _id;
		this.email = _email;
		this.password = _pass;
		
	}
	
	public static Model.Finder<Long, User> findByID = new Finder<Long, User>(Long.class, User.class); //??
	public static Model.Finder<String, User> find = new Finder<String, User>(String.class, User.class);
	
	public static User authenticate(String email, String password){
		return find.where().eq("email", email).eq("password", password).findUnique();
	}
}
