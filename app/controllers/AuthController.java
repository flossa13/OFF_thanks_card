package controllers;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.inject.Inject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;

import models.*;

import play.data.Form;
import play.data.FormFactory;
import play.db.*;
import play.mvc.*;

import views.html.*;

public class AuthController extends Controller {
		    	
		@Inject
		private FormFactory formFactory;
		
	    public Result index() {
	        return ok(index.render("Your new application is ready."));
	    }
	    
	    public Result top() {
	        return ok(top.render(formFactory.form(Login.class)));
	    }
	    
	    //掲示板ログイン画面
		public Result login1() {
			return ok(login1.render(formFactory.form(Login.class)));
			
		//管理者ログイン画面	
	    }
		public Result login2() {
			return ok(login2.render(formFactory.form(Login.class)));
	    }
		public Result authenticate() {
	        Form<Login> form = formFactory.form(Login.class).bindFromRequest();

	        if (form.hasErrors()) {
	            return badRequest(login1.render(form));
	        } else {
	        	 session().clear();
	        	 session("eployee_id", form.get().eployee_id);
	        	 return redirect(
	        	 routes.AuthController.login1());
	        }
		
	    }	
		}
