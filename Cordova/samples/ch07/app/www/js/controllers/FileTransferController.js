(function () {

	function FileDownloadController($scope) {

		$scope.download = function() {

			var fileTransfer = new FileTransfer();
			var url = encodeURI("http://192.168.1.7:8080/cdv7/images/img.png");

			fileTransfer.download(
				url,
				"cdvfile://localhost/persistent/img.png",
				function(entry){
					// FileEntry
					$scope.$apply(function(){
						$scope.img_path = "cdvfile://localhost/persistent/img.png";
					});
				},
				function(error){
					console.log("=== ERROR ===",error);
					alert('ERROR (' + error.code + ')');
				}
			);

			fileTransfer.onprogress = function(event){
				if(event.lengthComputable){
					$scope.$apply(function() {
						$scope.progress = "loaded :" + event.loaded + "/" + event.total;
					});
				}
			}
		};
	}

	/**
	 * アップロード処理
	 * @param $scope
	 * @constructor
	 */
	function FileUploadController($scope) {

		$scope.upload = function() {

			var fileTransfer = new FileTransfer();
			var url = encodeURI("http://192.168.1.7:8080/cdv7/put.php");

			var options = new FileUploadOptions();
			options.fileKey  = "image";
			options.fileName = "sample.png";
			options.mimeType = "image/png";

			fileTransfer.upload(
				cordova.file.applicationDirectory + "www/img/upload.png",
				url,
				function(result){
					console.log("upload ",result);
					var body = result.response;
					if(result.response) {
						var ret = JSON.parse(body);
						console.log("response ",ret);
						var message = ret.message;
						$scope.$apply(function(){
							$scope.message = ret.message;
						});
					}
				},
				function(error){
					console.log("=== ERROR ===",error);
					alert('ERROR (' + error.code + ')');
				},
				options
			);
			fileTransfer.onprogress = function(event){
				if(event.lengthComputable){
					$scope.$apply(function(){
						$scope.progress = "uploaded :" + event.loaded + "/" + event.total;
					});
				}
			}
		};
	}

	var module = angular.module('cdv.file.transfer.controllers', []);
	module.controller('FileDownloadController', ['$scope', FileDownloadController]);
	module.controller('FileUploadController',['$scope',FileUploadController]);
}());
