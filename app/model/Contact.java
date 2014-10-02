package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Contact extends Model {
	
	@Id
	public Long id;
	public String name;
	@ManyToOne
	public User user;
	
	public static Model.Finder<Long, Contact> find = new Model.Finder<Long, Contact>(Long.class, Contact.class);
	
	public static List<Contact> findContacts(Long user_id){
		return find.fetch("contact").where().eq("user_id", user_id).findList();
	}
	
}
