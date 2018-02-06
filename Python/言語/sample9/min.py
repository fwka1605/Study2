
# 数値
print("1,2,3,4,5")
print("min",end="=")
print(min(1,2,3,4,5))
print("max",end="=")
print(max(1,2,3,4,5))
print()

#文字
print("a,b,c,d,e")
print("min",end="=")
print(min("a","b","c","d","e"))
print("max",end="=")
print(max("a","b","c","d","e"))
print()

#文字列(大文字・小文字)：大文字の方が小さい
print("A,a")
print("min",end="=")
print(min("A","a"))
print("max",end="=")
print(max("A","a"))
print()

#文字列(英字・数値)：数値の方が小さい
print("1,a,A")
print("min",end="=")
print(min("1","a","A"))
print("max",end="=")
print(max("1","a","A"))
print()

# 文字列と数値：例外になる。
#print("1,a,A")
#print("min",end="=")
#print(min(1,"a","A"))

#リスト(数値のみ)
lst = [1,2,3]
print(lst)
print("min",end="=")
print(min(lst))
print("max",end="=")
print(max(lst))
print()

#リスト(数値のみ)
lst = ["A","a"]
print(lst)
print("min",end="=")
print(min(lst))
print("max",end="=")
print(max(lst))
print()

#リスト(数値・文字列):例外になる。
#lst = ["A",1]
#print(lst)
#print("min",end="=")
#print(min(lst))

#辞書(keyでソート、keyが数値）
dict={1:9,2:8,3:7}
print(dict)
print("min",end="=")
print(min(dict))
print("max",end="=")
print(max(dict))
print()

#辞書(keyでソート、keyが文字）
dict={"a":9,"A":8,"c":7}
print(dict)
print("min",end="=")
print(min(dict))
print("max",end="=")
print(max(dict))
print()

#辞書(keyでソート、keyが混在）:例外になる
#dict={"a":9,"A":8,1:7}
#print(dict)
#print("min",end="=")
#print(min(dict))

#タプル(変更不可）
tpl=(1,2,3,4,5)
print(tpl)
print("min",end="=")
print(min(tpl))
print("max",end="=")
print(max(tpl))

#集合(重複不可）
sets=(1,2,3,4,5,1,2,3,4,5,6)
print(sets)
print("min",end="=")
print(min(sets))
print("max",end="=")
print(max(sets))









