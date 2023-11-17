chdir('/');
$dirContents = scandir(getcwd());
foreach($dirContents as $item) {
echo "$item\n";
} /*i_am_on_the_guestlist*/
