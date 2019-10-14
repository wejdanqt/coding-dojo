const mongoose = require('mongoose'),
Name = mongoose.model('Name')

module.exports = {
    index: function(req, res) {
        Name.find({} , function(err , data){
            if(err){
                console.log("Error")
            }
            else{
                res.json(data)
            }
        })
    },
    add: function(req, res) {
        const username = new Name();
        username.name = req.params.name
        username.save(function(err){
            if(err){
                console.log("Error")
            }else{
                res.redirect("/");
            }

        })
    },
    remove: function(req, res) {
                
        Name.remove( {name: req.params.name }  , function(err){
            if(err){
                console.log("Error")
            }
            else{
                res.redirect("/");
            }
        })
    },

    find: function(req, res) {
                
        Name.findOne( {name: req.params.name }  , function(err , data){
            if(err){
                console.log("Error")
            }
            else{
                res.json(data)
            }
        })
    },

};

