import pandas as pd

df =pd.read_csv("http://archive.ics.uci.edu/ml/machine-learning-databases/wine/wine.data",header=None)

df.columns = ["","Alcohol","Malic acid","Ash","Alcalinity of ash","Magnesium","Total phenols", \
            "Flavanoids","Nonflavanoid phenols","Proanthocyanins","Color intensity","Hue", \
            "OD280/OD315 of diluted wines","Proline"]

print(df)

