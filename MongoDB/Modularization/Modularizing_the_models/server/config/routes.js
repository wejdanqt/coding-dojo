
    const mongoose = require('mongoose'),
    User = mongoose.model('User')

    var user = require('../controllers/users.js');

   module.exports = function(app){
 
    app.get('/', (req, res) => {
        user.index(req, res);
    }); 

    app.post('/quote', (req, res) => {

        user.act(req, res);
    })

    app.get('/quotes', (req, res) => {
        user.act2(req, res);
    });
   }
