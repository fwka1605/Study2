a = 8
basic = lambda x: x*5 if x<8 else a/2

print('計算結果')
print(basic(a))

import re

time_list = [
    "2018/1/23_19:40",
    "2016/5/7_5:25",
    "2018/8/21_10:50",
    "2017/8/9_7:5",
    "2015/4/1_22:15"
]

get_month = lambda x:int(re.split("[/_:]",x)[1])

month_list = list(map(get_month,time_list))

print()
print("月")
print(month_list)

length = [3,1,6,2,8,2,9]
side = [4,1,15,18,7,2,19]
height = [10,15,17,13,11,19,18]

volume = [x*y*z for x,y,z in zip(length,side,height)]

print()
print("体積")
print(volume)

from collections import defaultdict
from collections import Counter

price = [
    ("strawberry",520),
    ("pear",200),
    ("peach",400),
    ("apple",170),
    ("lemon",150),
    ("grape",1000),
    ("strawberry",750),
    ("pear",400),
    ("peach",500),
    ("strawberry",70),
    ("lemon",300),
    ("strawberry",700),
]

d = defaultdict(list)

price_key_count = []

for key,value in price:
    d[key].append(value)
    price_key_count.append(key)

print()
print('Valueの平均値')
print([sum(x)/len(x) for x in d.values()])

key_count = Counter([x[0] for x in price])
print()
print('フルーツ名')
print(key_count)

