function createRequestObject(){
	var request_o; //declare the variable to hold the object.
	var browser = navigator.appName; //find the browser name
	if(browser == "Microsoft Internet Explorer"){
		/* Create the object using MSIE's method */
		request_o = new ActiveXObject("Microsoft.XMLHTTP");
	}else{
		/* Create the object using other browser's method */
		request_o = new XMLHttpRequest();
	}
	return request_o; //return the object
}

/* The variable http will hold our new XMLHttpRequest object. */
var http = createRequestObject(); 


function mouseOver(i)
{
// document.getElementById('show').style.visibility="visible";
	http.open('get', 'show_table.php?ref='+i);
	/* Define a function to call once a response has been received. This will be our
		handleProductCategories function that we define below. */
	http.onreadystatechange = handleProducts; 
	/* Send the data. We use something other than null when we are sending using the POST
		method. */
	http.send(null);
}
function mouseOut()
{
// document.getElementById('show').style.visibility="hidden";
document.getElementById('show').innerHTML="hi all.... Default Content....";
}


/* Function called to handle the list that was returned from the internal_request.php file.. */
function handleProducts(){
	/* Make sure that the transaction has finished. The XMLHttpRequest object 
		has a property called readyState with several states:
		0: Uninitialized
		1: Loading
		2: Loaded
		3: Interactive
		4: Finished */
	if(http.readyState == 4){ //Finished loading the response
		/* We have got the response from the server-side script,
			let's see just what it was. using the responseText property of 
			the XMLHttpRequest object. */
		var response = http.responseText;
		/* And now we want to change the product_categories <div> content.
			we do this using an ability to get/change the content of a page element 
			that we can find: innerHTML. */
		document.getElementById('show').innerHTML = response;
	}
}