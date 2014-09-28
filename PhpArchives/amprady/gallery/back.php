<?
include("dbclass.php");
$obj = new mydb();

$ref = $_GET['ref'];
$refer = $_GET['refer'];

switch ($refer) {
	case 'form':
		?><form id="form1" name="form1" method="post" enctype="multipart/form-data" action="<? $_SERVER["PHP_SELF"]; ?>">
      	Choose Album: 
      	<select name="listalbum" id="listalbum" onchange="chklist();">
        <option value="select" selected="selected">Select</option>
        <? $n = $obj->select(array("distinct album_name"),"gallery",NULL,NULL,NULL);
		for($i=0;$i<count($n)-1;$i++) {
        echo "<option value=".$n[$i][0].">".$n[$i][0]."</option>"; }
		?><option value="New">New Album</option></select>
      	<input type="text" name="album" id="album" style="visibility: hidden"/><br/><br/>
        Photo name: <input type="text" name="pname" id="pname" /><br/><br/>
        Choose Photo: <input name="photo" type="file" /><br/><br/><input name="submit" type="submit" value="submit"/>
    	</form> | <span onclick="showmenu()"><b>Back to Album List</b></span><hr /><?
		break;
	case 'show':
		?> | <? $n = $obj->select(array("id","photo_name"),"gallery",array("album_name='".$_GET['ref']."'"),NULL,NULL);
	    for($i=0;$i<count($n)-1;$i++) { ?>
    	<span onclick="showpic('<? echo $n[$i][0]; ?>')"><? echo $n[$i][1]; ?></span> | <? } ?><span onclick="form()"><b>Upload New Photo</b></span> | <span onclick="showmenu()"><b>Back to Album List</b></span>
		<?
		break;
	case 'showpic': ?>
		<img src="picdisp.php?id=<? echo $_GET['ref']; ?>" /><?
		break;
	case 'menu':
        ?> | <? $n = $obj->select(array("distinct album_name"),"gallery",NULL,NULL,NULL);
	    for($i=0;$i<count($n)-1;$i++) { ?>
    	<span onclick="showalbum('<? echo $n[$i][0]; ?>')"><? echo $n[$i][0]; ?></span> | <? } ?><span onclick="form()"><b>Upload New Photo</b></span> |
        <? break;
		default:
		echo "ERROR";
} 
?>