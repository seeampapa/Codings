<?php
/* You should implement error checking, but for simplicity, we avoid it here */
require("dbclass.php");
$obj = new mydb();
$res = $obj->fields($_GET['ref']);
for($p=0;$p<count($res)-1;$p++) {
echo $res[$p]['Field'];
echo "  |  ".$res[$p]['Type']." | ".$res[$p]['Extra'];
echo "<br/>";
}
?>