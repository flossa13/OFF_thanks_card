package models;

import controllers.routes;
import play.mvc.*;
import play.mvc.Http.Context;

public class Secure extends Controller {

	 
	    public String getUsername(Context ctx) {
	        return ctx.session().get("employee_id");
	    }

	
	    public Result onUnauthorized(Context ctx) {
	        return redirect(routes.AuthController.login1());
	    }
	}


