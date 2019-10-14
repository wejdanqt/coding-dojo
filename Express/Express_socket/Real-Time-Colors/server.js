const express = require("express");
const app = express();


const server = app.listen(8000);
const io = require('socket.io')(server);

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');


app.get("/", (req, res) => {
    res.render('index');
})

//socket code 

io.on('connection', function (socket) {
    console.log("connected")
    //Green 
    socket.on('green' , function(){
        var color = 'green'
        io.emit('update_color', color );
    });
    //Blue 
    socket.on('blue' , function(){
        var color = 'blue'
        io.emit('update_color', color );
    });
    //pink
    socket.on('pink' , function(){
        var color = 'pink'
        io.emit('update_color', color );
    });

});

