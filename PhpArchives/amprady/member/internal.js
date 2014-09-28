// JavaScript Document

function toggleview(form) {
	document.getElementById('memreg').style.display = "none";
	document.getElementById('memlog').style.display = "none";
	document.getElementById('adlog').style.display = "none";
	document.getElementById(form).style.display = "block";
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

function edit(i) {
	http.open('get', 'back.php?ref='+i+'&refer=edit');
	http.onreadystatechange = handleProducts; 
	http.send(null);
}
function memedit(i) {
	http.open('get', 'memback.php?ref='+i+'&refer=memedit');
	http.onreadystatechange = handleProducts; 
	http.send(null);
}
function accept(i) {
	http.open('get', 'back.php?ref='+i+'&refer=accept');
	http.onreadystatechange = handleProducts; 
	http.send(null);
}

function del(i) {
	window.location = 'back.php?ref='+i+'&refer=del';
}

/* Function called to handle the list that was returned from the internal_request.php file.. */
function handleProducts(){
	if(http.readyState == 4){ //Finished loading the response
		var response = http.responseText;
		document.getElementById('hidden').innerHTML = response;
	}
}