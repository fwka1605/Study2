import csv

with open('top_cities.csv','w',newline='') as f:
    writer = csv.writer(f)

    # 1行の出力
    writer.writerow(['rank','city','population'])

    # リストの複数行への出力
    writer.writerows([
        ['1','上海','24150000'],
        ['2','カラチ','23500000'],
        ['3','北京','21516000'],
        ['4','天津','14722100'],
        ['5','イスタンブール','14160467'],
    ])

