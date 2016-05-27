package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import play.db.DB;
import play.mvc.*;

import views.html.*;

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
        return ok(index.render("Your new application is ready."));
    }

    // 送受信画面を表示
    public Result home() {
    	return ok(home.render());
    }

	 //送信履歴を表示
	public Result send() {
		Connection connection = DB.getConnection();
		ArrayList<String> cardlist = new ArrayList<String>();
		ArrayList<String> userlist = new ArrayList<String>();
		ArrayList<String> helplist = new ArrayList<String>();
		ArrayList<String> sentlist = new ArrayList<String>();

	 	try {
			PreparedStatement Ssql = connection.prepareStatement("select *  from thanks_Card_table");
			ResultSet rs = Ssql.executeQuery();
			while (rs.next()) {
				cardlist.add(rs.getString("today"));
				userlist.add(rs.getString("receive_user_id"));
				helplist.add(rs.getString("help_content"));
				sentlist.add(rs.getString("sent_content"));
			}
	 	}
	 	catch (Exception e) {
			e.printStackTrace();
	 	}
	 	int count = cardlist.size();
	 	return ok(send.render(cardlist,userlist,helplist,sentlist,count));
	}

    //受信履歴を表示
	public Result receive() {
		Connection connection = DB.getConnection();
		ArrayList<String> cardlist = new ArrayList<String>();
		ArrayList<String> userlist = new ArrayList<String>();
		ArrayList<String> helplist = new ArrayList<String>();
		ArrayList<String> sentlist = new ArrayList<String>();
		ArrayList<String> readlist = new ArrayList<String>();
	 	try {
			PreparedStatement Ssql = connection.prepareStatement("select *  from thanks_Card_table");
			ResultSet rs = Ssql.executeQuery();
			while (rs.next()) {
				cardlist.add(rs.getString("today"));
				userlist.add(rs.getString("send_user_id"));
				helplist.add(rs.getString("help_content"));
				sentlist.add(rs.getString("sent_content"));
				readlist.add(rs.getString("read_card"));
			}
	 	}
	 	catch (Exception e) {
			e.printStackTrace();
	 	}
	 	int count = cardlist.size();
	 	return ok(receive.render(cardlist,userlist,helplist,sentlist,readlist,count));
	}


    //トップ画面を表示
    public Result top() {
    	return ok(top.render());
    }



}
