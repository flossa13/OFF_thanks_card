package controllers;

import play.mvc.Controller;
import play.mvc.Result;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import views.html.*;

import play.db.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render("Your new application is ready."));
    }


    public Result help() {
    	return ok(help.render());
    }

    public Result PastCord() {
    	Connection connection = DB.getConnection();
    	ArrayList<String> userlist = new ArrayList<>();
    	ArrayList<String> helplist = new ArrayList<>();
    	ArrayList<String> sentlist = new ArrayList<>();


    	 try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from division_table");
    		ResultSet rs = Ssql.executeQuery();
    		while (rs.next()) {
    			userlist.add(rs.getString("division_id"));
    			helplist.add(rs.getString("division_namen"));
    			sentlist.add(rs.getString("authority"));
    		}


    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	int listkazu=userlist.size();
    	return ok(PastCard.render(userlist,helplist,sentlist,listkazu));
    }


    public Result PastCord_resultTop() {

    	return ok(views.html.PastCord_resultTop.render());
    }

    public Result PastCord_result_1() {
    	return ok(views.html.PastCord_result_1.render());
    }
    public Result PastCord_result_2() {
    	return ok(views.html.PastCord_result_2.render());
    }
    public Result PastCord_result_3() {
    	return ok(views.html.PastCord_result_3.render());
    }
    public Result PastCord_result_4() {
    	return ok(views.html.PastCord_result_4.render());
    }
    public Result PastCord_result_5() {
    	return ok(views.html.PastCord_result_5.render());
    }
    public Result PastCord_result_6() {
    	return ok(views.html.PastCord_result_6.render());
    }
    public Result PastCord_result_7() {
    	return ok(views.html.PastCord_result_7.render());
    }
    public Result PastCord_result_8() {
    	return ok(views.html.PastCord_result_8.render());
    }
    public Result PastCord_result_9() {
    	return ok(views.html.PastCord_result_9.render());
    }
    public Result PastCord_result_10() {
    	return ok(views.html.PastCord_result_10.render());
    }
    public Result PastCord_result_11() {
    	return ok(views.html.PastCord_result_11.render());
    }




}
