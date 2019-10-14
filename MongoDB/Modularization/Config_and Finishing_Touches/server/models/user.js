var mongoose = require('mongoose');

const UserSchema = new mongoose.Schema({
    name: String,
    quote: String,
    created_on : {type: Date, default: Date.now },
 },{timestamps: true });


const User = mongoose.model('User', UserSchema);
