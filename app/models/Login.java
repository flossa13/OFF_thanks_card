package models;



public class Login {
    public String enployee_id;
    public String divasion_id;
    

    public String validate() {
        if (authenticate(enployee_id, divasion_id)) {
            return null;
    }
        return "社員IDとPASSが一致しません";
    }

    private Boolean authenticate(String enployee_id, String divasion_id) {
        return (enployee_id.equals("koko") && divasion_id.equals("popo"));
    }
	}