try:
      x=10/0
      print("try")
except Exception as e:
      print("Exception")
      print(e)
finally:
      print("finally")

print("end try")
      

try:
      raise Exception("raise")
except Exception as e:
      print("Exception")
      print(e)

 
