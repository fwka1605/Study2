module(name [,requires [,config] ]);

�Z�߂�l
Module�I�u�W�F�N�g
	
�Z����
name:���W���[����
requires:�ˑ����郂�W���[���i�z��j
		�C�ӂ����V�������W���[�����쐬����ꍇ�́A�K���w�肷��B
		�w�肷�ׂ��l���Ȃ��ꍇ�̂���̔z����w�肷��B
		�ȗ������ꍇ�͊����̃��W���[�����擾����B
config:�\���̒�`

�Z�T���v��
�V�K�Ƀ��W���[�����쐬����B
angular.module('myApp',[])
		.controller('MyController', function($scope){
			$scope.msg="����ɂ��́AAngularJS!";
		});
		
�������W���[�����擾
angular.module('myApp',[]);

angular.module('myApp')
		.controller('MyController', function($scope){
			$scope.msg="����ɂ��́AAngularJS!";
		});

�`���R�����t�@�C�����ŏ�L�̂悤�ɏ����K�v�͂Ȃ����A�A�v���̋K�͂�
	�傫���Ȃ�ƁA���W���[���錾�ƁA���̑��̃R���|�[�l���g�̐錾��
	�قȂ�t�@�C���ŊǗ��������Ƃ����P�[�X���o�Ă��܂��B���̂悤�ȏꍇ��
	�g�p���܂��B
	