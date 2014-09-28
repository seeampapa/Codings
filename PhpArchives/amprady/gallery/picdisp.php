<? 	include("dbclass.php");
	$obj = new mydb();
	include("fileclass.php");
	$ob = new myfiles();
	$n = $obj->select(array("photo","type"),"gallery",array("id='".$_GET['id']."'"),NULL,NULL);
	$newim = $ob->resizeimage($n[0][0],1050,600);
		switch($n[0][1]) {
			case 'image/jpeg':
				header('Content-type: image/jpeg');
				imagejpeg($newim, null);
				break;
			case 'image/gif':
				header('Content-type: image/gif');
				imagegif($newim, null);
				break;
			case 'image/png':
				header('Content-type: image/png');
				imagepng($newim, null);
				break;
			default:
				echo "NONE";
		}
	exit; ?>