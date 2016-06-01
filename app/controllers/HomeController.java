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

//過去カード一覧、新しい順で表示 defaultPage
    public Result PastCard() {
    	Connection connection = DB.getConnection();
    	ArrayList<String> idlist = new ArrayList<>();
    	ArrayList<String> helplist = new ArrayList<>();
    	ArrayList<String> sentlist = new ArrayList<>();

    	 try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from thanks_card_table order by card_id desc");
    		ResultSet rs = Ssql.executeQuery();
    		while (rs.next()) {
    			idlist.add(rs.getString("card_id"));
    			helplist.add(rs.getString("help_content"));
    			sentlist.add(rs.getString("sent_content"));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	int listkazu=idlist.size();
    	return ok(PastCard.render(idlist,helplist,sentlist,listkazu));
    }

//ソート古い順のページ
    public Result sortOldCard() {
    	Connection connection = DB.getConnection();
    	ArrayList<String> idlist = new ArrayList<>();
    	ArrayList<String> helplist = new ArrayList<>();
    	ArrayList<String> sentlist = new ArrayList<>();

    	 try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from thanks_card_table order by card_id");
    		ResultSet rs = Ssql.executeQuery();
    		while (rs.next()) {
    			idlist.add(rs.getString("card_id"));
    			helplist.add(rs.getString("help_content"));
    			sentlist.add(rs.getString("sent_content"));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	int listkazu=idlist.size();
    	return ok(sortOldCard.render(idlist,helplist,sentlist,listkazu));
    }

  //絞込みA*****************************************************
    public Result PastCard_A() {
    	Connection connection = DB.getConnection();
    	ArrayList<String> idlist = new ArrayList<>();
    	ArrayList<String> helplist = new ArrayList<>();
    	ArrayList<String> sentlist = new ArrayList<>();

    	 try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from thanks_card_table where rank ='a' ");
    		ResultSet rs = Ssql.executeQuery();
    		while (rs.next()) {
    			idlist.add(rs.getString("card_id"));
    			helplist.add(rs.getString("help_content"));
    			sentlist.add(rs.getString("sent_content"));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	int listkazu=idlist.size();
    	return ok(PastCard_ABC.render(idlist,helplist,sentlist,listkazu));
    }

  //絞込みB*****************************************************
    public Result PastCard_B() {
    	Connection connection = DB.getConnection();
    	ArrayList<String> idlist = new ArrayList<>();
    	ArrayList<String> helplist = new ArrayList<>();
    	ArrayList<String> sentlist = new ArrayList<>();

    	 try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from thanks_card_table where rank ='b' ");
    		ResultSet rs = Ssql.executeQuery();
    		while (rs.next()) {
    			idlist.add(rs.getString("card_id"));
    			helplist.add(rs.getString("help_content"));
    			sentlist.add(rs.getString("sent_content"));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	int listkazu=idlist.size();
    	return ok(PastCard_ABC.render(idlist,helplist,sentlist,listkazu));
    }

  //絞込みC*****************************************************
    public Result PastCard_C() {
    	Connection connection = DB.getConnection();
    	ArrayList<String> idlist = new ArrayList<>();
    	ArrayList<String> helplist = new ArrayList<>();
    	ArrayList<String> sentlist = new ArrayList<>();

    	 try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from thanks_card_table where rank ='c' ");
    		ResultSet rs = Ssql.executeQuery();
    		while (rs.next()) {
    			idlist.add(rs.getString("card_id"));
    			helplist.add(rs.getString("help_content"));
    			sentlist.add(rs.getString("sent_content"));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	int listkazu=idlist.size();
    	return ok(PastCard_ABC.render(idlist,helplist,sentlist,listkazu));
    }

  //絞込み未評価*****************************************************
    public Result PastCard_D() {
    	Connection connection = DB.getConnection();
    	ArrayList<String> idlist = new ArrayList<>();
    	ArrayList<String> helplist = new ArrayList<>();
    	ArrayList<String> sentlist = new ArrayList<>();

    	 try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from thanks_card_table where rank IS NULL ");
    		ResultSet rs = Ssql.executeQuery();
    		while (rs.next()) {
    			idlist.add(rs.getString("card_id"));
    			helplist.add(rs.getString("help_content"));
    			sentlist.add(rs.getString("sent_content"));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	int listkazu=idlist.size();
    	return ok(PastCard_ABC.render(idlist,helplist,sentlist,listkazu));
    }


 //*********************************************************************************************
    public Result PastCard_resultTop() {
    	return ok(views.html.PastCard_resultTop.render());
    }

    public Result PastCard_result_1() {
    	return ok(views.html.PastCard_result.render());
    }
    public Result PastCard_result_2() {
    	return ok(views.html.PastCard_result.render());
    }
    public Result PastCard_result_3() {
    	return ok(views.html.PastCard_result.render());
    }
    public Result PastCard_result_4() {
    	return ok(views.html.PastCard_result.render());
    }
    public Result PastCard_result_5() {
    	return ok(views.html.PastCard_result.render());
    }
    public Result PastCard_result_6() {
    	return ok(views.html.PastCard_result.render());
    }
    public Result PastCard_result_7() {
    	return ok(views.html.PastCard_result.render());
    }
    public Result PastCard_result_8() {
    	return ok(views.html.PastCard_result.render());
    }
    public Result PastCard_result_9() {
    	return ok(views.html.PastCard_result.render());
    }
    public Result PastCard_result_10() {
    	return ok(views.html.PastCard_result.render());
    }
    public Result PastCard_result_11() {
    	return ok(views.html.PastCard_result.render());
    }




}
