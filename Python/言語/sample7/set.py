# 値が重複するリスtの作成
lst=['hoge','fuga','boo','fuga','boo']
print(lst)
print()

#リストから集合を生成
sets=set(lst)
print(sets)
print()

#集合の演算
sets1={'A','B','C','D'}
sets2={'A','C'}

print(sets1-sets2)
print(sets1&sets2)
print(sets1^sets2)
print(sets1|sets2)
print(sets1<=sets2)
print(sets1>=sets2)

