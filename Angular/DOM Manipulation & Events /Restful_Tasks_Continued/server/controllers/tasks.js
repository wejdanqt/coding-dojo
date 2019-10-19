const mongoose = require('mongoose'),
Task = mongoose.model('Task')

module.exports = {
    index: function(req, res) {
        Task.find({} , function(err , data){
            if(err){
                console.log("Error")
            }
            else{
                res.json(data)
            }
        })
    },

    find: function(req, res) {
        Task.findOne( {_id: req.params.id }  , function(err , data){
            if(err){
                console.log("Error")
            }
            else{
                res.json(data)
            }
        })
    },
    add: function(req, res) {
        console.log("____")
        const task = new Task({title: req.body.title ,description : req.body.description });
        task.save(function(err , data){
            if(err){
                console.log("Error")
            }else{
                res.json(data)
            }
          })
    },
    update: function(req, res) {
        console.log("____")
        Task.update({_id:req.params.id} , {title: req.body.title ,description : req.body.description } ,  function(err, data){
            if(err){
                console.log("Error")
            }else{
                res.json(data)
            }
        })
    },
    remove: function(req, res) {
        Task.remove( {_id: req.params.id }  , function(err , data){
            if(err){
                console.log("Error")
            }
            else{
                console.log("Removed")
                res.json(data)
            }
        })
    },

};