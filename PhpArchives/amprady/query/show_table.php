<?php
/* You should implement error checking, but for simplicity, we avoid it here */
require("dbconn.php");
$r=mysql_query("Describe ".$_GET['ref']) or die("Query failed: " . mysql_error());
while($n=mysql_fetch_array($r)){ 
echo $n['Field'];
echo "  |  ".$n['Type'];
echo "<br/>";}
?>