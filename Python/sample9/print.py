# 出力内容末尾の指定
# 末尾は通常改行コードになるが、end引数で末尾を変更できる。
print('hoge',end='crlf')
print('hoge')

# 区切り文字の指定
# 出力対象が複数の場合の区切り文字は半角スペースだがをsep引数で変更できる。
print('hoge','fuga','boo')
print('hoge','fuga','boo',sep="・")

#ファイルに出力する
f=open("hoge.txt","w",encoding="UTF-8")
print("hogefuga",file=f)
f.close()

# フォーマット出力
print("%s-%s-%s"%('hoge','fuga','boo'))
