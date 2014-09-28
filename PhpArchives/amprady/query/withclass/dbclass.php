<?
class mydb {
    var $servername = "localhost";
    var $dbname = "amprady_amp";
    var $uname = "amprady_amp";
    var $pwd = "abhipapa";

    function dbconn() {
        mysql_connect($this->servername,$this->uname,$this->pwd) or die("Connection Failed:".mysql_error());
        mysql_select_db($this->dbname) or die("DB Selection Failed:".mysql_error());
    }
    function get_dbname() {
        return $this->dbname;
    }

    function tables() {
        $this->dbconn();
        $i=0;
        $tabs = mysql_query("show tables") or die("Query Failed:".mysql_error());
        while($res[$i] = mysql_fetch_array($tabs)) {
            $i=$i+1;
        }
        return $res;   
    }

    function fields($table) {
        $this->dbconn();
        $j=0;
        $flds = mysql_query("Describe ".$table) or die("Query Failed:".mysql_error());
        while($rst[$j] = mysql_fetch_array($flds)) {
            $j=$j+1;
        }
        return $rst;
    }
}
?>