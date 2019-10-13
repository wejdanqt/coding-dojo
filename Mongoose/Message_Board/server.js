const express = require("express");
var parser = require('body-parser');
const app = express();

app.use(parser.urlencoded({ extended: false }))


app.set('view engine', 'ejs');
app.set('views', __dirname + '/views');


const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/name_of_your_DB', { useNewUrlParser: true });


//Create a model 

const CommentSchema = new mongoose.Schema({
    name: { type: String },
    content: { type: String, },
}, { timestamps: true })
const Comment = mongoose.model('Comment', CommentSchema);

const PostSchema = new mongoose.Schema({
    name: { type: String, required: [true, "Posts must have a name of the poster "] },
    content: { type: String, required: [true, "Posts must have content"] },
    comments: [CommentSchema]
}, { timestamps: true })
const Post = mongoose.model('Post', PostSchema);


app.get("/", (req, res) => {
    arr = Post.find({})
        .exec(function (err, posts) {
            res.render('index', { arr: posts })
            console.log(arr)
        })
})

app.post("/add", (req, res) => {
    console.log(req.body.name)
    const post = new Post();
    post.name = req.body.name;
    post.content = req.body.content;
    post.save()
        .then(newPostlData => console.log('Post created: ', newPostlData))
        .catch(err => console.log(err));
    res.redirect('/');


});

app.post('/add_comment/:id', (req, res) => {
    Comment.create(req.body, function (err, data) {
        if (err) {
            console.log("Error")
        }
        else {
            Post.findOneAndUpdate({ _id: req.params.id }, { $push: { comments: data } }, function (err, data) {
                if (err) {
                    console.log("Error")
                    res.redirect('/');
                }
                else {

                    res.redirect('/');
                }
            })
        }
    })


});

app.listen(8000, () => console.log("listening on port 8000"));
