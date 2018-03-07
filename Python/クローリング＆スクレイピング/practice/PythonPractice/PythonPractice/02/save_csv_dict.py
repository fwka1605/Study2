import csv

with open('top_cities.csv','w',newline='') as f:
    writer = csv.DictWriter(f,['rank','city','population'])

    writer.writeheader()

    # リストの複数行への出力
    writer.writerows([
        {'rank':'1','city':'上海','population':'24150000'},
        {'rank':'2','city':'カラチ','population':'23500000'},
        {'rank':'3','city':'北京','population':'21516000'},
        {'rank':'4','city':'天津','population':'14722100'},
        {'rank':'5','population':'14160467','city':'イスタンブール'},
    ])

