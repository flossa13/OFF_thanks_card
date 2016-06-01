package models;


import javax.persistence.Entity;
import javax.persistence.Id;
import com.avaje.ebean.Model;

@Entity
public class Employee_Table extends Model {
	@Id
	public Integer employee_id;
	public Integer division_id;
	public String employee_namen;
	public String pass;


}
