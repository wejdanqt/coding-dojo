const express = require("express");
const app = express();


const server = app.listen(6789);
const io = require('socket.io')(server);

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');
app.use(express.urlencoded({extended: true}));
var counter = 0;

io.on('connection', function (socket) { //2
    io.emit('updated_counter', counter);

    socket.on('button' , function(){
        counter++;
        io.emit('updated_counter', counter);
    });
});


    // socket.on('count', function (data) { //7
    //   console.log(data.msg); 
    // });
      


app.get("/", (req, res) => {

    res.render('index');
})

app.get("/reset", (req, res) => {
    counter = 0;

    res.render('index');
})

// app.get("/count", (req, res) => {

//     res.render('index');
// })

