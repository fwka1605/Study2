# subdir配下のパッケージをインポートする
import subdir
subdir.sub1.subFunc()
subdir.sub2.subFunc()

print(subdir.__file__)
print(subdir.__path__)
