import pandas as pd
from pandas import Series,DataFrame

attr_data1 = {
    "ID":["100","101","102","103","104","106","108","110","111","113"],
    "city":["Tokyo","Osaka","Kyoto","Hokkaido","Tokyo","Tokyo","Osaka","Kyoto","Hokkaido","Tokyo"],
    "birth_year":[1990,1991,1992,1997,1982,1991,1988,1990,1995,1981],
    "name":["Hiroshi","Akiko","Yuki","Satoru","Steeve","Mituru","Aoi","Tarou","Suguru","Mitsuo"]
}

attr_data1_frame = pd.DataFrame(attr_data1)

attr_data2 = {
    "ID":["107","109"],
    "city":["Sendai","Nagoya"],
    "birth_year":[1994,1988],
}

attr_data2_frame = pd.DataFrame(attr_data2)

attr_data1_frame = attr_data1_frame.append(attr_data2_frame).sort_values(by="ID").reset_index(drop=True)

print(attr_data1_frame)


