package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.w3c.dom.Document;

import models.Thanks_Card_Table;
import play.data.Form;
//import models.Thanks_Card_Table;
import play.data.FormFactory;
import play.db.*;
import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

	@Inject
	private FormFactory formFactory;

	int max = 0;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
    	return ok(index.render("Your new application is ready."));
    }

    public Result tasks(){

	    return ok(tasks.render());
	 }

	 public Result create(){

		 Connection connection = DB.getConnection();
		 Date date = new Date();

		    ArrayList<String> namelist = new ArrayList<String>();
		    ArrayList<Integer> idlist = new ArrayList<Integer>();
		    ArrayList<String> dnamelist = new ArrayList<String>();
		    ArrayList<Integer> didlist = new ArrayList<Integer>();
		    try {
		    	//Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.4.17/thanksCard");
		        PreparedStatement Ssql = connection.prepareStatement("select *  from employee_table");
		        PreparedStatement Dsql = connection.prepareStatement("select *  from division_table");
		        PreparedStatement Cardsql = connection.prepareStatement("select *  from division_table");
		        ResultSet rs = Ssql.executeQuery();
		        ResultSet drs = Dsql.executeQuery();
		        ResultSet cardrs = Cardsql.executeQuery();
		        while (rs.next()) {
		            namelist.add(rs.getString("employee_namen"));
		            idlist.add(rs.getInt("employee_id"));
		            didlist.add(rs.getInt("division_id"));
		        }
		        while(drs.next()){
		        	dnamelist.add(drs.getString("division_namen"));

		        	//didlist.add(1);

		        }
		        while(cardrs.next()){
		        	int num =cardrs.getInt("card_Id");
		        	if(num > max){
		        		max = num;
		        	}
		        }
		        max++;
		   	} catch (Exception e) {
		        e.printStackTrace();
		    }
		//  CardController card = new CardController();

	 	return ok(create.render(namelist,idlist, dnamelist, didlist));
	 }
	 String str = null;
	 public Result sendDB(){
		 Date date = new Date();
		 ArrayList<String> sendList = new ArrayList<>();

		 Form<Thanks_Card_Table> card = formFactory.form(Thanks_Card_Table.class).bindFromRequest();

		 try {
			 Thanks_Card_Table newTask = card.get();
			 newTask.card_id = max;
			 newTask.send_user_id = 10021245;
			 newTask.today = date.toString();
			 newTask.rank = "c";
			 newTask.read_card = false;
			 newTask.check_flg = true;

			// newTask.save();

		 } catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
         return ok(sendDB.render());
	 }
}
