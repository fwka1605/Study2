
dict1 = {'apple':'red','grape':'purple','banana':'yellow'}
dict2 = dict(one=1,two=2,three=3)


print(dict1)
print(dict2)

#キーの存在確認
print ('apple' in dict1)
print ('apple' in dict2)

#辞書の走査いろいろ

print("Key,Valueで走査")
for k,v in dict1.items():
      print(k,v)
print()

print("Keyで走査")
for k in dict1.keys():
      print(k,dict1[k])
print()

print("Valueで走査")
for v in dict1.values():
      print(v)
print()
      
