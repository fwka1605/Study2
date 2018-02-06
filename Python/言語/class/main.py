# Member.pyをインポートする
import Member

taro=Member.Member()
taro.setName("太郎")
print(taro.getName())


jiro=Member.Member("次郎")
print(jiro.getName())

print(taro.LANG)
taro.LANG="EN"
print(taro.LANG)
print(jiro.LANG)
