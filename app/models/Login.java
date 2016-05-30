package models;



public class Login {
    public String username;
    public String password;
    

    public String validate() {
        if (authenticate(username, password)) {
            return null;
    }
        return "社員IDとPASSが一致しません";
    }

    private Boolean authenticate(String username, String password) {
        return (username.equals("koko") && password.equals("popo"));
    }
	}