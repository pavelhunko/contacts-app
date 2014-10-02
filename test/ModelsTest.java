import static org.junit.Assert.*;
import model.User;

import org.junit.Assert;
import org.junit.Test;

import play.api.test.FakeApplication;
import play.test.WithApplication;


public class ModelsTest extends WithApplication {
	@Test
	public void setUp(){
		//TODO
	}
	@Test
	public void createAndRetrieveUser(){
		new User((long) 13 , "lil@tr.tr", "secret").save();
		User lil = User.find.where().eq("email", "lil@tr.tr").findUnique();
		assertNotNull(lil);
		assertEquals("secret", lil.password);
	}
	@Test
    public void tryAuthenticateUser() {
        new User((long)12, "bob@gmail.com", "Bob").save();
        
        assertNotNull(User.authenticate("bob@gmail.com", "Bob1"));
        assertNull(User.authenticate("bob@gmail.com", "badpassword"));
        assertNull(User.authenticate("tom@gmail.com", "secret"));
    }
}
