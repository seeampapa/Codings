<? 
session_start();
if(!session_is_registered('name')){ 
header("location: index.php"); 
}
$usern=$_SESSION['name'];

include("dbclass.php");
$obj = new mydb();

if($_POST['edit']) {
	$setcol = array("name","email","username","password","about","admin");
	$setval = array($_POST['name'],$_POST['email'],$_POST['uname'],$_POST['pwd'],$_POST['about'],$_POST['admin']);
	$where = array("id='".$_POST['id']."'");
	$obj->update("member",$setcol,$setval,$where);
}

if($_POST['accept']) {
	$obj->update("member",array("admin","accept"),array($_POST['admin1'],$_POST['accept1']),array("id='".$_POST['id1']."'"));
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
<div id="header" align="right">User: <? echo $usern; ?> | <a href="index.php">Logout</a><hr /></div>
<div id="hidden"></div>
<div id="content">
<table border="1" cellspacing="0" cellpadding="0">
<? $fields = $obj->fields("member");
 $op = $obj->select(NULL,"member",NULL,NULL,NULL);
 echo "<tr>";
 for($i=0;$i<count($fields)-1;$i++) {
 	echo "<td width='150'><b>".$fields[$i][0]."</b></td>"; }
 echo "</tr>"; 
 for($j=0;$j<count($op)-1;$j++) {
 	echo "<tr>";
	for($k=0;$k<count($fields)-1;$k++) {
		echo "<td width='150'>".$op[$j][$k];
		if($op[$j]['username']==$usern) {
			if($k==0)
				echo " <a href='javascript:edit(".$op[$j][$k].");'>[edit]</a> | <a href='javascript:accept(".$op[$j][$k].");'>[accept]</a> | <a href='javascript:del(".$op[$j][$k].");'>[del]</a> </td>";
			else
				echo "</td>"; 
		} else {
			if($k==0)
				echo " <a href='javascript:accept(".$op[$j][$k].");'>[accept]</a> | <a href='javascript:del(".$op[$j][$k].");'>[del]</a> </td>";
			else
				echo "</td>"; } }
	echo "</tr>"; } ?>
</table>
</div>
</body>
</html>
