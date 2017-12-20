Imports System.Data.Objects

Module Module1

    Sub Main()
        DeleteAll()
        CreateData()
        QueryByLinq()

    End Sub


    Private Sub CreateData()
        Using container As New AddressBookContainer()
            Dim entry1 As New Entry() With
                {
                    .Name = "Doi",
                    .Age = 30,
                    .Address = New AddressType() With
                       {
                           .TelNo = "03-0000-0000",
                           .MailAddress = "doi@hogehoge.com"
                       }
                } '1. Entryエンティティを作成
            Dim entry2 As New Entry() With
                {
                    .Name = "Tanaka",
                    .Age = 31,
                    .Address = New AddressType() With
                       {
                            .TelNo = "043-000-0000",
                            .MailAddress = "tanaka@hoge.com"
                       }
                }

            Dim category1 As New Category() With
                {
                    .CategoryName = "友達"
                } '2. Categoryエンティティを作成
            Dim category2 As New Category() With
                {
            .CategoryName = "仕事"
                }
            Dim category3 As New Category() With
                {
            .CategoryName = "頻繁に連絡"
                }

            entry1.Categories.Add(category1) '3. EntryエンティティにCategoryエンティティを追加
            entry1.Categories.Add(category3)
            entry2.Categories.Add(category2)
            entry2.Categories.Add(category3)

            container.AddObject("Entries", entry1) '4. Entryエンティティをデータベースに追加
            container.AddObject("Entries", entry2)
            container.SaveChanges() '5. 変更内容を保存

        End Using
    End Sub

    Private Sub QueryByLinq()
        Using container As New AddressBookContainer() '1. オブジェクトコンテキストの生成
            'container.ContextOptions.LazyLoadingEnabled = False
            Dim name = "Doi"
            Dim entries = From entry In container.Entries Where entry.Name = name Select entry '2. LINQ to Entitiesでクエリを実行
            PrintEntries(entries) '3.クエリ結果を表示する
        End Using
    End Sub

    Private Sub PrintEntries(ByVal entries As IQueryable(Of Entry))
        For Each entry In entries '6. 取得したエントリを順に表示する
            Console.WriteLine(String.Format("{0} {1}歳 電話番号:{2}", entry.Name, entry.Age, entry.Address.TelNo))
            'entry.Categories.Load()
            For Each cat In entry.Categories '7. エントリに関連づけられたカテゴリも表示する
                Console.WriteLine(String.Format(" カテゴリ名:{0}", cat.CategoryName))
            Next
        Next
    End Sub

    Private Sub DeleteAll()
        Using container As New AddressBookContainer() '1. オブジェクトコンテキストの生成
            container.ExecuteStoreCommand("DELETE from EntryCategory;") '2. ネイティブSQLによるデータの削除
            container.ExecuteStoreCommand("DELETE from Entries;")
            container.ExecuteStoreCommand("DELETE from Categories;")
        End Using
    End Sub

End Module
