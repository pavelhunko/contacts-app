package controllers;

import model.Contact;
import model.User;
import play.*;
import play.data.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	
	@Security.Authenticated(Secured.class)
	public static Result index() {
		return ok(index.render(Contact.find.all()));
	}

	public static Result login() {
		return ok(login.render(Form.form(Login.class)));
	}

	public static class Login {
		public String email;
		public String password;
		
		public String validate() {
			if (User.authenticate(email, password) == null) {
				return "Invalid user or password";
			}
			return null;
		}
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			session().clear();
			session("email", loginForm.get().email);
			return redirect(routes.Application.index());
		}
	}

}
