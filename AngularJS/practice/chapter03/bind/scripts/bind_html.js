angular.module('myApp', [ 'ngSanitize' ])
  .controller('MyController', [ function() {
    this.memo = '<p onmouseover="alert(\'OK!\')">ようこそ</p>'
                  + '<a href="http://www.wings.msn.to">WINGSへ</a>'
                  + '<script>var x = 1;</script>'
                  + '<button>応募</button>';
  }]);
