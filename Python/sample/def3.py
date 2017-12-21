def func(a,b):
      b=a+b
      return b
c=1
d=2
print(c)
print(d)
print(func(c,d))
print(c)
print(d)

def func2(a,b=None):
      if b is None:
            b = []

      return b.append(a)

e=[]
print(e)
print(func2(0,e))
print(e)
print(func2(1,e))
print(e)
      
