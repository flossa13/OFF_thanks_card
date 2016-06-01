package models;

import java.sql.*;
import java.util.ArrayList;

import play.db.*;

	public class Login {

		Connection connection = DB.getConnection();
		ArrayList<String> namelist = new ArrayList<String>();
		ArrayList<String> namelist2 = new ArrayList<String>();
		
		   	public String eployee_id; 
		   	public String pass; 
		    public String validate() {
		    	
		    	 try {
		    			PreparedStatement Ssql = connection.prepareStatement("select *  from employee_table");
		    			ResultSet rs = Ssql.executeQuery();
		    			while (rs.next()) {
		    				
		    			namelist.add(rs.getString("eployee_id"));
		    			namelist2.add(rs.getString("pass"));
		    				
		    			}
		    			
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
		    	
		    	 if (authenticate(namelist,namelist2) == null) {
		            return "社員IDとPASSが一致しません";
		    }
		        return null;
		    }

		    private Boolean authenticate(ArrayList<String> namelist3, ArrayList<String> namelist22) {
		       // return (id.equals("eployee_id") && pas.equals("pass"));
		        //return (namelist != null && namelist2 != null);
		    	return authenticate(namelist, namelist2);
		    }
	}
	