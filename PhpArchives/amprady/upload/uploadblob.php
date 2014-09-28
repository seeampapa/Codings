<?
$fileName = $_FILES['userfile']['name'];
$tmpName  = $_FILES['userfile']['tmp_name'];
$fileSize = $_FILES['userfile']['size'];
$fileType = $_FILES['userfile']['type'];

$fp      = fopen($tmpName, 'r');
$content = fread($fp, filesize($tmpName));
$content = addslashes($content);
fclose($fp);

require("dbconn.php");
$query = "INSERT INTO upload (`filedisp`, `fileb`, `filebname`, `filebtype`, `filebsize`) "."VALUES ('$_POST[filedisp]', '$content', '$fileName', '$fileType', '$fileSize')";
mysql_query($query) or die('Error, query failed'); 
echo "<br>File ".$fileName." uploaded<br>";
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>

<form method="post" enctype="multipart/form-data" action="$_SERVER['PHP_SELF']">
<table width="350" border="0" cellpadding="1" cellspacing="1" class="box">
<tr> 
<td width="246">
<input name="userfile" type="file" id="userfile"> <input name="filedisp" type="text" /></td><td width="80"><input name="upload" type="submit" class="box" id="upload" value=" Upload "></td>
</tr>
</table>
</form>

</body>
</html>