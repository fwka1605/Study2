class Member:
      #クラス変数
      LANG ='JP'

      #コンストラクタ
      def __init__(self,name=""):
            self.name = name
            
      #getter
      def getName(self):
            return self.name

      #setter
      def setName(self,name):
            self.name=name

