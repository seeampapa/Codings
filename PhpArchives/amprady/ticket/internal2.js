function ValidateForm(form) {
	if(form.name.value.length==0) { msg1="name is empty"; }
	if(form.email.value.length==0) { msg2="email is empty"; }
	if(form.email.indexOf(".") > 2) && (form.email.indexOf("@") > 0) { msg4="invalid email id"; }
	if(form.addr.value.length==0) { msg3="address is empty"; }
	if(msg1!="" || msg2!="" || msg3!="" || msg4!="") { alert(msg1+"\n"+msg2+"\n"+msg3); 
	return false; }
	
return true;
}

