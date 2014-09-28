// JavaScript Document

function chklist() {
	if(document.getElementById('listalbum').value!='New') {
		document.getElementById('album').style.visibility='hidden';
	} else {
		document.getElementById('album').style.visibility='visible';
	}
}

function createRequestObject(){
	var request_o; //declare the variable to hold the object.
	var browser = navigator.appName; //find the browser name
	if(browser == "Microsoft Internet Explorer"){
		request_o = new ActiveXObject("Microsoft.XMLHTTP");
	}else{
		request_o = new XMLHttpRequest();
	}
	return request_o; //return the object
}

var http = createRequestObject(); 

function showpic(i) {
	http.open('get', 'back.php?ref='+i+'&refer=showpic');
	http.onreadystatechange = handleProducts; 
	http.send(null);
}
function showalbum(i) {
	http.open('get', 'back.php?ref='+i+'&refer=show');
	http.onreadystatechange = handleProd; 
	http.send(null);
}
function showmenu() {
	http.open('get', 'back.php?ref='+098090900+'&refer=menu');
	http.onreadystatechange = handleProd; 
	http.send(null);
}
function form() {
	http.open('get', 'back.php?ref='+00000+'&refer=form');
	http.onreadystatechange = handleProd; 
	http.send(null);
}
function handleProducts(){
	if(http.readyState == 4){ //Finished loading the response
		var response = http.responseText;
		document.getElementById('show').innerHTML = response;
	}
}
function handleProd(){
	if(http.readyState == 4){ //Finished loading the response
		var response = http.responseText;
		document.getElementById('menu').innerHTML = response;
	}
}