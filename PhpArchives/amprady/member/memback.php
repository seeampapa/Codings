<? 
session_start();
if(!session_is_registered('memname')){ 
header("location: index.php"); 
}
$usern=$_SESSION['memname'];

include("dbclass.php");
$obj = new mydb();

$ref = $_GET['ref'];
$refer = $_GET['refer'];

switch ($refer) {
	case 'memedit':
		$fld = array("id","name","email","username","password","about");
		$op = $obj->select($fld,"member",array("username='".$ref."'"),NULL,NULL); ?>
		<form action="<? $_SERVER['PHP_SELF']; ?>" method="post" name="mform1">
        <input type="hidden" name="id" value="<? echo $op[0][0] ?>" />
        Name: <input type="text" name="mname" id="mname" value="<? echo $op[0][1]; ?>" /><br/>
        Email: <input type="text" name="memail" id="memail" value="<? echo $op[0][2]; ?>" /><br/>
        Username: <input type="text" name="muname" id="muname" value="<? echo $op[0][3]; ?>" /><br/>
        Password: <input type="password" name="mpwd" id="mpwd" value="<? echo $op[0][4]; ?>" /><br/>
        About Me: <input type="text" name="mabout" id="mabout" value="<? echo $op[0][5]; ?>" /><br/>
        <input type="submit" name="memedit" value="submit">
        </form><br/><hr/><?
		break;
	default:
		echo "ERROR OCCURED";
}