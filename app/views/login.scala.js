function filedChanged(){
	var enployee_id = getField("enployee_id");
	var divasion_id =getField("pass");
	var disabled =true;
	
	if (userId.value.length > 0 && password.value.length > 0)
		disabled = true;
	}
	
	var login =get Field("login1");
	if (disabled) {
		login.setAttribute("disabled" , "disabled");
	}
	else {
		login.removeAttribute("disabled");
	}
	
	
function getField(fieldname){
	var field = document.getElementById(fieldname);
	if (field == underfield){
		throw new Error("入力されていません" + fieldname);
	}
	return field
}