config([requires ]);

�Z�߂�l
Module�I�u�W�F�N�g
	
�Z����
name:���W���[����
requires:�ݒ肷��v���o�C�_�[

�Z�T���v��
angular.module('myApp', [])
  .config(['$sceDelegateProvider',function($sceDelegateProvider){
  	$sceDelegateProvider.resourceUrlWhitelist([
  		'self',
  		'http://www.wings.msn.to/**'
  	]);	
  }])
  .controller('MyController', ['$scope', function($scope) {
    $scope.url = 'http://www.wings.msn.to/';
  }]);
  
$sceDelegateProvider�Ɍ��炸�A�S�Ẵv���o�C�_�[�́Acontroller�̔z���ł͂Ȃ��A
config���\�b�h�͈ȉ��Őݒ肵�Ȃ���΂Ȃ�Ȃ��_�Œ��ӂ��Ă��������B
	
config���\�b�h�́A�T�[�r�X�̃C���X�^���X�����������O�ɌĂяo����郁�\�b�h��
�Ȃ�܂��B�@���̂��߁A�v���o�C�_�[�́A���̐�����A�T�[�r�X���Ăяo�����O��
�������I���Ă��Ȃ���΂Ȃ�܂���B
	
		