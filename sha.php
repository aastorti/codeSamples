
<!--	Author: Anthony Storti
		Date:	December 1, 2019
		File:	sha.php
		Purpose:Take user input and based on size load sha file into HashTable then search for user input. Return whether the value is found
-->
<html>
<head>
	<title>Final Part 2</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>
<body>
<?php
    $input = $_POST['data'];
    $iSize = strlen($input);
    function checkFor($arr,$inp){
        print("<pre>");
        print_r("Searching for:".$inp);
        print("</pre>");
      if(array_key_exists($inp,$arr)){
        print("<pre>");
        print_r("Found, Plain Text = ".($arr[$inp]));
        print("</pre>");
        }
      else{
        print("<pre>");
        print_r("! Plain text not found of Server");
        print("</pre>");
    }
  }
$passFile =fopen("sha1_list.txt","r");

        while (!feof($passFile)) {
          $pass = fgets($passFile); //read a name (one line)
          $pass = str_replace(array("\n", "\r"), '', $pass);  //remove newlines
          $hashPass = explode(":",$pass);
          if(!feof($passFile)) {
            $checkMe[$hashPass[1]] = $hashPass[0];
                }
              }
fclose($passFile);
$passFile =fopen("sha224_list.txt","r");

        while (!feof($passFile)) {
          $pass = fgets($passFile); //read a name (one line)
          $pass = str_replace(array("\n", "\r"), '', $pass);  //remove newlines
          $hashPass = explode(":",$pass);
          if(!feof($passFile)) {
              $checkMe[$hashPass[1]] = $hashPass[0];
          }
        }
fclose($passFile);
$passFile =fopen("sha256_list.txt","r");

        while (!feof($passFile)) {
            $pass = fgets($passFile); //read a name (one line)
            $pass = str_replace(array("\n", "\r"), '', $pass);  //remove newlines
            $hashPass = explode(":",$pass);
            if(!feof($passFile)) {
                $checkMe[$hashPass[1]] = $hashPass[0];
              }
            }
fclose($passFile);
checkFor($checkMe, $input);
?>
<form action = "sha.php" method = "post" >

  <p>Search For another Hash:
    <input type = "text" size = "70" name = "data">
  </p>
  <p><input type = "submit" value = "Get Results">
  </form>
</body>
</html>
