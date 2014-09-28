<?
class mydb {
    var $servername;
    var $dbname;
    var $uname;
    var $pwd;
	var $selcolumn;
	var $seltable;
	var $selwhere;
	var $selorder;
	var $sellimit;
	
	function mydb () {
		$this->servername = "localhost";
		$this->dbname = "amprady_amp";
		$this->uname = "amprady_amp";
		$this->pwd = "abhipapa";
		$this->selcolumn = "*";
		$this->seltable = NULL;
		$this->selwhere = NULL;
		$this->selorder = NULL;
		$this->sellimit = NULL;
	}

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
	
	function select($selcolumn,$seltable,$selwhere,$selorder,$sellimit) {
		$this->dbconn();
		if($seltable!=NULL) {									// TABLE NAME
			if($selwhere!=NULL) {								// WHERE
				$wherecond = " WHERE ";
				for($f=0;$f<count($selwhere);$f++) {
					if($f!=count($selwhere)-1) 
						$wherecond = $wherecond . $selwhere[$f] . " and ";
					else
						$wherecond = $wherecond . $selwhere[$f];
				}
			} else {
				$wherecond = NULL;
			}
			if($selorder!=NULL)									// ORDER BY
				$order = " ORDER BY ".$selorder;
			else
				$order = NULL;
			if($sellimit!=NULL)									// LIMIT 0, 10
				$limit = " LIMIT ".$sellimit;
			else
				$limit = NULL;
			if($selcolumn!=NULL) {								// * -> COLUMN LIST
				$columnlist = "";
				for($b=0;$b<count($selcolumn);$b++) {
					if($b!=count($selcolumn)-1) 
						$columnlist = $columnlist . $selcolumn[$b] . ", ";
					else
						$columnlist = $columnlist . $selcolumn[$b];
				}
			} else {
				$columnlist = $this->selcolumn;
			}
			$k=0;
			$qrey = "SELECT ".$columnlist." FROM ".$seltable.$wherecond.$order.$limit;
			$qry = mysql_query($qrey) or die("SELECT QUERY ERROR: ".$qrey.mysql_error());
			if(mysql_affected_rows()!=0) {
			while($result[$k] = mysql_fetch_array($qry)) {
				$k=$k+1;
			} 
			return $result;
			} else {
			echo "No Records Found";
			}
		} else {
			echo "NO TABLE MENTIONED IN THE QUERY TO SELECT";
		}
	}
	
	function insert($table,$insdatas) {
		$this->dbconn();
		$tabfields = $this->fields($table);
		$nooffields = count($tabfields)-1;
		$strfield = "";
		for($a=0;$a<$nooffields;$a++) {
			if($a!=($nooffields-1)) {
				$strfield = $strfield . $tabfields[$a]['Field'] . ", ";
			} else {
				$strfield = $strfield . $tabfields[$a]['Field'];
			}
		}
		$noofdatas = count($insdatas);
		$strdatas = "";
		for($d=0;$d<$noofdatas;$d++) {
			if($d!=($noofdatas-1)) {
				$strdatas = $strdatas . "'" . $insdatas[$d] . "', ";
			} else {
				$strdatas = $strdatas . "'" . $insdatas[$d] . "'";
			}
		}
		$h=0;
		$qrry = "INSERT INTO ".$table." (".$strfield.") VALUES (".$strdatas.")";
		mysql_query($qrry) or die("INSERT QUERY ERROR: ".$qrry.mysql_error());
	}
	
	function update($table,$setcol,$setval,$wher) {
		$this->dbconn();
		if($setcol!=NULL and $setval!=NULL and (count($setcol)==count($setval))) {
			$strset = " SET ";
			for($i=0;$i<count($setcol);$i++) {
				if($i!=count($setcol)-1)
					$strset = $strset . $setcol[$i] ." = '". $setval[$i] ."', ";
				else
					$strset = $strset . $setcol[$i] ." = '". $setval[$i] ."'";
			}
		} else {
			echo "Error in Updating";
		}
		if($wher!=NULL) {								// WHERE
			$wherecon = " WHERE ";
			for($f=0;$f<count($wher);$f++) {
				if($f!=count($wher)-1) 
					$wherecon = $wherecon . $wher[$f] . " and ";
				else
					$wherecon = $wherecon . $wher[$f];
			}
		} else {
			echo "Cannot be Updated: WHERE CLAUSE IS EMPTY";
		}
		$query = "UPDATE ".$table.$strset.$wherecon;
		mysql_query($query) or die("UPDATE QUERY FAILED: ".mysql_error());
	}
	
	function delete($table,$whr) {
		$this->dbconn();
		if($whr!=NULL) {								// WHERE
			$wherecon = " WHERE ";
			for($f=0;$f<count($whr);$f++) {
				if($f!=count($whr)-1) 
					$wherecon = $wherecon . $whr[$f] . " and ";
				else
					$wherecon = $wherecon . $whr[$f];
			}
		} else {
			echo "Cannot perform DELETE: WHERE CLAUSE IS EMPTY";
		}
		mysql_query("DELETE FROM ".$table.$wherecon) or die("DELETE QUERY FAILED: ".mysql_error());
	}
	
	function fileup($fil){
		if ($_FILES[$fil]['error'] > 0) {
		  	echo "Error: " . $_FILES[$fil]['error'] . "<br />";
		} elseif($_FILES[$fil]['size'] > 5000000) {
			echo "File size limited to 5mb";
		} elseif($_FILES[$fil]['type'] != "image/jpeg" and $_FILES[$fil]['type'] != "image/png" and $_FILES[$fil]['type'] != "image/gif") {
			echo "Only JPEG, GIF, PNG files are allowed to upload";	
		} else {
			$uploaded = $_FILES[$fil]['tmp_name'];
			$fp = fopen($uploaded, 'r');
			$files = fread($fp, filesize($uploaded));
			$files = addslashes($files);
			fclose($fp);
			return $files;
		}
	}
}
?>