<? if($_POST['submit'] and $_POST['code']!="" and $_POST['prize']!="") {
require("dbconn.php");
mysql_query("INSERT INTO golden_ticket(id, ticket_code, ticket_prize, ticket_won) VALUES ('NULL', '".$_POST['code']."', '".$_POST['prize']."', 'No')") or die("Query failed: " . mysql_error());
echo "msg: code and prize accepted <br/>"; } 
if($_POST['edit'] and $_POST['code2']!="" and $_POST['prize2']!="") {
require("dbconn.php");
mysql_query("UPDATE golden_ticket set ticket_code='".$_POST['code2']."', ticket_prize='".$_POST['prize2']."', ticket_won='".$_POST['won2']."' WHERE id='".$_POST['id2']."'") or die("Query failed: " . mysql_error());
echo "msg: code and prize updated <br/>"; } ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Ticket - DB interacting example</title>
<script language="javascript" type="text/javascript" src="internal.js">	</script>
</head>

<body>
Add Code/Prize for Ticket:
<form action="<? $_SERVER["PHP_SELF"]; ?>" method="post" name="form1">ticket code: <input name="code" type="text" /><br/>ticket prize: <input name="prize" type="text" /><input name="submit" type="submit" value="submit" /></form>
<hr />
View Existing Codes:
<table width="750" border="0" cellpadding="0" cellspacing="0"><tr height="30" bgcolor="#CCCCCC" align="center"><td width="50">ID</td><td width="100">CODE</td><td width="200">PRIZE</td><td width="200">WON</td><td width="200">Do EDIT/DELETE</td></tr>
<? require("dbconn.php");
$r=mysql_query("Select * from golden_ticket order by id") or die("Query failed: " . mysql_error());
while($n=mysql_fetch_array($r)){ 
echo "<tr height='30' align='center'><td width='50'>".$n['id']." </td><td width='100'> ".$n['ticket_code']." </td><td width='200'> ".$n['ticket_prize']." </td><td width='200'> ";
if($n['ticket_won']=='Yes') { echo $n['ticket_won']." | <a href='javascript:view(".$n['id'].");'>View</a>"; 
} else { echo $n['ticket_won']; }
echo "</td><td width='200'><a href='javascript:edit(".$n['id'].");'>edit</a> | <a href='update.php?ref=".$n['id']."&refer=del'>delete</a> </td></tr>"; } ?>
</table>
<hr /><br/>
<div id="editform"></div>
</body>
</html>