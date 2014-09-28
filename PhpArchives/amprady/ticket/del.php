<? switch($_GET['refer']) {
case 'del':
	require("dbconn.php");
	mysql_query("DELETE FROM golden_ticket WHERE id='".$_GET['ref']."'") or die("Query failed: " . mysql_error()); 
	header("location: createticket.php");
	break;
case 'edit':
	require("dbconn.php");
	$r=mysql_query("Select * from golden_ticket where id='".$_GET['ref']."'") or die("Query failed: " . mysql_error());
	$n=mysql_fetch_array($r); ?>
	<form action="<? $_SERVER["PHP_SELF"]; ?>" method="post" name="form2">ticket code: <input name="code2" type="text" value="<? echo $n['ticket_code']; ?>" /><br/>ticket prize: <input name="prize2" type="text" value="<? echo $n['ticket_prize']; ?>" /><input name="edit" type="submit" value="edit" id="edit" />
	</form>
<? break;
default:
echo "error occurs! Please try again";
} ?>