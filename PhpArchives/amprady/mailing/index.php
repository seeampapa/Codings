<? $msg ="";
if($_POST['send'] and $_POST['name']!="" and $_POST['toemail']!="" and $_POST['mess']!="") {
	$to = $_POST['toemail'];
	$subject = "testing mail - DEMO";
	$message = "Your Name: ".$_POST['name']."\n Message: ".$_POST['mess'];
	mail($to,$subject,$message);
	$msg = "Mail sent successfully"; }
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MAILING DEMO</title>
</head>
<body>
<table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
<form action="<? $_SERVER['PHP_SELF']; ?>" method="post" name="form1" id="form1">
  <tr>
    <td height="40" colspan="2"><div align="center"><strong>Demo Mail Form</strong><? echo $msg; ?></div></td>
    </tr>
  <tr><td width="250">Name:</td><td width="450" height="40"><input type="text" name="name" id="name" /></td></tr>
  <tr><td width="250">Your Email ID:</td><td width="450" height="40"><input type="text" name="toemail" id="toemail" /></td></tr>
  <tr><td width="250">Message to Send:</td>
    <td width="450" height="40"><textarea name="mess" id="mess" cols="45" rows="3"></textarea></td>
  </tr>
  <tr><td width="250">&nbsp;</td><td width="450" height="40"><input type="submit" name="send" value="send mail" /></td></tr></form>
</table>
</body>
</html>
