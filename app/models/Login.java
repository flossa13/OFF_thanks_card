package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import play.db.*;

	public class Login {

		Connection connection = DB.getConnection();
		ArrayList<String> namelist = new ArrayList<String>();{

			try {
				PreparedStatement Ssql = connection.prepareStatement("select *  from employee_table");
				ResultSet rs = Ssql.executeQuery();
				while (rs.next()) {
					namelist.add(rs.getString("employee_namen"));
				}
	} 			
			catch (Exception e) {
				e.printStackTrace();
	}
			String id = request.getParameter("id");
			String pas= request.getParameter("user_id");
			
			
	}
	}