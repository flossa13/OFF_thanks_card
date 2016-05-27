function filedChanged(){
	var useID = getField("username");
	var password =getField("password");
	var disabled =true;
	
	if (userId.value.length > 0 && password.value.length > 0)
		disabled = true;
	}
	
	var login =get Field("login");
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
var login1,login2 = {};

/** 
 * @param loginForm formエレメント
 * @return 成功時true,失敗時false
 */
Login.doLogin = function doLogin(loginForm) {

    //空チェック
    if(loginForm.username.value == '') {
        return Login.doError('ユーザー名を入力してください。');
    }
    if(loginForm.password.value == '') {
        return Login.doError('パスワードを入力してください。');
    }

    //エラーなし
    return true;
}

/**
 * エラー時の動作
 */
Login.doError = function doError(msg) {
    alert(msg);
    return false;
}