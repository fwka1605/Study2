// jQuery�̏���������
$(function(){
    // �{�^���n���h��
    $("#random-color").on("click", function(){
        // �w�i�F��ύX
        randomBackColor();
    });
    
    /**
     * �w�i�F��ύX
     */
    var randomBackColor = function(){
        // RGB�������_���ɐ���
        var randomRed   = Math.floor(Math.random() * 255);
        var randomGreen = Math.floor(Math.random() * 255);
        var randomBlue  = Math.floor(Math.random() * 255);
        
        // �w�i�F��CSS�ݒ�l�𐶐�
        var cssBackground 
        = "rgb(" + randomRed + "," + randomGreen + "," + randomBlue + ")";
        
        // �w�i�F��ݒ�
        $("body").css("background-color", cssBackground);
    };
});