# タプルの生成
key1=('まさる','10-18')
key2=('まなぶ','05-01')
key3=('まさる','10-18')

# 辞書の生成
dict = {key1:38,key2:25}

print(dict)
print(dict[key1])
print(dict[key2])
print(dict[key3])


# 関数から複数の戻り値を返す場合
def getABC():
      return ('A','B','C')

abc = getABC()
(a,b,c) = getABC()

print(abc)
print(a)
print(b)
print(c)

