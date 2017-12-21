/*
 * NicoScreen, version: 0.1 (2011-07-11)
 *
 *
 * For usage and examples, visit:
 * http://nicoscreen.r9game.com
 *
 * Licensed under the MIT:
 * http://www.opensource.org/licenses/mit-license.php
 *
 * Copyright (c) 2011, Shikemoku.MK (shikemoku.mk -[at]- gmail [*dot*] com)
 */

function nicoscreenobj(o) {
	var f = nicoscreenobj.f, i, len, n, prop;
	f.prototype = o;
	n = new f;
	for (i=1, len=arguments.length; i<len; ++i)
	{
		for (prop in arguments[i])
		{
			n[prop] = arguments[i][prop];
		}
	}
	return n;
}
nicoscreenobj.f = function(){};

var r9 = {};
r9.NicoScreen = {
	env : {					// ユーザが設定可能な動作を調整するための変数
		color:"white",		// コメントの色
		interval:500,		// comments配列を使用する際に、次のコメントを表示する間隔
		speed:6500,			// コメントをanimateする（横に流す）スピード
		font_size:"24px",	// コメントのフォントサイズ
		loop:true,			// comments配列を使用する際に、最後まで表示した後にループするかのフラグ
		height:"",			// コメントを表示するDOM要素の高さ・幅を指定する。
		width:""			// heigth:この値の範囲内で高さをランダムに調整する
							// width:この値を使って、横に流すコメントの終端を判断している。
	},

	top_pos:20,			// コメントが表示される高さ（毎回ランダムに更新される）
	draw_index:0,		// comments配列で表示されるコメント用のインデックス
	comments:[],		// comments配列に初期設定すると、設定したコメントが順番に流れる。

	/*
		この変数を使用して、動作制御用の設定を行う。
			color		：初期値あり
			interval	：初期値あり、fastまたはslowで指定する
			speed		：初期値あり、fastまたはslowで指定する
			font_size	：初期値あり
			loop		：初期値あり
			height		：必須
			width		：必須
			comments	：これを設定しない場合は、addメソッドで追加する必要がある。
	*/
	set:function(o){

		this.comments = o.comments;

		if(o.base.color){
			this.env.color = o.base.color;
		}

		if(o.base.loop){
			this.env.loop = o.base.loop;
		}

		if(o.base.interval){
			switch(o.base.interval){
				case "fast":
					this.env.interval=3000;
					break;
				case "slow":
					this.env.interval=9500;
					break;
			}
		}

		if(o.base.font_size){
			this.env.font_size = o.base.font_size;
		}

		if(o.base.speed){

			switch(o.base.speed){
				case "fast":
					this.env.speed=4000;
					break;
				case "slow":
					this.env.speed=10000;
					break;
			}
		}

	},

	/*
		コメントの表示処理を開始する
	*/
	start : function(){

		/*
		 * コメントを表示する要素のCSSを設定し、
		 * イベントハンドラを無効化する。
		 * 		position：nicoscreen要素にのせる子要素の位置を相対的に指定する。
		 * 		brder:borderを設定する。（これはなくてよいのでは？）
		 * 		overflow:nicoscreen要素にのせる子要素が、nicoscreen要素からはみ出した場合、その部分は非表示にする。
		 * 		selectstart:要素が選択された際のイベント（無効にする）
		 * 		mousedown:マウスが栗生された際のイベント（無効にする）
		 */
		var elm = $("#nicoscreen");
		this.elm = elm;
		this.elm.css("position", "relative");
		this.elm.css("border", "solid 1px gray");
		this.elm.css("overflow", "hidden");
		this.elm.bind("selectstart",function(){return false;});
		this.elm.bind("mousedown",function(){return false;});

		this.env.width = ""+elm.css("width");
		this.env.height = ""+elm.css("height");

		this.env.width = this.env.width.replace("px","");
		this.env.height = this.env.height.replace("px","");

		//console.log(this.env.width);

		// setInterval：nicoscreen.draw(null)をinterval間で繰り返して実行する
		var inid = setInterval("nicoscreen.draw(null)", this.env.interval);

	},

	/*
		１コメントの実際の表示処理を行う。
	*/
	draw: function(str){

		var n = nicoscreen;

		var i = n.draw_index;
		var comment_str =  "";

		// add経由で呼び出した際は、strありで呼ばれる。
		if(str){
			// 表示するコメントを設定する。
			comment_str = str;
			
			// 表示するコメント要素にフルIDに付与する番号をランダムに作成する
			i=parseInt((new Date)/1000);
		}
		// start経由で呼び出した際は、strはNullになる。
		else{
			// 次に表示するコメントがcommentsの最後まで来たときは最初に戻す
			if (n.draw_index >= n.comments.length) {
				if(n.env.loop){
					 n.draw_index = 0;
				}
				return false;
			}
			// 表示するコメントを設定する
			comment_str = n.comments[i];
			// 次に表示するコメントの添え字を設定する
			n.draw_index++;
		}

		// コメント要素を表示する位置をheight範囲内でランダムに設定する
		n.top_pos =  Math.floor( Math.random() * parseInt(n.env.height) );

		// コメント要素の表示が終了する横位置を設定する。
		var end_left = (parseInt(n.env.width)) * -1;

		// 表示するコメント要素を作成する
		var cmid = "cm" + i + "";
		var com_obj = $("<div " + 
							"id='" + cmid + "' " +
							"style='left:" + n.env.width + "px;" +	// 親要素のwidth（つまり、右端）
								"position:absolute;" +				// left/topは絶対位置を指定
								"top:" + n.top_pos + "px; " + 		// ランダムに計算した高さ
								"color:"+n.env.color+"; " + 
								"font-size:" + n.env.font_size+"; " +
								"font-weight:bold; " + 
								"text-shadow: " + "black 1px 1px 1px;width:100%; " + 
								"z-index:99999; " + 				// 要素の重なった際の順序（大きい値ほど上にくる。）
								"cursor:default'>" + 				// カーソルの形状
							comment_str + 
						"</div>");

		// コメント要素を追加する。
		$("#nicoscreen").append(com_obj);

		// コメント要素のanimate処理を追加する
		(function(that){
			// コメント要素のID属性
			var tmp_cmid = cmid;
			// コメント要素のアニメイト処理
			com_obj.animate(
				// アニメイトされる要素の最終形態をCSSで指定する。
				{
					// 明日調べろ
					left: end_left
					// 表示はfadeOut、非表示はfadeInになる。
					// 透明度
					,opacity:"toggle"
				}, 
				{
					// コメント要素が流れるスピード
					duration: n.env.speed,
					// 要素の動作
					// swing：動作の最初と最後が遅くなる、linear:動作が常に一定
					easting:"swing",	
					
					// コメント要素のanimate処理が終了した際の処理
					complete: function(){
						// IDを作成する。
						var elm_id = "#" + tmp_cmid;
						// 表示が終了したコメント要素を取り除く
						$("#nicoscreen").remove(elm_id);
						that.top_pos = 10;
					}
				}
			);
		})(this);
	},

	/*
		set/start後にコメント要素を後から追加する処理
		このとき、comments配列を空にする必要がある。
		commentsを設定すると両方流れてしまう。
	*/
	add:function(str){
		this.draw(str);
	}

};

var nicoscreen = nicoscreenobj(r9.NicoScreen);