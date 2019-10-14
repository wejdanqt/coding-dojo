const express = require("express");
const app = express();

app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');

app.use(express.urlencoded({extended: true}));

app.get("/", (req, res) => {
    res.render('index');
})

app.post("/result", (req, res) => {
    console.log(req.body.name) 
    var info_array = [
        {name: req.body.name , city: req.body.city , lang: req.body.lang , comment:req.body.comment}
    ];

    res.render('results',{information: info_array} );
    
})


app.listen(8000, () => console.log("listening on port 8000"));
