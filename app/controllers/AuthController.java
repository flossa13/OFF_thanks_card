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
	Connection connection = DB.getConnection();
	ArrayList<String> namelist = new ArrayList<String>();
		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{

			    response.setContentType("text/html; charset=Shift_JIS");
			    PrintWriter out = response.getWriter();
	
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession(true);

		boolean check = authUser(user, pass);
		 if (check){
		      /* 認証済みにセット */
		      session.setAttribute("login", "OK");

		      /* 本来のアクセス先へ飛ばす */
		      String target = (String)session.getAttribute("target");
		      response.sendRedirect(target);
		    }else{
		      /* 認証に失敗したら、ログイン画面に戻す */
		      session.setAttribute("status", "Not Auth");
		      response.sendRedirect("/login1");
		    }
	 	}
		@Inject
		private FormFactory formFactory;
		
	    public Result index() {
	        return ok(index.render("Your new application is ready."));
	    }
	    
	    //掲示板ログイン画面
		public Result login1() {
			return ok(login1.render(formFactory.form(Login.class)));
			
		//管理者ログイン画面	
	    }
		public Result login2() {
			return ok(login2.render(formFactory.form(Login.class)));
	    }
		
		protected boolean authUser(String user, String pass){
		 
		    if (user == null || user.length() == 0 || pass == null || pass.length() == 0){
		      return false;
		    }

		    return true;
	    }	
		}
