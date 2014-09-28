<? include("dbclass.php");
$obj = new mydb();
session_start();
session_destroy();
	
if($_POST['memberreg'] and $_POST['name']!="" and $_POST['email']!="" and $_POST['uname']!="" and $_POST['pwd']!="" and $_POST['about']!="") {
$datas = array("NULL", $_POST['name'], $_POST['email'], $_POST['uname'], $_POST['pwd'], $_POST['about'], "No", "No");
$msg = $obj->insert("member",$datas);
echo $msg;}

if($_POST['memberlog'] and $_POST['uname1']!="" and $_POST['pwd1']!="") {
$col = array("password");
$whr = array("username='".$_POST['uname1']."'","admin='No'","accept='Yes'");
$res = $obj->select($col,"member",$whr,NULL,NULL);
if($res[0][0]!=$_POST['pwd1']) {
echo "Password Mismatch";
} else {
session_register('memname');
$_SESSION['memname'] = $_POST['uname1'];
header("location: memhome.php");
exit;
} }

if($_POST['adminlog'] and $_POST['uname2']!="" and $_POST['pwd2']!="") {
$col = array("password");
$whr = array("username='".$_POST['uname2']."'","admin='Yes'","accept='Yes'");
$res = $obj->select($col,"member",$whr,NULL,NULL);
if($res[0][0]!=$_POST['pwd2']) {
echo "Password Mismatch";
} else {
session_register('name');
$_SESSION['name'] = $_POST['uname2'];
header("location: adhome.php");
exit;
} }
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="1.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="internal.js">	</script>
<title>MEMBER RELATED DEMO</title></head>

<body>
This is a demo for Member related activities. Member login / Admin login / Member Registration.<br/><br/>
Member Login: member can login and edit his profile details.<br/>
Admin Login: web admin can login and access all member's data and admin can add new member, edit existing member's profile and delete any profile if needed.<br/>
Member Reg: Is open to all guest user of the website. Any person can register, but will have to wait for admin's approval to use the login.<br/><br/>
In this demo,
<ul><li>one can register</li>
<li>then, login as admin and approve your member registration for urself. Also try using the features in the login portal.<strong>[a sample login=&gt; username: &quot;demo&quot; | pwd: &quot;demo&quot;]</strong></li>
<li>then, after approval, u can login as a member and try editing ur oen profile<strong>[a sample login=&gt; username: &quot;memdemo&quot; | pwd: &quot;1234&quot;]</strong></li>
</ul>
<hr /><b><strong>CLICK ON THE FOLLOWING LINKS</strong></b><br />
<span onclick="toggleview('memreg');"><b><u>New Member Registration Form</u></b></span> | <span onclick="toggleview('memlog');"><b><u>Member Login</u></b></span> | <span onclick="toggleview('adlog');"><b><u>Admin Login</u></b></span>
<div id="memreg" style="display:none;"><form name="form1" id="form1" action="<? $_SERVER["PHP_SELF"]; ?>" method="post"> NAME: <input type="text" name="name" id="name" /><br/>EMAIL: <input type="text" name="email" id="email" /><br/>USERNAME: <input type="text" name="uname" id="uname" /><br/>PASSWORD: <input type="password" name="pwd" id="pwd" /><br/>ABOUT ME: <textarea name="about" cols="50" rows="3"></textarea><br/><input type="submit" name="memberreg" value="submit" /></form><hr /></div>
<div id="memlog" style="display:none;"><form name="memlog" id="memlog" action="<? $_SERVER["PHP_SELF"]; ?>" method="post"> USERNAME: <input type="text" name="uname1" id="uname1" /><br/>PASSWORD: <input type="password" name="pwd1" id="pwd1" /><br/><input type="submit" name="memberlog" value="member login" />
</form><hr /></div>
<div id="adlog" style="display:none;"><form name="adlog" id="adlog" action="<? $_SERVER["PHP_SELF"]; ?>" method="post"> USERNAME: <input type="text" name="uname2" id="uname2" /><br/>PASSWORD: <input type="password" name="pwd2" id="pwd2" /><br/><input type="submit" name="adminlog" value="admin login" />
</form><hr /></div>

</body>
</html>
