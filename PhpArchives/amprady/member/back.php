<? 
session_start();
if(!session_is_registered('name')){ 
header("location: index.php"); 
}
$usern=$_SESSION['name'];

include("dbclass.php");
$obj = new mydb();

$ref = $_GET['ref'];
$refer = $_GET['refer'];

switch ($refer) {
	case 'edit':
		$fld = array("name","email","username","password","about","admin");
		$op = $obj->select($fld,"member",array("id='".$ref."'"),NULL,NULL);
		if($usern!=$op[0]['username']) {
			echo "ERROR! DO NOT TRY TO USE JS ADVANTAGE.";
		} else { ?>
		<form action="<? $_SERVER['PHP_SELF']; ?>" method="post" name="form1">
        <input type="hidden" name="id" value="<? echo $ref; ?>" />
        Name: <input type="text" name="name" id="name" value="<? echo $op[0][0]; ?>" /><br/>
        Email: <input type="text" name="email" id="email" value="<? echo $op[0][1]; ?>" /><br/>
        Username: <input type="text" name="uname" id="uname" value="<? echo $op[0][2]; ?>" /><br/>
        Password: <input type="password" name="pwd" id="pwd" value="<? echo $op[0][3]; ?>" /><br/>
        About Me: <input type="text" name="about" id="about" value="<? echo $op[0][4]; ?>" /><br/>
        Admin Access: <input type="text" name="admin" id="admin" value="<? echo $op[0][5]; ?>" /><br/>
        <input type="submit" name="edit" value="submit">
        </form><br/><hr/><? }
		break;
	case 'accept':
		$fld = array("admin","accept");
		$op = $obj->select($fld,"member",array("id='".$ref."'"),NULL,NULL); ?>
		<form action="<? $_SERVER['PHP_SELF']; ?>" method="post" name="form2">
        <input type="hidden" name="id1" value="<? echo $ref; ?>" />
        Admin Access: <input type="text" name="admin1" id="admin1" value="<? echo $op[0][0]; ?>" /><br>
        Accept: <input type="text" name="accept1" id="accept1" value="<? echo $op[0][1]; ?>" /><br>
        <input type="submit" name="accept" value="submit">
        </form><hr /><br/><?
		break;
	case 'del':
        $obj->delete("member",array("id='".$ref."'"));
		header("location: adhome.php");
		exit;
		break;
	default:
		echo "ERROR";
} ?>