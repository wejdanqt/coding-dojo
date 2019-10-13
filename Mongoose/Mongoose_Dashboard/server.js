const express = require("express");
var parser = require('body-parser');
const app = express();

app.use(parser.urlencoded({ extended: false }))


app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');

const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/name_of_your_DB', { useNewUrlParser: true });

const AnimalSchema = new mongoose.Schema({
    name: String,
    favorite_food: String,
    created_on: { type: Date, default: Date.now },
}, { timestamps: true });
const Animal = mongoose.model('Animal', AnimalSchema);

//print all animal info 

app.get('/', (req, res) => {
    arr = Animal.find({}, function (err, animals) {
        res.render('index', { arr: animals });
    }).sort({ createdAt: -1 });

});

//...........................................
//Find by id 

app.get('/mongooses/:id', (req, res) => {
    console.log(req.params.id)
    arr = Animal.find({ _id: req.params.id }, function (err, animals) {
        res.render('index', { arr: animals });
    }).sort({ createdAt: -1 });

});

//...........................................
//ADD new animal 
app.get('/mongooses/new', (req, res) => {
    Animal.find()
        .then(data => res.render("new", { animals: data }))
        .catch(err => res.json(err));
});

app.post('/mongooses', (req, res) => {
    console.log(req.body.name)
    const animal = new Animal();
    animal.name = req.body.name;
    animal.favorite_food = req.body.food;
    animal.save()
        .then(newAnimalData => console.log('animal created: ', newAnimalData))
        .catch(err => console.log(err));
    res.redirect('/');
})
//...........................................

//edit an animal by id 
app.get('/mongooses/edit/:id', (req, res) => {
    arr = Animal.findOne({ _id: req.params.id }, function (err, animals) {
        console.log(arr)
        res.render('edit', { arr: animals });
    }).sort({ createdAt: -1 });

});

app.post('/mongooses/:id', (req, res) => {
    Animal.updateOne({ _id: req.params.id }, {
        name: req.body.name,
        favorite_food: req.body.food
    })
        .then(result => {
        })
        .catch(err => res.json(err));
});
//...........................................
app.post('/mongooses/destroy/:id', (req, res) => {
    Animal.remove({ _id: req.params.id  })
        .then(deletedAnimal => {
        })
        .catch(err => res.json(err));
        res.redirect('/');
});












app.listen(8000, () => console.log("listening on port 8000"));
