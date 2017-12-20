using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using EFCodeFrist.EM;
using EFCodeFrist.DC;

namespace EFCodeFrist
{
    public class Controller
    {
        public void addData(){
            // 追加
            User userA = new User("上川", 20);
            User userB = new User("山元", 30);

            using (MyContext context = new MyContext())
            {
                context.Users.Add(userA);
                context.Users.Add(userB);
                // 保存
                context.SaveChanges();
                Console.Out.WriteLine("追加しました");
            }
        }

        public void getData(){
            try
            {
                // 参照
                using (MyContext context = new MyContext())
                {
                    // 25歳以上のユーザーを抽出
                    IEnumerable<User> query = context.Users.Where(u=>u.Age>25).Select(u => u);

                    foreach (User user in query)
                    {
                        Console.Out.WriteLine(user.Name);
                    }
                }

            }
            catch (Exception e)
            {
                string str=e.StackTrace;
                int i = 0;
            }
        }

        public void delData()
        {
            // 更新・削除
            using (var context = new MyContext())
            {
                // ユーザーの年齢を更新
                User userU = context.Users.FirstOrDefault<User>(x => x.Name == "上川");
                userU.Age = 50;

                // ユーザーを削除
                var userD = context.Users.FirstOrDefault(x => x.Name == "山元");
                context.Users.Remove(userD);

                // 保存
                context.SaveChanges();
                Console.Out.WriteLine("更新削除しました");
            }
        }


    }
}
