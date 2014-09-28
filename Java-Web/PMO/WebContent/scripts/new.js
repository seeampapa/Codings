$(document).ready(function(){
	var person_Array = new Array();
	
	// default Cookie while loading	
	var onLoadCookie = readCookie("person_Array_cName");
	if(onLoadCookie!=null){
		person_Array = JSON.parse(onLoadCookie);
		var table_content = $("#table_place").html().split('</table>')[0];
		for(var i=0; i<person_Array.length; i++){
			table_content = table_content + "<tr><td>" + person_Array[i].name + "</td><td>" + person_Array[i].phone + "</td></tr>";
			$("select").append("<option value='" + (i+1) + "'>"+ person_Array[i].name +"</option>");
		}
		table_content = table_content + "</table>";
		$("#table_place").html(table_content);
	}
	
	$("#add").click(function(){
		person_Array[person_Array.length] = createPerson($("#name").val(), $("#phone").val());
		addToSelect();
		addToTable();
	});
	
	createPerson = function(name, phone){
		person = new Object();
		person.name = name;
		person.phone = phone;
		return person;
	}
	
	addToTable = function(){
		var table = $("#table_place").html().split('</table>')[0] + "<tr><td>" + person_Array[person_Array.length - 1].name + "</td><td>" + person_Array[person_Array.length - 1].phone + "</td></tr>";
		$("#table_place").html(table + "</table>");
	}
	
	addToSelect = function(){
		$("select").append("<option value='" + person_Array.length + "'>"+ person_Array[person_Array.length - 1].name +"</option>");
		setPersonObjInCookie();
	}
	
	$("#send").click(function(){
		var person_Arr = JSON.parse(readCookie("person_Array_cName"));
		$("#dyn").append("<tr><td>" + person_Arr[$("select").val() - 1].name  + "</td><td>" + person_Arr[$("select").val() - 1].phone + "</td>");
	});
	
	
	setPersonObjInCookie = function(){
		document.cookie = "person_Array_cName=" + JSON.stringify(person_Array) + ";";
		document.cookie = "expires=Sat, 10 Aug 2013 10:18:14 GMT";
		
		alert(document.cookie);
	}
	
	getPersonObjfromCookie = function(){
		var nameEQ = "person_Array_cName=";
		var ca = document.cookie.split(';');
		for(var i=0;i < ca.length;i++) {
			var c = ca[i];
			while (c.charAt(0)==' ') c = c.substring(1,c.length);
			if (c.indexOf(nameEQ) == 0){
				return JSON.parse(c.substring(nameEQ.length,c.length));
			}
		}
		return null;
	}
	
	function readCookie(cname)
	{
    var allcookies = document.cookie;
		alert(allcookies);
    cookiearray  = allcookies.split(';');
		for(var i=0; i<cookiearray.length; i++){
      name = cookiearray[i].split('=')[0];
      value = cookiearray[i].split('=')[1];
			if(cname == name){
				return value;
      }
   }
	 return null;
}
		
});