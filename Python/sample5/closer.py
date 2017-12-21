
def counter():
      count = 0
      def inner_counter():
            nonlocal count
            count+=1
            return count

      return inner_counter

cnt= counter()
print(cnt)
print(cnt())
print(cnt())
print(cnt())


print(counter())
print(counter())
print(counter()())
print(counter()())
print(counter()())
