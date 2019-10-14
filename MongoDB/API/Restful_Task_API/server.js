const express = require("express");
var parser = require('body-parser');
const app = express();

app.use(parser.urlencoded({ extended: false }))

const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/restful_task', {useNewUrlParser: true});




require('./server/config/mongoose.js');
require('./server/config/routes.js')(app);


app.listen(8000, () => console.log("listening on port 8000"));