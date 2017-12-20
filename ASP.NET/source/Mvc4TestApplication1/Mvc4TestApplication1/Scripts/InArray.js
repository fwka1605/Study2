
/*
//  インテリセンス機能を有効化
/// <reference path="jquery-1.4.4-vsdoc.js" />
/// <reference path="jquery.validate-vsdoc.js" />
/// <reference path="jquery.validate.unobtrusive.min.js" />

//  inarray検証をjQuery Validationに登録
$.validator.addMethod('inarray',
  function (value, element, param) {

      // 入力値が空の場合は検証をスキップ
      value = $.trim(value);
      if (value === '') {
          return true;
      }

      // カンマ区切りテキストを分解し、入力値valueと比較
      if ($.inArray(value, param.split(',')) === -1) {
          return false;
      }
      return true;
  });

//  inarray検証と、そのパラメータoptsを登録
$.validator.unobtrusive.adapters.addSingleVal('inarray', 'opts');
*/

