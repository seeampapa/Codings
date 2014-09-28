<?
class myfiles {
	
	function resizeimage($fil,$dx,$dy) {
		$im = imagecreatefromstring($fil);
		$x = imagesx($im);
		$y = imagesy($im);
		if($x>=$dx) {
			$ox=$dx;
			$oy=$dx*$y/$x;
		} else {
			$ox=$x;
			$oy=$y;
		}
		if($oy>=$dy) {
			$opy=$dy;
			$opx=$dy*$ox/$oy;
		} else {
			$opy=$oy;
			$opx=$x;
		}
		$new = imagecreatetruecolor($opx, $opy);
		imagecopyresampled($new, $im, 0, 0, 0, 0, $opx, $opy, $x, $y);
		imagedestroy($im);
		return $new;
	}
}
?>