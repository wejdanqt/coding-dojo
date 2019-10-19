
    const mongoose = require('mongoose'),
    Task = mongoose.model('Task')

    var task = require('../controllers/tasks.js');

   module.exports = function(app){
 
    app.get('/tasks', (req, res) => {
        task.index(req, res);
    }); 
    app.get('/:id' , (req,res) =>{
        task.find(req, res);

    });
    app.post('/new' , (req,res) =>{
        task.add(req, res);

    });
    //new command 
    app.put('/update/:id' , (req,res) =>{
        task.update(req, res);

    });
    app.delete('/remove/:id' , (req,res) =>{
        task.remove(req, res);

    });

   }