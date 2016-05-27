package controllers;

import javax.inject.Inject;

import models.Login;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.*;

public class AuthController extends Controller {
	

		@Inject
		private FormFactory formFactory;
		
	    public Result index() {
	        return ok(index.render("Your new application is ready."));
	    }

		public Result login1() {
			return ok(login1.render(formFactory.form(Login.class)));
	    }
		public Result login2() {
			return ok(login2.render(formFactory.form(Login.class)));
	    }
		public Result authenticate() {
		        Form<Login> form = formFactory.form(Login.class).bindFromRequest();

		        if (form.hasErrors()) {
		            return badRequest(login1.render(form),login2.render(form));
		        } else {
		            Login login = form.get();
		            return ok("ようこそ " + login.username + " さん!!");
		        }
	    }	
		}