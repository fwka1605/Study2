import numpy as np
import pandas as pd

index = ["growth","mission","ishikawa","pro"]
data=[50,7,26,1]

series = pd.Series(data=data,index=index)

aidemy = series.sort_index()

aidemy1 = pd.Series(index=["tutor"],data=[30])
aidemy2 = series.append(aidemy1,ignore_index=False)

print(aidemy)
print()
print(aidemy2)

df = pd.DataFrame()

for index in index:
    df[index]=np.random.choice(range(1,11),10)

df.index=range(1,11)

aidemy3 = df.loc[2:5,["ishikawa"]]

print(aidemy3)