function getCanvasContextById(id){

	var canvas = getCanvasById(id);

	if(!canvas){
		return;
	}
	else{
		// コンテキストオブジェクトを取得
		var ctx = canvas.getContext('2d');
		return ctx;
	}
}

function getCanvasById(id){
	var arrayCanvas = $("#" + id);
	var canvas = arrayCanvas[0];

	// コンテキストがあるか確認
	if(!canvas || !canvas.getContext){
		return;
	}
	else{
		return canvas;
	}
}

function clearCanvasById(id){
	var canvas = getCanvasById(id);
	var ctx = getCanvasContextById(id)


	if(!canvas||!ctx){
		return;
	}
	else{
		ctx.clearRect(0,0,canvas.width,canvas.height);
	}	
}
