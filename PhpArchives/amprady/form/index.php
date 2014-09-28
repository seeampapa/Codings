<? include("dbclass.php");
$obj = new mydb();
session_start();
session_destroy();

if($_POST['new'] and $_POST['email']!="") {
	$op = $obj->select(NULL,"form",array("email='".$_POST['email']."'"),NULL,NULL);
	if($op) {
		echo "User with same Email id already exist";
	} else {
		$obj->insert("form",array("NULL",$_POST['email'],"NIL","NIL","NIL","NIL","NIL","NIL"));
		session_register('memname');
		$_SESSION['memname'] = $_POST['email'];
		header("location: land.php");
		exit;
	}
}

if($_POST['return'] and $_POST['email']!="") {
	$op = $obj->select(NULL,"form",array("email='".$_POST['email']."'"),NULL,NULL);
	if($op) {
		session_register('memname');
		$_SESSION['memname'] = $_POST['email'];
		header("location: land.php");
		exit;
	} else {
		echo "No User with such email id is existing";
	}
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
<table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
<form name="form1" id="form1" action="<? $_SERVER['PHP_SELF'] ?>" method="post">
  <tr>
    <td width="200">Username (Email Id)</td>
    <td width="400" height="40"><input type="text" name="email" id="email" /></td>
  </tr>
  <tr>
    <td width="200" align="center" valign="middle"><input type="submit" name="return" id="return" value="Returning User &gt; edit or create form" /></td>
    <td width="400" height="40" align="left" valign="middle"><input type="submit" name="new" id="new" value="New User &gt; Click &amp; Create form" /></td>
  </tr>
 </form>
</table>
</body>
</html>
