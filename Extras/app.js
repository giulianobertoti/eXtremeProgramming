var express = require('express');
var app = express();
var MongoClient = require('mongodb').MongoClient;

app.use(express.static('public'));

app.get('/tablature/:band/:music', function (req, res) {
  var ra = req.params.ra;
  
	MongoClient.connect('mongodb://localhost:27017/chords', function(err, db) {
	  if (err) {
		throw err;
	  }
		db.collection('tablatures').find({'band':band, 'music':music}).toArray(function(err, result) {
			if (err) {
				throw err;
			}
			res.send(result);
		});
	});
  
  
});

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});