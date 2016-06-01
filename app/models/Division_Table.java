package models;


import javax.persistence.Entity;
import javax.persistence.Id;
import com.avaje.ebean.Model;

@Entity
public class Division_Table extends Model {
	@Id
	public Integer division_id;
	public Integer authority;
	public String  dicision_namen;


}
