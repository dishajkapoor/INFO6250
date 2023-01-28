const express = require('express'); 
const cors = require('cors');
const app = express();
const bodyParser = require('body-parser');
const { json } = require('express');
const port = 5000; 
app.use(cors());

var storage = [];
var who_won = [];
var disable_list = [];
var x_name = "Player";
var o_name = "Player";

app.listen(port, () => {
    console.log(`Now listening on port ${port}`); 
   });

app.post('/refreshScoreboard', () => {
    storage = []; 
    who_won = [];
    disable_list = [];
    x_name = "Player";
    o_name = "Player";
   });

app.post('/getScores', (req, res) => {
    var x_count = who_won.filter(x => x=="X").length 
    var o_count = who_won.filter(x => x=="O").length       
    var tie_count = who_won.filter(x => x=="tie").length 

    var counts = JSON.stringify({
        x_count : x_count,
        o_count : o_count,
        tie_count : tie_count
    })
    
    res.send(counts);
});

app.post('/enterNames', bodyParser.json(), (req, res) => {
    // names = req.body
    // console.log(req.body.name1 + "skjdbfhbkdjjk")
    if (req.body.name1 != ""){
        x_name = req.body.name1;
    }
    if (req.body.name2 != ""){
        o_name = req.body.name2;
    }
});

app.post('/getNames', (req, res) => {
    var response = JSON.stringify({
        "x_name" : x_name,
        "o_name" : o_name
    })
    // console.log("sdkfjnsf" + response)
    res.send(response);
});

app.post('/whoWon',bodyParser.json(), function (req, res) {
    storage = req.body
    // console.log("storage", storage)

    if (storage.b1 == 'X' && storage.b2 == 'X' && storage.b3 == 'X') {
        who_won.push("X");
        disable_list = ["b4", "b5", "b6", "b7", "b8", "b9"];
    }
    else if (storage.b1 == 'X' && storage.b4 == 'X' && storage.b7 == 'X') {
        disable_list = ["b2", "b5", "b6", "b3", "b8", "b9"];
        who_won.push("X");
    }
    else if (storage.b7 == 'X' && storage.b8 == 'X' && storage.b9 == 'X'){
        disable_list = ["b2", "b5", "b6", "b3", "b1", "b4"];
        who_won.push("X");
    }
    else if (storage.b3 == 'X' && storage.b6 == 'X' && storage.b9 == 'X') {
        disable_list = ["b2", "b5", "b8", "b7", "b1", "b4"];
        who_won.push("X");
    }
    else if (storage.b1 == 'X' && storage.b5 == 'X' && storage.b9 == 'X') {
        disable_list = ["b2", "b3", "b8", "b7", "b6", "b4"];
        who_won.push("X");
    }
    else if (storage.b3 == 'X' && storage.b5 == 'X' && storage.b7 == 'X') {
        disable_list = ["b1", "b2", "b8", "b9", "b6", "b4"];
        who_won.push("X");
    }
    else if (storage.b2 == 'X' && storage.b5 == 'X' && storage.b8 == 'X') {
        disable_list = ["b1", "b3", "b4", "b6", "b7", "b9"];
        who_won.push("X");
    }
    else if (storage.b4 == 'X' && storage.b5 == 'X' && storage.b6 == 'X') {
        disable_list = ["b8", "b7", "b9", "b1", "b2", "b3"];
        who_won.push("X");
    }

    else if (storage.b1 == 'O' && storage.b2 == 'O' && storage.b3 == 'O') {
        disable_list = ["b8", "b7", "b9", "b5", "b6", "b4"];
        who_won.push("O");
    }
    else if (storage.b1 == 'O' && storage.b4 == 'O' && storage.b7 == 'O') {
        disable_list = ["b8", "b2", "b9", "b5", "b6", "b3"];
        who_won.push("O");
    }
    else if (storage.b7 == 'O' && storage.b8 == 'O' && storage.b9 == 'O') {
        disable_list = ["b1", "b2", "b4", "b5", "b6", "b3"];
        who_won.push("O");
    }
    else if (storage.b3 == 'O' && storage.b6 == 'O' && storage.b9 == 'O') {
        disable_list = ["b1", "b2", "b4", "b5", "b8", "b7"];
        who_won.push("O");
    }
    else if (storage.b1 == 'O' && storage.b5 == 'O' && storage.b9 == 'O') {
        disable_list = ["b3", "b2", "b4", "b6", "b8", "b7"];
        who_won.push("O");
    }
    else if (storage.b3 == 'O' && storage.b5 == 'O' && storage.b7 == 'O') {
        who_won.push("O");
        disable_list = ["b1", "b2", "b4", "b6", "b8", "b9"];
    }
    else if (storage.b2 == 'O' && storage.b5 == 'O' && storage.b8 == 'O') {
        who_won.push("O");
        disable_list = ["b1", "b3", "b4", "b6", "b7", "b9"];
    }
    else if (storage.b4 == 'O' && storage.b5 == 'O' && storage.b6 == 'O') {
        who_won.push("O");
        disable_list = ["b1", "b2", "b3", "b7", "b8", "b9"];
    }
    else if ((storage.b1 == 'X' || storage.b1 == 'O') && (storage.b2 == 'X' || storage.b2 == 'O') && (storage.b3 == 'X' || storage.b3 == 'O') &&
    (storage.b4 == 'X' || storage.b4 == 'O') && (storage.b5 == 'X' || storage.b5 == 'O') && (storage.b6 == 'X' || storage.b6 == 'O') &&
    (storage.b7 == 'X' || storage.b7 == 'O') && (storage.b8 == 'X' || storage.b8 == 'O') && (storage.b9 == 'X' || storage.b9 == 'O')) {
        who_won.push("tie");
    }
    else {
        who_won.push("none");
    }
    var response = JSON.stringify({
        "disable_list" : disable_list,
        "who_won" : who_won
    })
    res.send(response);
});