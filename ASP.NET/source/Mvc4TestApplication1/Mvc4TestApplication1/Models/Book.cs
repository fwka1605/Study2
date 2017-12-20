using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.ComponentModel.DataAnnotations;
using System.ComponentModel;

using System.Text.RegularExpressions;


namespace Mvc4TestApplication1.Models
{
    public class Book : IValidatableObject
    {

        [Key]
        [DisplayName("ISBNコード")]
        [Required(ErrorMessage = "{0}は必須です。。。")]
        [RegularExpression("[0-9]{3}-[0-9]{1}-[0-9]{3,5}-[0-9]{3,5}-[0-9A-Z]{1}", ErrorMessage = "{0}はISBNの形式で入力してください。")]
        public string Isbn { get; set; } // ISBNコード

        [DisplayName("書名")]
        [Required(ErrorMessage = "{0}は必須です。")]
        [StringLength(100, ErrorMessage = "{0}は{1}文字以内で入力してください。")]
        public string Title { get; set; } // 書名

        [DisplayName("価格")]
        [Range(100, 10000, ErrorMessage = "{0}は{1}～{2}の間で入力してください。")]
        public int? Price { get; set; } // 価格

        [DisplayName("出版社")]
        [InArray("翔泳社,技術評論社,秀和システム,毎日コミュニケーションズ,日経BP社,インプレスジャパン")]
        [StringLength(30, ErrorMessage = "{0}は{1}文字以内で入力してください。")]
        public string Publish { get; set; } // 出版社

        [DisplayName("刊行日")]
        [Required(ErrorMessage = "{0}は必須です。")]
        public DateTime Published { get; set; } // 刊行日

        public virtual ICollection<Review> Reviews { get; set; } // レビュー

        //  クラス・レベルの検証ルールを定義
        public IEnumerable<ValidationResult> Validate(ValidationContext validationContext)
        {
            string pattern = "^[0-9]{3}-[0-9]{1}-[0-9]{3,5}-[0-9]{3,5}-[0-9X]{1}$";

            //  Published列が2007年以前の場合は正規表現を置き換え
            if (Published.Year < 2007)
            {
                pattern = "^([0-9]{3}-)?[0-9]{1}-[0-9]{3,5}-[0-9]{3,5}-[0-9X]{1}$";
            }

            // 用意された正規表現パターンで入力値をチェック
            var rx = new Regex(pattern);
            if (!rx.IsMatch(Isbn))
            {
                yield return new ValidationResult(
                  "ISBNコードの形式が間違っています。", new[] { "Isbn" });
            }
        }

    }
}