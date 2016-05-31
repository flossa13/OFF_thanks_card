package models;


import javax.persistence.Entity;
import javax.persistence.Id;
import com.avaje.ebean.Model;

@Entity
public class Thanks_Card_Table extends Model {
	@Id
	public Integer card_id;
	public Integer send_user_id;
	public Integer receive_user_id;
	public String help_content;
	public String sent_content;
	public String today;
	public String rank;
	public boolean read_card;
	public boolean check_flg;


}
