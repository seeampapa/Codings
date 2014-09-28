<? 
session_start();
if(!session_is_registered('memname')){ 
header("location: index.php"); 
}
$usern=$_SESSION['memname'];

include("dbclass.php");
$obj = new mydb();

if($_POST['memedit']) {
	$setcol = array("name","email","username","password","about",);
	$setval = array($_POST['mname'],$_POST['memail'],$_POST['muname'],$_POST['mpwd'],$_POST['mabout']);
	$where = array("id=".$_POST['id']);
	$obj->update("member",$setcol,$setval,$where);
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" type="text/javascript" src="internal.js">	</script>
<title>MEMBER RELATED DEMO</title>
</head>
<body>
<div id="header" align="right">User: <? echo $usern; ?> | <a href="javascript:memedit('<? echo $usern; ?>');">edit profile</a> | <a href="index.php">Logout</a><hr /></div>
<div id="content">
<table width="300" border="1" cellspacing="0" cellpadding="0">
<? $op = $obj->select(array("name","email","about"),"member",array("username='".$usern."'"),NULL,NULL); ?>
<tr><td width="100">Name</td><td width="200"><? echo $op[0][0]; ?></td></tr><tr><td width="100">Email</td><td width="200"><? echo $op[0][1]; ?></td></tr><tr><td width="100">About Me</td><td width="200"><? echo $op[0][2]; ?></td></tr></table>
</div>
<div id="hidden"></div>
</body>
</html>
