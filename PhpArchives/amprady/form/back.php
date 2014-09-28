<?
include("dbclass.php");
$obj = new mydb();

session_start();
if(!session_is_registered('memname')){ 
header("location: index.php"); 
}
$usern=$_SESSION['memname'];

$ref = $_GET['ref'];
$refer = $_GET['refer'];

switch ($refer) {
	case 'top':
		$op = $obj->select(array("distinct form_name"),"form",array("email='".$_SESSION['memname']."'"),NULL,NULL);
		for($i=0;$i<count($op)-1;$i++) { 
			if($op[$i][0]!="NIL") {?>
	    		<span onclick="showform('<? echo $op[$i][0]; ?>')"><? echo $op[$i][0]; ?></span><? 
			} else {
				continue;
			} ?>
            | <? } ?><span onclick="shownewform()"><b>New Form</b></span> <?
		break;
	case 'newform':
		?>
        <form name="newform" id="newform" method="post" action="<? $_SERVER['PHP_SELF'] ?>"><input type="text" name="newname" id="newname"  /><input type="submit" name="sub_newname" id="sub_newname" value="create new form" /></form>
        <?
		break;
	case 'form':
		?>
        <form name="form" id="form" method="post" action="<? $_SERVER['PHP_SELF'] ?>">Select Field: <select name="tag" id="tag"><option selected="selected" value="select">select</option><option value="text">Text Box</option><option value="submit">Button</option></select><br/>Placing Number: <input type="text" name="order" id="order" /><br/>Label: <input type="text" name="label" id="label" /><input type="hidden" name="form_name" id="form_name" value="<? echo $_GET['ref'] ?>"/><br/>name: <input type="text" name="name" id="name" /><br/>Initial Value: <input type="text" name="value" id="value" /><input type="submit" name="submit_field" id="submit_field" value="Add Field to this Form" /></form>
        <?
		$op = $obj->select(array("form_order","inp_type","inp_name","inp_value","inp_label"),"form",array("email='".$_SESSION['memname']."'","form_name='".$_GET['ref']."'"),"form_order",NULL);
		?><hr />
		<table cellpadding="0" cellspacing="0" border="0" width="600">
        <? 
		for($i=0;$i<count($op)-1;$i++) { 
			if($op[$i][1]!="NIL") {?>
        		<tr align="left" height="30"><td width="200"><? echo $op[$i][4] ?></td><td width="400"><input type="<? echo $op[$i][1] ?>" name="<? echo $op[$i][2] ?>" id="<? echo $op[$i][2] ?>" value="<? echo $op[$i][3] ?>" /></td></tr><? 
			} else {
				continue;
			} }
		?>
		</table>
        <?
        break;
	default:
		echo "ERROR";
}