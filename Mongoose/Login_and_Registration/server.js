const express = require("express");
var parser = require('body-parser');
const app = express();

app.use(parser.urlencoded({ extended: false }))

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');

var validator = require('validator');

const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/name_of_your_DB', { useNewUrlParser: true });

const session = require('express-session');

app.set('trust proxy', 1) // trust first proxy
app.use(session({
    secret: 'keyboard cat',
    resave: false,
    saveUninitialized: true,
    cookie: { maxAge: 60000 }
}))

const RegisterSchema = new mongoose.Schema({
    email: { type: String, required: true , unique: true,  
        validate: [ validator.isEmail, "Email should have a valid syntax e.g: example@example.com" ]},
    first_name: { type: String, required: true, minlength: 6 },
    last_name: { type: String, required: true, maxlength: 20 },
    password: { type: String, required: true, minlength: 8 },
    bday: { type: String, maxlength: 20 },
    created_on: { type: Date, default: Date.now },
}, { timestamps: true });
const Register = mongoose.model('Register', RegisterSchema);


//Register Form 
app.get('/', (req, res) => {
    Register.find()
        .then(data => res.render("index", { reg: data ,  errors: ''}))
        .catch(err => res.json(err));
});

//Register form action 
app.post('/reg', (req, res) => {
    console.log("req.body: ", req.body);
    Register.create({ email: req.body.email, first_name: req.body.first_name, last_name: req.body.last_name, bday: req.body.bday, password: req.body.password }, (err, user) => {
        if (err) {
            console.log(err);
            res.render('index', {errors: err});
        }
        else {
            req.session.name = user.first_name
            res.render('welcome' , {name: req.session.name  });
        }

    })
})


app.post('/login', (req, res) => {
    console.log(" req.body: ", req.body);
    Register.findOne({email:req.body.email, password: req.body.password}, (err, user) => {
        if (err) {
            console.log(err);
            res.render('index', {errors: err});
        }
        if (user && user.password === req.body.password){
            console.log('User and password is correct')
            req.session.name = user.first_name
            res.render('welcome' , {name: req.session.name });

          } else {
            console.log("Credentials wrong");
            res.render('index', {errors: ""});
          }  
    })
})


app.listen(8000, () => console.log("listening on port 8000"));
