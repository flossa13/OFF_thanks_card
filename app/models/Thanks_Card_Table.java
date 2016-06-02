package models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.avaje.ebean.Model;

@Entity
public class Thanks_Card_Table extends Model {
	@Id
	public Integer card_id;
	public String send_user_id;
	public String receive_user_id;
	public String help_content;
	public String sent_content;
	public Date today;
	public String rank;
	public boolean read_card;
	public boolean check_flg;


}
