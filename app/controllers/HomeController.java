package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.*;
import java.util.Date;

import play.db.DB;
import play.mvc.*;

import views.html.*;
import models.Division_Table;
import models.Employee_Table;
import models.Thanks_Card_Table;

import play.data.Form;
import play.data.FormFactory;

import scala.xml.Document;
import javax.inject.Inject;

public class HomeController extends Controller {
	@Inject
	private FormFactory formFactory;

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    /********************************************************************************************************
     ***--------送受信画面を表示-----------*******************************************************************
     ********************************************************************************************************/
    public Result home() {
    	return ok(home.render());
    }

	//送信履歴を表示
    /********************************************************************************************************
     ***--------送信履歴を表示------------*******************************************************************
     ********************************************************************************************************/
	public Result send() {
		Connection connection = DB.getConnection();
		ArrayList<String> cardlist = new ArrayList<String>();
		ArrayList<String> datelist = new ArrayList<String>();
		ArrayList<String> userlist = new ArrayList<String>();
		ArrayList<String> helplist = new ArrayList<String>();
		ArrayList<String> sentlist = new ArrayList<String>();
		ArrayList<String> namelist = new ArrayList<String>();
		ArrayList<String> divisionlist = new ArrayList<String>();

	 	try {
			PreparedStatement Ssql = connection.prepareStatement("SELECT * FROM thanks_Card_table "
			+ "INNER JOIN (employee_table "
			+ "INNER JOIN division_table ON employee_table.division_id"
			+ " = division_table.division_id) ON thanks_card_table.receive_user_id"
			+ " = employee_table.employee_id ORDER BY card_id DESC");
			ResultSet rs = Ssql.executeQuery();
			while (rs.next()) {
				cardlist.add(rs.getString("card_id"));				//カードIDを取得
				datelist.add(rs.getString("today"));				//カードの日付を取得
				userlist.add(rs.getString("receive_user_id"));		//カードの受信者IDを取得
				namelist.add(rs.getString("employee_namen"));		//カードの受信者名を取得
				helplist.add(rs.getString("help_content"));			//カードの件名を取得
				sentlist.add(rs.getString("sent_content"));			//カードの内容を取得
				divisionlist.add(rs.getString("division_namen"));	//受信者の部署を取得
			}
	 	}
	 	catch (Exception e) {
			e.printStackTrace();
	 	}
	 	int count = cardlist.size();		//送信カードの件数をカウント
	 	return ok(send.render(cardlist,datelist,userlist,helplist,sentlist,count,namelist,divisionlist));
	}


    /********************************************************************************************************
     ***--------受信履歴を表示------------*******************************************************************
     ********************************************************************************************************/
	public Result receive() {
		Connection connection = DB.getConnection();
		ArrayList<String> cardlist = new ArrayList<String>();
		ArrayList<String> datelist = new ArrayList<String>();
		ArrayList<String> userlist = new ArrayList<String>();
		ArrayList<String> helplist = new ArrayList<String>();
		ArrayList<String> sentlist = new ArrayList<String>();
		ArrayList<String> readlist = new ArrayList<String>();
		ArrayList<String> namelist = new ArrayList<String>();
		ArrayList<String> checklist = new ArrayList<String>();
		ArrayList<String> divisionlist = new ArrayList<String>();
	 	try {
			PreparedStatement Ssql = connection.prepareStatement("SELECT * FROM thanks_card_table "
			+ "INNER JOIN (employee_table "
			+ "INNER JOIN division_table ON employee_table.division_id"
			+ " = division_table.division_id) ON thanks_card_table.send_user_id"
			+ " = employee_table.employee_id ORDER BY card_id DESC");
			ResultSet rs = Ssql.executeQuery();
			while (rs.next()) {
				cardlist.add(rs.getString("card_id"));				//カードIDを取得
				datelist.add(rs.getString("today"));				//カードの日付を取得
				userlist.add(rs.getString("send_user_id"));			//カード送信者IDを取得
				namelist.add(rs.getString("employee_namen"));		//カード送信者の名前を取得
				helplist.add(rs.getString("help_content"));			//カードの件名を取得
				sentlist.add(rs.getString("sent_content"));			//カードの内容を取得
				readlist.add(rs.getString("read_card"));			//カードの既読状態を取得
				checklist.add(rs.getString("check_flg"));			//カードの返信状態を取得
				divisionlist.add(rs.getString("division_namen"));	//送信者の部署を取得
			}
		}
	 	catch (Exception e) {
			e.printStackTrace();
	 	}
	 	int count = cardlist.size();
	 	return ok(receive.render(cardlist,datelist,userlist,helplist,sentlist,readlist,count,namelist,checklist,divisionlist));
	}


    /********************************************************************************************************
     ***--------カード詳細を取得・受け渡し------------*******************************************************
     ********************************************************************************************************/
    public Result card_2() {
    	Form<Employee_Table> employee = formFactory.form(Employee_Table.class).bindFromRequest();
    	Form<Thanks_Card_Table> thanks = formFactory.form(Thanks_Card_Table.class).bindFromRequest();
    	Form<Division_Table> division = formFactory.form(Division_Table.class).bindFromRequest();

    	String send = "", division_name = "",help = "",sent = "";
    	Date date = new Date();
    	try {
    		Employee_Table newTask = employee.get();
    		Division_Table newTask_2 = division.get();
    		Thanks_Card_Table newTask_3 = thanks.get();

			 send = newTask.employee_namen;
			 division_name = newTask_2.division_namen;
			 help = newTask_3.help_content;
			 sent = newTask_3.sent_content;
			 date = newTask_3.today;

		 } catch (Exception e) {
				e.printStackTrace();
			}

    	return ok(card.render(send,division_name,help,sent,date));
    }



}
