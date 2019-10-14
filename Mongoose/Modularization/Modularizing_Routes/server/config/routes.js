
const mongoose = require('mongoose'),
    User = mongoose.model('User')

module.exports = function (app) {
    app.get('/', (req, res) => {
        User.find()
            .then(data => res.render("index", { users: data }))
            .catch(err => res.json(err));
    });

    app.post('/quote', (req, res) => {
        console.log("hi")
        console.log(req.body.name)
        const user = new User();
        user.name = req.body.name;
        user.quote = req.body.text;
        user.save()
            .then(newUserData => console.log('user created: ', newUserData))
            .catch(err => console.log(err));
        res.redirect('/quotes');
    })

    app.get('/quotes', (req, res) => {
        arr = User.find({}, function (err, quotes) {
            res.render('quotes', { arr: quotes });
        }).sort({ createdAt: -1 });
    });

}