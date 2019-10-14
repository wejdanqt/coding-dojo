// All necessary requires, such as the Quote model.
const mongoose = require('mongoose'),
User = mongoose.model('User')

module.exports = {
    index: function(req, res) {
        User.find()
        .then(data => res.render("index", { users: data }))
        .catch(err => res.json(err));
    },
    act: function(req, res) {
        console.log("hi")
        console.log(req.body.name)
        const user = new User();
        user.name = req.body.name;
        user.quote = req.body.text;
        user.save()
            .then(newUserData => console.log('user created: ', newUserData))
            .catch(err => console.log(err));
        res.redirect('/quotes');
    },
    act2: function(req, res) {
        arr = User.find({}, function (err, quotes) {
            res.render('quotes', { arr: quotes });
        }).sort({ createdAt: -1 });
    },

};
