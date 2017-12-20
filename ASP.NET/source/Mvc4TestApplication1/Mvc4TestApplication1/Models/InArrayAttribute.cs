
using System;
using System.ComponentModel.DataAnnotations;
using System.Globalization;


using System.Web.Mvc;
using System.Collections.Generic;

namespace Mvc4TestApplication1.Models
{
    // 値リストとの比較検証を行うInArray属性を定義
    [AttributeUsage(AttributeTargets.Property,AllowMultiple=false)]
    public class InArrayAttribute:ValidationAttribute, IClientValidatable
    {
        // CSV区切りの文字列を保存する変数
        private string _opts;

        // コンストラクタ
        // CSV区切り文字の設定と、エラーメッセージの設定を行う。。
        public InArrayAttribute(string opts)
        {
            this._opts = opts;
            this.ErrorMessage = "{0}は{1}のいずれかで指定してください。";

        }

        //  プロパティの表示名と値リストでエラー・メッセージを整形
        public override string FormatErrorMessage(string name)
        {
            return String.Format(CultureInfo.CurrentCulture,
                                 ErrorMessageString, name, _opts);
        }

        // 検証の実処理（値リストに入力値が含まれているかをチェック）
        public override bool IsValid(object value)
        {
            bool bRtn = false;

            // 入力値が空の場合は検証をスキップ  
            if (value == null) {
                return true; 
            }

            // カンマ区切りテキストを分解し、入力値valueと比較  
            if (Array.IndexOf(_opts.Split(','), value) == -1)
            {
                bRtn=false;
            }
            else
            {
                bRtn= true;
            }

            return bRtn;

        }

        // クライアントに送信する検証情報の生成
        public IEnumerable<ModelClientValidationRule> GetClientValidationRules(ModelMetadata metadata, ControllerContext context)
        {
            // 検証ルールを準備
            var rule = new ModelClientValidationRule
            {
                ValidationType = "inarray", // 検証名
                ErrorMessage = FormatErrorMessage(metadata.GetDisplayName()) // エラー
            };
            rule.ValidationParameters["opts"] = _opts; // 検証パラメータ
            yield return rule;
        }

    }
}