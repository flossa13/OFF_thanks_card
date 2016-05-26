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
	    }	