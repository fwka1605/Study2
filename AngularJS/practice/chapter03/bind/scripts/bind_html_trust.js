angular.module('myApp', [  ])
  .controller('MyController', [ '$sce',function($sce) {
    this.memo = '<p onmouseover="alert(\'OK!\')">ようこそ</p>'
                  + '<a href="http://www.wings.msn.to">WINGSへ</a>'
                  + '<script>var x = 1;</script>'
                  + '<button>応募</button>';
    this.memo=$sce.trustAsHtml(this.memo);
  }]);
