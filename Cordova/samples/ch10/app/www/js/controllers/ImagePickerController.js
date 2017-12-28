(function(){
    var module = angular.module('cdv.picker.controllers',[]);
    function ImagePickerController($scope){

        $scope.message = "";

        $scope.load = function(){
            plugins.imagePicker.getPictures(
                function(results) {

                    if(results.length == 0){
                        //  (1) キャンセルされたということ
                    }
                    else {
                        $scope.$apply(function () {
                            $scope.results = results;
                        });
                    }
                }, function (error) {
                    $scope.$apply(function () {
                        $scope.message = error;
                    });
                },{
                    maximumImagesCount: 3,
                }
            );
        };

    };
    module.controller('ImagePickerController',['$scope',ImagePickerController]);
}());