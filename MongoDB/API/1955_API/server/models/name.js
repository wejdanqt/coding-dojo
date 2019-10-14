var mongoose = require('mongoose');


const NamesSchema = new mongoose.Schema({
    name: String,
    created_on : {type: Date, default: Date.now },
 },{timestamps: true });


const Name = mongoose.model('Name', NamesSchema);
