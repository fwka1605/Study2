var express = require('express');
var router = express.Router();

var items = [
    { "text": "1st Post." }
  , { "text": "2nd Post." }
];

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Entry List', items: items });
});

router.get('/form', function(req, res){
  res.render('form', { title: 'New Entry' })
});

router.post('/create',function(req, res){
  console.log(req.body.text);
  res.redirect('/');
});

module.exports = router;
