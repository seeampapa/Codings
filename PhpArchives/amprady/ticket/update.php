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
	<form action="<? $_SERVER["PHP_SELF"]; ?>" method="post" name="form2">ticket code: <input name="code2" type="text" value="<? echo $n['ticket_code']; ?>" /><br/>ticket prize: <input name="prize2" type="text" value="<? echo $n['ticket_prize']; ?>" /><input name="won2" type="hidden" value="<? echo $n['ticket_won']; ?>" /><input name="id2" type="hidden" value="<? echo $n['id']; ?>" /><input name="edit" type="submit" value="edit" id="edit" />
	</form>
<? break;
case 'view':
	require("dbconn.php");
	$r=mysql_query("Select * from won_ticket where ticket_id='".$_GET['ref']."'") or die("Query failed: " . mysql_error());
	$n=mysql_fetch_array($r); 
	echo "<b>Name: </b>".$n['name']."<br/><br/><b>Email: </b>".$n['email']."<br/><br/><b>Address: </b><br/>".$n['address'];
	$rt=mysql_query("Select * from golden_ticket where id='".$_GET['ref']."'") or die("Query failed: " . mysql_error());
	$nt=mysql_fetch_array($rt); 
	echo "<br/><br/><b>Used Code: </b>".$nt['ticket_code']."<br/><br/><b>Prize won: </b>".$nt['ticket_prize'];
	break;
default:
echo "error occurs! Please try again";
} ?>