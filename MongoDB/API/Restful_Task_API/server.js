const express = require("express");
var bodyParser = require('body-parser');
const app = express();

app.use(bodyParser.urlencoded({ extended: false }))

const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/restful_task', {useNewUrlParser: true});


app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

require('./server/config/mongoose.js');
require('./server/config/routes.js')(app);


app.listen(8000, () => console.log("listening on port 8000"));