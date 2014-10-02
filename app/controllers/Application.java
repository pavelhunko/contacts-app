package controllers;

import model.Contact;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render(Contact.find.all()));
    }

}
