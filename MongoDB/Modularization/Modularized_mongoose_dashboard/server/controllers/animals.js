const mongoose = require('mongoose'),
    Animal = mongoose.model('Animal')

module.exports = {
    index: function (req, res) {
        arr = Animal.find({}, function (err, animals) {
            res.render('index', { arr: animals });
        }).sort({ createdAt: -1 });
    },
    func1: function (req, res) {
        console.log(req.params.id)
        arr = Animal.find({ _id: req.params.id }, function (err, animals) {
            res.render('index', { arr: animals });
        }).sort({ createdAt: -1 });
    },
    func2: function (req, res) {
        Animal.find()
            .then(data => res.render("new", { animals: data }))
            .catch(err => res.json(err));

    },
    func3: function (req, res) {
        console.log(req.body.name)
        const animal = new Animal();
        animal.name = req.body.name;
        animal.favorite_food = req.body.food;
        animal.save()
            .then(newAnimalData => console.log('animal created: ', newAnimalData))
            .catch(err => console.log(err));
        res.redirect('/');
    },
    func4: function (req, res) {
        arr = Animal.findOne({ _id: req.params.id }, function (err, animals) {
            console.log(arr)
            res.render('edit', { arr: animals });
        }).sort({ createdAt: -1 });

    },
    func5: function (req, res) {
        Animal.updateOne({ _id: req.params.id }, {
            name: req.body.name,
            favorite_food: req.body.food
        })
            .then(result => {
            })
            .catch(err => res.json(err));

    },
    func6: function (req, res) {
        Animal.remove({ _id: req.params.id  })
        .then(deleted => {
        })
        .catch(err => res.json(err));
        res.redirect('/');
       

    },

};

