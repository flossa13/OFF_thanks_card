package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import play.db.DB;

public class Login {
	public String username;
    public String password;

    public String validate() {
        if (authenticate(username, password)) {
            return null;
        }
        return "再入力して下さい";
    }



    private Boolean authenticate(String username, String password) {
    	Connection connection = DB.getConnection();
    	ArrayList<String> pwlist = new ArrayList<>();
    	ArrayList<String> userlist = new ArrayList<>();
    	int j=0;

    	 try {
    		PreparedStatement Ssql = connection.prepareStatement("select *  from employee_table ");
    		ResultSet rs = Ssql.executeQuery();
    		while (rs.next()) {
    			pwlist.add(rs.getString("pass"));
    			userlist.add(rs.getString("employee_id"));
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}

    	for(int i = 0; i < userlist.size(); i++){
    		if(userlist.get(i).equals(username)){
				if(pwlist.get(i).equals(password)){
					return true;
				}
			}
    	}
        return false;
    }
}
