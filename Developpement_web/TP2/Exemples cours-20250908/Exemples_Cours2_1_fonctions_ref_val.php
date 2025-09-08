
<?php
	function testByVal($var) {
	  $var++;
	}

	function testByRef(&$var) {
	  $var++;
	}

	$a=5;
	testByVal ($a);
	echo "Test ByVal ".$a."<br/>";

	$a=5;
	testByRef ($a);
	echo "Test ByRef ".$a."<br/>";

?>
