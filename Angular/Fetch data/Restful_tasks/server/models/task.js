var mongoose = require('mongoose');


const TaskSchema = new mongoose.Schema({
    title: {type:String , default:''},
    description: {type: String, default: ''},
    completed:{type:Boolean, default:false},
    created_at : {type: Date, default: Date.now },
    updated_at : {type: Date, default: Date.now },
 },{timestamps: true });


const Task = mongoose.model('Task', TaskSchema);
