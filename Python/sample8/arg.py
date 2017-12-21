def func(a):
      print(a)

func("a")
func(1)
func(["a","b"])
func({1:1,2:2})

def func2(a=""):
      if a == "":
            a="no"
      print(a)

func2()
func2("")
func2("a")
func2(1)
func2(["a","b"])
func2({1:1,2:2})

def func3(a,b,*args):
      print(a,b,args)

func3(1,2,3)
func3(1,2,3,4,5,6)
func3(1,2,3,4,"aaa","bbb")

def func4(a,b,**args):
      print(a,b,args)

func4(1,2)
func4(1,2,arg1="a")
func4(1,2,arg1="b",arg2="b",arg3="c")
