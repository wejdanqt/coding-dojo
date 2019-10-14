const mongoose = require('mongoose'),
Animal = mongoose.model('Animal')


  module.exports = function(app){
//print all animal info 
var animal = require('../controllers/animals.js');

app.get('/', (req, res) => {
    animal.index(req, res);
});

//...........................................
//Find by id 

app.get('/mongooses/:id', (req, res) => {
    animal.func1(req, res);
});

//...........................................
//ADD new animal 
app.get('/mongooses/new/newanimal', (req, res) => {
    animal.func2(req, res);
});

app.post('/mongooses/add', (req, res) => {
    animal.func3(req, res);
})
//...........................................

//edit an animal by id 
app.get('/mongooses/edit/:id', (req, res) => {
    animal.func4(req, res);
});

app.post('/mongooses/:id', (req, res) => {
    animal.func5(req, res);

});
//...........................................
app.post('/mongooses/destroy/:id', (req, res) => {
    animal.func6(req, res);
    
});

  }