<?php
if(isset($_FILES['image'])) {
    $ret = array();
    $ret['file'] = $_FILES['image'];
    $ret['message'] = "Upload OK";
    print json_encode($ret);
}
else{
    $ret = array();
    $ret['message'] = "Image Not Found";
    print json_encode($ret);
}
?>