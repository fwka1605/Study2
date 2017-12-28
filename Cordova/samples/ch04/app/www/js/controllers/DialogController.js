(function(){
    var module = angular.module('cdv.dialog',[]);

    function DialogController($scope){

        $scope.alert = function(){
            navigator.notification.alert(
                'ご注意下さい',
                function(){
                    console.log("pressed alert");
                },
                'アラート',
                'OK'
            );
        };

        $scope.confirm = function(){
            navigator.notification.confirm(
                'ご確認下さい',
                function(buttonIndex){
                    // buttonIndexに押されたボタンのインデックス（1〜)
                    console.log("button [" + buttonIndex + "] pressed");
                },
                'ご注意',
                ['OK','CANCEL']
            );
        };

        $scope.prompt = function(){
            navigator.notification.prompt(
                '入力してください',
                function(results){
                    // buttonIndexに押されたボタンのインデックス（1〜)とinput1に入力値
                    console.log("button [" + results.buttonIndex + "] pressed , input value is " + results.input1);
                },
                '郵便番号',
                ['OK','CANCEL'],
                '000-0000'
            );
        }

        $scope.beep = function(){
            console.log("beep ....");
            navigator.notification.beep(3);
        }


    };
    module.controller('DialogController',['$scope',DialogController]);
}());
