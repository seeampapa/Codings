<?
if($_POST['Submit'] and $_POST['query']!="") {
require("dbconn.php");
mysql_query($_POST['query']) or die("Query failed: " . mysql_error());
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="1.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="internal_request.js">	</script>
<title>MySQL Query Editor</title>
</head>
<body>
<table width="700" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>Query Box:</td>
  </tr>
  <tr>
    <td align="center" valign="middle" >
    <form id="form1" name="form1" method="post" action="<? $_SERVER["PHP_SELF"]; ?>">
      <textarea name="query" id="query" cols="90" rows="5"></textarea><br/>
      <input name="Submit" type="submit" value="Submit" />
    </form>    </td>
  </tr>
  <tr>
    <td> | <?
	 require("dbconn.php");
	 $rt=mysql_query("Show Tables") or die("Query failed: " . mysql_error());
	 while($nt=mysql_fetch_array($rt)){ ?>
     <span onclick="mouseOver('<? echo $nt['Tables_in_amprady_amp']; ?>')"><? echo $nt['Tables_in_amprady_amp']; ?></span> | 
	 <? }
	?></td>
  </tr>
  <tr>
    <td>
    <hr /><br/>
    <div id="show" align="left">
       hi all.... Default Content....
    </div>
    </td>
  </tr>
</table>
</body>
</html>