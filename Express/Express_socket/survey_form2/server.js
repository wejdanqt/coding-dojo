const express = require('express');
const app = express();

const server = app.listen(1337);
const io = require('socket.io')(server);


app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
app.use(express.urlencoded({extended: true}));


    
io.on('connection', function (socket) { 
    socket.on('posting_form', function (data) { 
    console.log(data)
    socket.emit('updated_message', { msg: "You emitted the following infromation to the server: Name:"+data.name+" City:"+data.city+
    " Language:"+data.lang+
    " comment:"+data.comment+""}); 

    random = Math.floor(Math.random() * 1000) + 1; 
    //Random Number 
    socket.emit('random_number', { rand: "Your lucky number emitted by the server is:"+random+"" }); 

    });
  });


app.get("/", (req, res) => {
    res.render('index');
})

app.post("/result", (req, res) => {
    var info_array = [
        {name: req.body.name , city: req.body.city , lang: req.body.lang , comment:req.body.comment}
    ];

    res.render('results',{information: info_array} );
    
})


