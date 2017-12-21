let nextTodoId = 0;

/*
	ActionCreator
	ActionCreatorはViewから渡された入力に対応するActionを返す。
	Actionは、何をするかのみ表す非表示に軽量なオブジェクトで、
	Actionの型を表すtypeプロパティ以外は、自由に付与することが
	できる。
	addTodo,toggleTodo,setVisibilityFilterという３つの関数が
	返却するオブジェクトが、今回のTODOアプリのActionになる。
*/
export const addTodo = (text) => {
	return {
		type:'ADD_TODO',
		id:nextTodoID++,
		text
	};
};

export const toggleTodo = (id) => {
	return {
		type:'TOGGLE_TODO',
		id
	};
};

export const setVisibilityFilter = (filter) => {
	return {
		type:'SET_VISIBILITY_FILTER',
		filter
	};
};