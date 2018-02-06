def func(a,b=[]):
      b.append(a)
      return b

print(func(0))
print(func(0))
print(func(0))
print(func(0,[1,2]))
print(func(0))

def func2(a,b=None):
      if b is None:
            b=[]
      b.append(a)
      return b

print(func2(0))
print(func2(0))
print(func2(0))
print(func2(0,[1,2]))
print(func2(0))
