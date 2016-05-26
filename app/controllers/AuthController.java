package controllers;

import javax.inject.Inject;

import models.Login;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.*;

public class AuthController extends Controller {
	
		public Result login1() {
			return ok(login1.render());
	    }
		public Result login2() {
			return ok(login2.render());
	    }
		public static Result authenticate() {
	        Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();
	        if (loginForm.hasErrors()) {
	            return badRequest(login.render(loginForm));
	        } else {
	        	session().clear();
	            session("username", loginForm.get().getUsername());
	            String returnUrl = ctx().session().get("returnUrl");
	            if(returnUrl == null || returnUrl.equals("") || returnUrl.equals(routes.AuthController.login1().absoluteURL(request()))) {
	                returnUrl = "/inputchat";
	            }
	            return redirect(returnUrl);
	        }
	    }
	    }	