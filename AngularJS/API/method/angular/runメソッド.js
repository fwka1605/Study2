module([requires  ]);

�Z�߂�l
Module�I�u�W�F�N�g
	
�Z����
requires:�ˑ����郂�W���[���i�z��j
		�C�ӂ����V�������W���[�����쐬����ꍇ�́A�K���w�肷��B

�Z�T���v��
�V�K�Ƀ��W���[�����쐬����B
angular.module('myApp', [])
  .run(['$templateCache', function($templateCache) {
    $templateCache.put('templates/execution.html', '<dl><dt>�}���J�[�g</dt><dd>�ЂƂЂƂ̉����͂�����Ɖ��t����</dd><dt>�X�g�����W�F���h</dt><dd>���񂾂񂹂������</dd><dt>���K�[�g</dt><dd>���̊Ԃ�؂�ڂȂ��Ȃ߂炩�ɉ��t����</dd><dt>�g������</dt><dd>�}���ɔ������ĉ��t����</dd></dl>');
    $templateCache.put('templates/tempo.html', '<dl><dt>�A�b�`�F�������h</dt><dd>���񂾂�͂₭</dd><dt>���^���_���h</dt><dd>���񂾂񂨂���</dd><dt>�s���E ���b�\</dt><dd>���܂ł����͂₭</dd><dt>�e���| ���o�[�g</dt><dd>�͂₳���_��ɐL�k������</dd></dl>');
  }])
  .controller('MyController', ['$scope', function($scope) {
    $scope.templates = [
      { title: 'execution', url: 'templates/execution.html' },
      { title: 'tempo', url: 'templates/tempo.html' }
    ];

    $scope.onload = function() {
      console.log($scope.template);
    };
  }]);
  
run���\�b�h�́A���ׂẴ��W���[����ǂݍ��ݏI�����Ƃ���Ŏ��s����郁�\�b�h�ł��B
���̗�̂悤�ɁA�A�v���ŗ��p���郊�\�[�X������������悤�ȗp�r�ŗ��p���܂��B
	
