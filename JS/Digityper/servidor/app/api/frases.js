var api = {};

var frases = [
	{_id: 0, texto:'Digityper, game for you increase your speed type.', tempo: 8 },
	{_id: 1, texto:'It is not enough to do your best: you must know what to do, and then do your best.',tempo: 15 },
	{_id: 2, texto:'Truth can only be found in one place: the code.', tempo: 8 },
	{_id: 3, texto:'Two things is very hard to do when you are a developer: cache invalidation and name things.', tempo: 15 },
	{_id: 4, texto:'A clever person solves a problem but a wise person avoids it.', tempo: 15 },
	{_id: 5, texto:'Before software can be reusable it first has to be usable.', tempo: 8 },
	{_id: 6, texto:'To go faster, slow down. Everybody who knows about orbital mechanics understands that.', tempo: 15 },
	{_id: 7, texto:'Software testing is a sport like hunting, its bughunting.', tempo: 10 },
	{_id: 8, texto:'Programmers are not mathematicians, no matter how much we wish and wish for it.', tempo: 12},
	{_id: 9, texto:'If it is not written down, it does not exist.', tempo: 8},

	];

api.lista = function(req, res) {

	setTimeout(function(){
		if(req.query.id) return res.json(frases[req.query.id]);

		res.json(frases);
	},1500);

};

module.exports = api;
