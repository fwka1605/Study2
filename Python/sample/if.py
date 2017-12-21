val1=1
val2=2

if val1==val2:
	print('val1==val2')
elif val1>val2:
	print('val1>val2')
else:
	print('else')

print('end1')	

if 1<val2<3:
	print('1<val2<3')
	
print('end2')	

val3=3

if val3==1:
	print("val3==1")
elif val3 in(2,3):
	print("val3 in (2,3)")
else:
	print("else")
	
print('end3')

data=None

if data==None:
	print("data==None")

if data is None:
	print("data is None")
