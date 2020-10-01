import numpy as np

arr_list = [x for x in range(10)]

print("リスト型です")
print("arr_list:",arr_list)
print()

arr_list_copy = arr_list[:]
arr_list_copy[0]=100

print("リストのスライスはコピーが作成されるので、arr_listにはarr_list_copyの変更が反映されません")
print("arr_list:",arr_list)
print()

arr_numpy = np.arange(10)

print("Numpyのndarrayです")
print("arr_numpy:",arr_numpy)
print()

arr_numpy_view = arr_numpy[3:5]
arr_numpy_view[0]=100

print("NumpyのスライスはViewの場所が渡されるので、arr_numpyにはarr_numpy_viewの変更が反映されます")
print("arr_numpy:",arr_numpy)
print()

arr_numpy = np.arange(10)
arr_numpy_copy = arr_numpy.copy()
arr_numpy_copy[0]=100

print("Numpyのコピーはコピーが作成されるので、arr_numpyにはarr_numpy_copyの変更が反映されません")
print("arr_numpy:",arr_numpy)
print()
