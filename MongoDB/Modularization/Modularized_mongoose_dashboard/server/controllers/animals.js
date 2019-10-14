const mongoose = require('mongoose'),
Animal = mongoose.model('Animal')

module.exports = {
    index: function(req, res) {
        arr = Animal.find({}, function (err, animals) {
            res.render('index', { arr: animals });
        }).sort({ createdAt: -1 });
    }
};

