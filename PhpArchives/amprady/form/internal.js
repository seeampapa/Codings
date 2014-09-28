// JavaScript Document

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

function showform(i) {
	http.open('get', 'back.php?ref='+i+'&refer=form');
	http.onreadystatechange = handleProduct; 
	http.send(null);
}
function showtop() {
	http.open('get', 'back.php?ref=ab&refer=top');
	http.onreadystatechange = handleProducts; 
	http.send(null);
}
function shownewform() {
	http.open('get', 'back.php?ref=ab&refer=newform');
	http.onreadystatechange = handleProducts; 
	http.send(null);
}

function handleProducts(){
	if(http.readyState == 4){ //Finished loading the response
		var response = http.responseText;
		document.getElementById('top').innerHTML = response;
	}
}
function handleProduct(){
	if(http.readyState == 4){ //Finished loading the response
		var response = http.responseText;
		document.getElementById('form').innerHTML = response;
	}
}
