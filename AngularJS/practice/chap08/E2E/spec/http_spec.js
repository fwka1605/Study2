describe('ngMockE2Eによるテスト', function() {

  beforeEach(function() {
    browser.addMockModule('httpMock', function() {
      angular.module('httpMock', [ 'ngMockE2E', 'myApp' ])
        .run(function($httpBackend) {
        $httpBackend.whenGET('http.php?name=' + encodeURI('山田'))
          .respond('こんにちは、山田さん！');
        $httpBackend.whenGET('http.php?name=').respond(500, '');
        $httpBackend.whenGET('http.php?name=' + encodeURI('wings'))
          .passThrough();
      });
    });
  });

  it('HTTP経由の通信', function() {
    browser.get('/chap05/http/http.html');

    var name = element(by.model('name'));
    element(by.buttonText('送信')).click();
    expect(element(by.binding('result')).getText())
      .toEqual('!!通信に失敗しました!!');

    name.sendKeys('山田');
    element(by.buttonText('送信')).click();
    expect(element(by.binding('result')).getText())
      .toEqual('こんにちは、山田さん！');
  });
});
