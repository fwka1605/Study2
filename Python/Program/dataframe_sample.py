import pandas as pd

index = ["taro","mike","kana","jun","sachi"]

columns = ["国語","数学","社会","理科","英語"]

data = [
        [30,45,12,45,87],
        [65,47,83,17,58],
        [64,63,86,57,46],
        [38,47,62,91,63],
        [65,36,85,94,36]
]

df = pd.DataFrame(data=data,index=index,columns=columns)


pe_column = pd.Series([56,43,73,82,62],index = ["taro","mike","kana","jun","sachi"])

df["体育"] = pe_column

print(df)
print()

df1 = df.sort_values(by="数学")

print(df1)
print()

df2 = df1+5

print(df2)
print()

print(df2.describe().loc[["mean","max","min"]])