import java.util.List;

import model.Contact;
import model.User;
import play.GlobalSettings;
import play.libs.Yaml;

import com.avaje.ebean.Ebean;

import controllers.Application;

public class Global extends GlobalSettings {
    public void onStart(Application app) {
        // Check if the database is empty
        //if (User.find.findRowCount() == 0) {
        	User user1 = new User((long)11, "11@em.com", "secret");
        	user1.save();
        	
        	User user2 = new User((long)12, "12@em.com", "secret");
        	user2.save();
        	
        	User user3 = new User((long)13, "13@em.com", "secret");
        	user3.save();
        	
        	User user4 = new User((long)14, "14@em.com", "secret");
        	user4.save();
        	
        	Contact contact1 = new Contact();
        	contact1.id = (long) 1111;
        	contact1.name = "first";
        	contact1.user = user1;
            contact1.save();
            
            Contact contact2 = new Contact();
        	contact2.id = (long) 2222;
        	contact2.name = "second";
        	contact2.user = user2;
            contact2.save();
            
            Contact contact3 = new Contact();
        	contact3.id = (long) 3333;
        	contact3.name = "fourth";
        	contact3.user = user3;
            contact3.save();
            
            Contact contact4 = new Contact();
        	contact4.id = (long) 4444;
        	contact4.name = "third";
        	contact4.user = user2;
            contact4.save();
       // }
    }
}