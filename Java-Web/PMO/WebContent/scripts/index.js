


$(document).ready(function(){
  $("#header").fadeIn(3000);
  $("#content").fadeIn(6000);
  $("#footer").fadeIn(3000);
  
  $("input[type='text']").focus(function(){
    $(this).val("");
  });
  
  $("input[type='password']").focus(function(){
    $(this).val("");
  });
	
  $("#accr").accordion({
	collapsible: true
  });
	
	$("table.radio tr td").buttonset();
	
	$(".internSubmit").button();
	
	$(".bv").show(function(){
	      if ( $(this).children().length === 0 ) {
	    	var r = parseInt(document.getElementById("form1:firstDay").value);
	  		var y = document.getElementById("form1:lastDate").value;
			var weekdays=["S", "M", "Tu", "W", "Thu", "F", "S"];
			var str = $(this).text();
			var strArr = str.split(":");
			var innrHTML = "";
			var x ="";
			var a = "";
			if(y==strArr.length){
				for(var i=0;i<strArr.length;i++){
					x = x + weekdays[(r+i)%7] + " ";
					var str = i+1;
					if(str < 10){
						str = "0"+str;
					}
					a = a + str + " ";
					if(weekdays[(r+i)%7]=="S"){
						if(strArr[i]==8)
							innrHTML = innrHTML + "<input type='text' maxlength='2' style='width:12.5px;background-color:yellow;color:red' value='" + strArr[i] + "' /> ";
						else
							innrHTML = innrHTML + "<input type='text' maxlength='2' style='width:12.5px;background-color:yellow' value='" + strArr[i] + "' /> ";
					}else{
						if(strArr[i]==8)
							innrHTML = innrHTML + "<input type='text' maxlength='2' style='width:12.5px;' value='" + strArr[i] + "' /> ";
						else
							innrHTML = innrHTML + "<input type='text' maxlength='2' style='width:12.5px;background-color:orange' value='" + strArr[i] + "' /> ";
					}
				}
			}
			innrHTML = innrHTML + "<input type=button value='save' onClick='javascript:convert(this);'>";
	      	$(this).html(innrHTML);
			var headerEffort = document.getElementById('bvtable:dt:days');
			document.getElementById('bvtable:dt:days').innerHTML = a.substring(0, a.length-1);
			$(headerEffort).addClass("bvtableHeader_newClass");
			$(headerEffort).closest("th").css("text-align","left");
	      }
		});
	  
	  convert = function(id){
		var x = "";
		var effort = 0;
		var y = $(id).closest("label");
			$(y).children("input:text").each(function(){
				  x = x + $(this).val() + ":";
				  effort = effort + parseInt($(this).val());
			});
		//$(y).html(x.substring(0,x.length-1));
	    $(y).closest("td").children("input:hidden").val(x.substring(0,x.length-1));
	    var tds = $(y).closest("tr").children("td");
	    var effortPD = effort/8;
	    var effortTD = $(tds).eq(4);
	    var billedAmtTD = $(tds).eq(5);
	    var adjustTD = $(tds).eq(6);
	    var adjEffTD = $(tds).eq(7);
	    var adjAmtTD = $(tds).eq(8);
	    
	    $(effortTD).children("label").html(effortPD);
	    $(effortTD).children("input:hidden").val(effortPD);
	    
	    var billRate = parseFloat($(tds).eq(2).html());
	    var effDays = parseFloat($(tds).eq(4).children("label").html());
	    var billedAmt = billRate * effDays;
	    $(billedAmtTD).children("label").html(billedAmt);
	    $(billedAmtTD).children("input:hidden").val(billedAmt);
	    
	    var adjustVal = parseFloat($(adjustTD).children("input:text").val());
	    var adjEffVal = adjustVal + effortPD;
	    $(adjEffTD).children("label").html(adjEffVal);
	    $(adjEffTD).children("input:hidden").val(adjEffVal);
	    
	    var adjAmtVal = billRate * adjEffVal;
	    $(adjAmtTD).children("label").html(adjAmtVal);
	    $(adjAmtTD).children("input:hidden").val(adjAmtVal);
	  };
	  
	  var headerEffort = document.getElementById('bvtable:dt:days');
	  $(headerEffort).click(function(){
		  $(this).removeClass("bvtableHeader_newClass");
		  $(this).closest("th").css("text-align","center");
		  $(this).html("BEN for "+document.getElementById("form1:selectedPeriod").value);
	  });
	
	  updateOradd = function(newVal){
		alert(newVal);  
	  };
	  
	calcLastDate = function(date){
		var y = date.split('/')[1], m = date.split('/')[0];
		var firstDay = new Date(y, m-1, 1);
		var lastDay = new Date(y, m, 0);
		document.getElementById("form1:lastDate").value = lastDay.getDate();
		document.getElementById("form1:firstDay").value = firstDay.getDay();
		document.getElementById("form1:selectedPeriod").value = date;
	};
});