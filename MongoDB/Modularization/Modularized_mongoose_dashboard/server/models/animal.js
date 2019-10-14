var mongoose = require('mongoose');

const AnimalSchema = new mongoose.Schema({
    name: String,
    favorite_food: String,
    created_on: { type: Date, default: Date.now },
}, { timestamps: true });

const Animal = mongoose.model('Animal', AnimalSchema);