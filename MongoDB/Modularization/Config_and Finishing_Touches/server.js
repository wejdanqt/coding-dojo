var express = require('express');
var parser = require('body-parser');
var app = express();

app.use(parser.urlencoded({ extended: false }))
app.use(parser.json())
 
app.use(function(req,res,next){
    res.locals.userValue = null;
    next();
})
 

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');


const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/name_of_your_DB', {useNewUrlParser: true});


require('./server/config/mongoose.js');
require('./server/config/routes.js')(app);
   

app.listen(8000, () => console.log("listening on port 8000"));

