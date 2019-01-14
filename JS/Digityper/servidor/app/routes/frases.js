module.exports = function(app) {

	var api = app.api.frases;

	app.route('/frases.js/')
		.get(api.lista);
};
