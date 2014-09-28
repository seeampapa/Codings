<? include("dbclass.php");
$obj = new mydb();

if($_POST['submit'] and $_POST['pname']!="" and $_POST['listalbum']!="select") { 
	if($_POST['listalbum']!="New") {
		$album = $_POST['listalbum'];
	} else {
		$album = $_POST['album']; }
	$file = $obj->fileup("photo");
	if($file and $album) {
		$msg = $obj->insert("gallery",array("NULL",$album,$_POST['pname'],$file,$_FILES['photo']['type'])); 
    }
	echo $msg;
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" type="text/javascript" src="internal.js">	</script>
<link href="1.css" rel="stylesheet" type="text/css" />
<title>Photo Gallery 1</title>
</head>
<body onload="showmenu()">
<table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr><td><div id="menu" align="left"></div><hr /></td></tr>
</table>
<div id="show" align="center"></div>
</body>
</html>