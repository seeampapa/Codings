<? include("dbclass.php");
$obj = new mydb();

session_start();
if(!session_is_registered('memname')){ 
header("location: index.php"); 
}
$usern=$_SESSION['memname'];

if($_POST['submit_field'] and $_POST['tag']!="select" and $_POST['order']!="" and $_POST['name']!="" and $_POST['label']!="") {
	$obj->insert("form",array("NULL",$usern,$_POST['form_name'],$_POST['order'],$_POST['tag'],$_POST['name'],$_POST['value'],$_POST['label']));
	?>
    <script type="text/javascript">showform('<? echo $_POST['form_name'] ?>');</script>
    <?
}

if($_POST['sub_newname'] and $_POST['newname']!="") {
	$obj->insert("form",array("NULL",$usern,$_POST['newname'],"NIL","NIL","NIL","NIL","NIL"));
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" type="text/javascript" src="internal.js">	</script>
<title>Untitled Document</title>
</head>

<body onload="showtop();">
<? echo $usern; ?><hr />
<div id="top"></div>
<div id="form"></div>
</body>
</html>