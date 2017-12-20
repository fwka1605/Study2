using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Mvc4TestApplication1.Models
{
    public class Review
    {
        public int ReviewId { get; set; } // レビューID
        public string Title { get; set; } // レビュータイトル
        public string Body { get; set; } // レビュー本文
        public DateTime CreatedAt { get; set; } // 投稿日
    }
}