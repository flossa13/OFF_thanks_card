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

import javax.inject.Inject;

import play.data.Form;
import play.data.FormFactory;

import models.Thanks_Card_Table;
import views.html.*;
import play.db.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class SHomeController extends Controller {
@Inject
private FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
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
    	 String pageName="過去カード一覧";
    	int listkazu=idlist.size();
    	return ok(PastCard.render(idlist,helplist,sentlist,listkazu,pageName));
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
    	String pageName="過去カード一覧";
    	int listkazu=idlist.size();
    	return ok(PastCard.render(idlist,helplist,sentlist,listkazu,pageName));
    }

  //rank付け********************************************

    public Result updateRank(){
    	ArrayList<String> sendList = new ArrayList<>();
    	Form<Thanks_Card_Table> card = formFactory.form(Thanks_Card_Table.class).bindFromRequest();


    	try {
			 Thanks_Card_Table newTask = card.get();

			 newTask.update();

		 } catch (Exception e) {
				e.printStackTrace();
			}
    	return ok("更新しました");
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
    	 String pageName="A評価一覧";
    	int listkazu=idlist.size();
    	return ok(PastCard.render(idlist,helplist,sentlist,listkazu,pageName));
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
    	String pageName="B評価一覧";
    	int listkazu=idlist.size();
    	return ok(PastCard.render(idlist,helplist,sentlist,listkazu,pageName));
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
    	 String pageName="C評価一覧";
    	int listkazu=idlist.size();
    	return ok(PastCard.render(idlist,helplist,sentlist,listkazu,pageName));
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
    	 String pageName="未評価一覧";
    	int listkazu=idlist.size();
    	return ok(PastCard.render(idlist,helplist,sentlist,listkazu,pageName));
    }


 //rank別集計*********************************************************************************************
 //top選択画面
    public Result PastCard_resultTop() {

    	return ok(PastCard_resultTop.render());
    }
//人事
    public Result PastCard_result_1() {
    	Connection connection = DB.getConnection();
    	ArrayList<String> userlist = new ArrayList<>();
    	ArrayList<String> rankcount = new ArrayList<>();

    	int a=0;//A評価カウンター
		int b=0;//B評価カウンター
		int c=0;//C評価カウンター

    	try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from employee_table WHERE division_id = 2 ");
    		ResultSet rs = Ssql.executeQuery();
    		PreparedStatement Ssql2 = connection.prepareStatement("select * from thanks_card_table "
												    				+ "join employee_table "
												    				+ "on thanks_card_table.send_user_id = employee_table.employee_id "
												    				+ "where division_id = 2");
    		ResultSet rs2 = Ssql2.executeQuery();
    		while (rs.next()) {
    			userlist.add(rs.getString("employee_namen"));
    		}


    		while (rs2.next()) {
    			rankcount.add(rs2.getString("rank"));
    			if(rankcount.equals("a")){
    				a++;
    			}else if(rankcount.equals("b")){
    				b++;
    			}else{
    				c++;
    			}
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	String divName="人事";
    	return ok(PastCard_result.render(divName,userlist,a,b,c));
    }

//総務
    public Result PastCard_result_2() {
    	Connection connection = DB.getConnection();
    	ArrayList<String> userlist = new ArrayList<>();
    	ArrayList<String> rankcount = new ArrayList<>();

    	int a=0;//A評価カウンター
		int b=0;//B評価カウンター
		int c=0;//C評価カウンター
    	try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from employee_table WHERE division_id = 3 ");
    		ResultSet rs = Ssql.executeQuery();
    		PreparedStatement Ssql2 = connection.prepareStatement("select * from thanks_card_table "
												    				+ "join employee_table "
												    				+ "on thanks_card_table.send_user_id = employee_table.employee_id "
												    				+ "where division_id = 3");
    		ResultSet rs2 = Ssql2.executeQuery();
    		while (rs.next()) {
    			userlist.add(rs.getString("employee_namen"));
    		}


    		while (rs2.next()) {
    			rankcount.add(rs2.getString("rank"));
    			if(rankcount.equals("a")){
    				a++;
    			}else if(rankcount.equals("b")){
    				b++;
    			}else{
    				c++;
    			}
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	String divName="総務";
    	return ok(PastCard_result.render(divName,userlist,a,b,c));
    }
//システム開発
    public Result PastCard_result_3() {
    	Connection connection = DB.getConnection();
    	ArrayList<String> userlist = new ArrayList<>();
    	ArrayList<String> rankcount = new ArrayList<>();

    	int a=0;//A評価カウンター
		int b=0;//B評価カウンター
		int c=0;//C評価カウンター

    	try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from employee_table WHERE division_id = 4 ");
    		ResultSet rs = Ssql.executeQuery();
    		PreparedStatement Ssql2 = connection.prepareStatement("select * from thanks_card_table "
												    				+ "join employee_table "
												    				+ "on thanks_card_table.send_user_id = employee_table.employee_id "
												    				+ "where division_id = 4");
    		ResultSet rs2 = Ssql2.executeQuery();
    		while (rs.next()) {
    			userlist.add(rs.getString("employee_namen"));
    		}


    		while (rs2.next()) {
    			rankcount.add(rs2.getString("rank"));
    			if(rankcount.equals("a")){
    				a++;
    			}else if(rankcount.equals("b")){
    				b++;
    			}else{
    				c++;
    			}
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	String divName="システム開発";
    	return ok(PastCard_result.render(divName,userlist,a,b,c));
    }
//営業
    public Result PastCard_result_4() {
    	Connection connection = DB.getConnection();
    	ArrayList<String> userlist = new ArrayList<>();
    	ArrayList<String> rankcount = new ArrayList<>();

    	int a=0;//A評価カウンター
		int b=0;//B評価カウンター
		int c=0;//C評価カウンター
    	try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from employee_table WHERE division_id = 5 ");
    		ResultSet rs = Ssql.executeQuery();
    		PreparedStatement Ssql2 = connection.prepareStatement("select * from thanks_card_table "
												    				+ "join employee_table "
												    				+ "on thanks_card_table.send_user_id = employee_table.employee_id "
												    				+ "where division_id = 5");
    		ResultSet rs2 = Ssql2.executeQuery();
    		while (rs.next()) {
    			userlist.add(rs.getString("employee_namen"));
    		}


    		while (rs2.next()) {
    			rankcount.add(rs2.getString("rank"));
    			if(rankcount.equals("a")){
    				a++;
    			}else if(rankcount.equals("b")){
    				b++;
    			}else{
    				c++;
    			}
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	String divName="営業";
    	return ok(PastCard_result.render(divName,userlist,a,b,c));
    }




}

