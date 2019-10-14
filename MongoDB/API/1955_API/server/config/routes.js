
    const mongoose = require('mongoose'),
    Name = mongoose.model('Name')

    var name = require('../controllers/names.js');

   module.exports = function(app){
 
    app.get('/', (req, res) => {
        name.index(req, res);
    }); 

    app.get('/new/:name', (req, res) => {
        name.add(req, res);
    }); 

    app.get('/remove/:name', (req, res) => {
        name.remove(req, res);
    });
    app.get('/:name', (req, res) => {
        name.find(req, res);
    });

   }