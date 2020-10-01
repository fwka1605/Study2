import matplotlib.pyplot as plt 

import pandas as pd

df_iris = pd.read_csv("http://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data",header=None)


df_iris.columns = ["sepal length","sepal width","petal length","petal width","class"]

fig = plt.figure(figsize=(10,10))

plt.scatter(
    df_iris.iloc[:50,0],
    df_iris.iloc[:50,1],
    label="setosa",
    color="k")

plt.scatter(
    df_iris.iloc[50:100,0],
    df_iris.iloc[50:100,1],
    label="versicolor",
    color="b")

plt.scatter(
    df_iris.iloc[100:,0],
    df_iris.iloc[100:,1],
    label="virginica",
    color="g")

plt.xlabel("sepal length")
plt.xlabel("sepal width")

plt.legend(loc="best") 

plt.grid(True)

plt.show()