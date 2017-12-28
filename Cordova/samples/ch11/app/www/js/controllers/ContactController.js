(function(){
    var module = angular.module('cdv.contact.controllers',[]);

    function ContactListController($scope,$state){

        function onSuccess(contacts){

            var list = [];
            for(var i = 0; i < contacts.length; i++){
                var item = contacts[i];
                var _item = {};
                //  表示名
                if(item.displayName){
                    // iOSではnullが返る
                    _item.displayName = item.displayName;
                }
                else if(item.name && item.name.formatted){
                    _item.displayName = item.name.formatted;
                }
                else{
                    _item.displayName = "-";
                }

                // メールアドレス
                if(item.emails && item.emails.length > 0 ){
                    _item.email = item.emails[0].value;
                }
                else{
                    _item.email = "-";
                }

                //  アイコン
                if(item.photos && item.photos.length > 0){
                    _item.photo = item.photos[0].value;
                }
                else{
                    _item.photo = null;
                }

                _item.origin = item;

                list.push(_item);
            }

            $scope.$apply(function(){
                $scope.list = list;
            });
        };

        function onError(err){
            window.alert("Error : " + err.code);
        };

        //  すべて表示
        var fields       = ["displayName"];
        var options = new ContactFindOptions();
        options.multiple = true;

        function findList(){
            navigator.contacts.find(
                fields,
                onSuccess,
                onError,
                options
            );
        };
        findList();

        $scope.select = function(item){
            if(item.email ){
                $state.go('info',{
                    id : item.origin.id
                });
            }

        }
    };

    function InfoContactController($scope,$state,$stateParams){

        $scope.found = false;

        var id = $stateParams['id'];
        if(id){

            var fields       = [navigator.contacts.fieldType.id];
            var options = new ContactFindOptions();
            options.filter = id;
            options.multiple = false;

            navigator.contacts.find(
                fields,
                function(contacts){
                    if(contacts && contacts.length > 0) {
                        var item = contacts[0];
                        console.log(item);
                        $scope.$apply(function () {
                            $scope.model = {
                                'displayName': item.displayName,
                                'familyName': item.name.familyName,
                                'givenName': item.name.givenName
                            };

                            if (item.emails && item.emails.length > 0) {
                                $scope.model.email = item.emails[0].value;
                            }
                            if (item.phoneNumbers && item.phoneNumbers.length > 0) {
                                $scope.model.phone = item.phoneNumbers[0].value;
                            }

                            $scope.model.origin = item;
                            $scope.found = true;
                        });
                    }
                },
                function(err){},
                options
            );

        }

        $scope.updateContact = function(){

            if(!$scope.form.$invalid) {

                var item = $scope.model.origin;

                item.displayName = $scope.model.displayName;
                var name = new ContactName($scope.model.familyName + " " + $scope.model.givenName, $scope.model.familyName, $scope.model.givenName);
                item.name = name;

                var emails = [];
                emails[0] = new ContactField('other', $scope.model.email);
                item.emails = emails;

                var phoneNumbers = [];
                phoneNumbers[0] = new ContactField('mobile', $scope.model.phone);
                item.phoneNumbers = phoneNumbers;

                item.save(function () {
                    $scope.$apply(function () {
                        $state.go('list');
                    });
                });
            }
        };

        $scope.deleteContact = function(){
            if($scope.model) {
                var _item = $scope.model.origin;
                _item.remove(function () {
                    $scope.$apply(function () {
                        $state.go('list');
                    });

                }, function (err) {
                    console.log(err);
                });
            }
        }

    };

    function AddContactController($scope){

        $scope.error = false;
        $scope.add = false;

        $scope.create = function(){

            if($scope.form.$invalid){
                $scope.error = true;
                return;
            }
            else{
                $scope.error = false;
            }

            var item = navigator.contacts.create({
                "displayName" : $scope.model.displayName
            });

            var name = new ContactName($scope.model.familyName + " " + $scope.model.givenName,$scope.model.familyName,$scope.model.givenName);
            item.name = name;

            var emails = [];
            emails[0] = new ContactField('other',$scope.model.email);
            item.emails = emails;

            var phoneNumbers = [];
            phoneNumbers[0] = new ContactField('mobile',$scope.model.phone);
            item.phoneNumbers = phoneNumbers;

            item.save(function(){
                $scope.$apply(function() {
                    $scope.add = true;
                    $scope.model = {};
                });
            },
            function(err){
                $scope.$apply(function() {
                    $scope.error = true;
                });
            });
        }
    }

    function PickContactController($scope){

        $scope.found = false;

        $scope.pick = function(){
            navigator.contacts.pickContact(function(item){
                $scope.$apply(function(){
                    $scope.model = {
                        'displayName' : item.displayName,
                        'familyName'  : item.name.familyName,
                        'givenName'   : item.name.givenName
                    };

                    if(item.emails && item.emails.length > 0){
                        $scope.model.email = item.emails[0].value;
                    }
                    if(item.phoneNumbers && item.phoneNumbers.length > 0){
                        $scope.model.phone = item.phoneNumbers[0].value;
                    }

                    $scope.model.origin = item;
                    $scope.found = true;
                });
            },
            function(err){
                $scope.$apply(function(){
                   $scope.found = false;
                });
                console.log(err);
            });
        };


    }

    module.controller('ContactListController',['$scope','$state',ContactListController]);
    module.controller('InfoContactController',['$scope','$state','$stateParams',InfoContactController]);
    module.controller('AddContactController',['$scope',AddContactController]);
    module.controller('PickContactController',['$scope',PickContactController]);
}());
