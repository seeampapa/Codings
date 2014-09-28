<?	$message="";
	if($_POST['submit'] and $_POST['code']!="") {
	require("dbconn.php");
	$r=mysql_query("Select * from golden_ticket where ticket_code='".$_POST['code']."'") or die("Query failed: " . mysql_error());
	$n=mysql_fetch_array($r);
	if($n['ticket_won']=='Yes') { $message = "SORRY, WRONG CODE! CODE ALREADY USED"; }
	else {	$message = "YOU HAVE WON A <b>".$n['ticket_prize']."</b><br/>Please enter your details. <span onclick='userFrm()'>[click here]</span>";
	$id = $n['id']; } }
	if($_POST['submit2'] and $_POST['name']!="" and $_POST['email']!="" and $_POST['addr']!="") {
	require("dbconn.php");
	mysql_query("INSERT INTO won_ticket(ticket_id, name, email, address) VALUES ('".$_POST['id']."', '".$_POST['name']."', '".$_POST['email']."', '".$_POST['addr']."')") or die("INSERT Query failed: " . mysql_error());
	mysql_query("UPDATE golden_ticket SET ticket_won='Yes' WHERE id='".$_POST['id']."'") or die("TRY AGAIN LATER");
	echo "msg: User Details accepted. U'll be contacted by our admin. "; } 
	?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Ticket - DB interacting example</title>
<script language="javascript" type="text/javascript" src="internal2.js"></script>
<script type="text/javascript">
function userFrm() {
	get = document.getElementById('userform');
	if(get.style.display == 'block')
          get.style.display = 'none';
       else
          get.style.display = 'block';
}
</script>
</head>

<body>
<form id="form1" name="form1" method="post" action="<? $_SERVER['PHP_SELF']; ?>">Enter the Code provided in GOLDEN TICKET: <input type="text" name="code" id="code" /><input type="submit" name="submit" value="submit" /></form><hr />
<div id="disprize"><? echo $message; ?> </div><hr/>
<div id="userform" style="display: none;"><form method="post" name="form2" id="form2" action="<? $_SERVER['PHP_SELF']; ?>" onsubmit="javascript:return ValidateForm(this)">Name: <input type="text" name="name" id="name" /><input type="hidden" name="id" id="id" value="<? echo $id; ?>" /><br/>Email: <input type="text" name="email" id="email" /><br/>Address: <label><textarea name="addr" id="addr" cols="45" rows="3"></textarea></label>
    <input type="submit" name="submit2" value="submit" />
</form></div>
</body>
</html>