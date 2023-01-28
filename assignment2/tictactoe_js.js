document.getElementById("b1").disabled = true;
document.getElementById("b3").disabled = true;
document.getElementById("b4").disabled = true;
document.getElementById("b5").disabled = true;
document.getElementById("b6").disabled = true;
document.getElementById("b7").disabled = true;
document.getElementById("b8").disabled = true;
document.getElementById("b9").disabled = true;
document.getElementById("b2").disabled = true;


if(localStorage.getItem("X") === null){
    localStorage.setItem("X", 0)
}
if(localStorage.getItem("O") === null){
    localStorage.setItem("O", 0)
}
if(localStorage.getItem("tie") === null){
    localStorage.setItem("tie", 0)
}
if (localStorage.getItem("start_game") === null){
    localStorage.setItem("start_game", 0)
}
if (localStorage.getItem("name1") === null){
    localStorage.setItem("name1", "Player")
}
if (localStorage.getItem("name2") === null){
    localStorage.setItem("name2", "Player")
}

// console.log("kasjsdkj" + localStorage.getItem("start_game"))
if (parseInt(localStorage.getItem("start_game")) == 0){
    // console.log("first time")
    // document.getElementById("playBoard").style.display = "none";
    // document.getElementById("b1").style.display = "none";
    // document.getElementById("b2").style.display = "none";
    // document.getElementById("b3").style.display = "none";
    // document.getElementById("b4").style.display = "none";
    // document.getElementById("b5").style.display = "none";
    // document.getElementById("b6").style.display = "none";
    // document.getElementById("b7").style.display = "none";
    // document.getElementById("b8").style.display = "none";
    // document.getElementById("b9").style.display = "none";
    document.getElementById("first").style.display = "none";
    document.getElementById("second").style.display = "none";
    document.getElementById("third").style.display = "none";

    document.getElementById("resetButton").style.display = "none";
    document.getElementById("startButton").style.display = "none";
    document.getElementById("scoreboardDiv").style.display = "none";
} 
else{
    document.getElementById("nameDiv").style.display = "none";
    get_scores();
    get_names();
    document.getElementById("resetButton").style.display = "none";
    document.getElementById("info").innerHTML = "X goes first and then O. Hit START to start playing."
    // document.getElementById("playBoard").style.display = "inline"
    // document.getElementById("b1").style.display = "block";
    // document.getElementById("b2").style.display = "block";
    
    // document.getElementById("b3").style.display = "block";
    // document.getElementById("b4").style.display = "block";
    // document.getElementById("b5").style.display = "block";
    // document.getElementById("b6").style.display = "block";
    // document.getElementById("b7").style.display = "block";
    // document.getElementById("b8").style.display = "block";
    // document.getElementById("b9").style.display = "block";

    document.getElementById("first").style.display = "inline-flex";
    document.getElementById("second").style.display = "inline-flex";
    document.getElementById("third").style.display = "inline-flex";
}

var o_name = "Player";
var x_name = "Player";

var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

function get_scores(){
    var requestOptions3 = {
        method: "GET",
        headers: myHeaders
    };
    fetch ("http://localhost:5000/getScores", requestOptions3)
        .then(async (response) => {
            const data = await response.json();
            document.getElementById("player_x").innerHTML = data.x_count;
            document.getElementById("player_o").innerHTML = data.o_count;
            document.getElementById("tie").innerHTML = data.tie_count;
        })
        .catch((error) => {
            console.log(typeof(error) + "offline game..");
            var a = [];
            Object.entries(error).forEach(itm=>a.push({key: itm[0], value: itm[1]}));
            console.log(a);
            document.getElementById("player_x").innerText = parseInt(localStorage.getItem("X"));
            document.getElementById("player_o").innerHTML = parseInt(localStorage.getItem("O"));
            document.getElementById("tie").innerHTML = parseInt(localStorage.getItem("tie"));
        });
}

function get_names(){
    var requestOptions5 = {
        method: "GET",
        headers: myHeaders
    };
    fetch("http://localhost:5000/getNames", requestOptions5)
        .then(async (response) => {
            var data2 = await response.json();
            document.getElementById("player_x_name").innerHTML = data2.x_name + "(X)";
            document.getElementById("player_o_name").innerHTML = data2.o_name + "(O)";
        })
        .catch((error) => {
            console.log(error.body + "offline game..");
            document.getElementById("player_x_name").innerHTML = localStorage.getItem("name1") + "(X)";
            document.getElementById("player_o_name").innerHTML = localStorage.getItem("name2") + "(O)";
        });
}

flag = 1;
function b1_func() {
    if (flag == 1) {
        document.getElementById("b1").value = "X";
        document.getElementById("b1").disabled = true;
        flag = 0;
    }
    else {
        document.getElementById("b1").value = "O";
        document.getElementById("b1").disabled = true;
        flag = 1;
    }
}
function b2_func() {
    console.log("kjnf")
    if (flag == 1) {
        document.getElementById("b2").value = "X";
        document.getElementById("b2").disabled = true;
        flag = 0;
    }
    else {
        document.getElementById("b2").value = "O";
        document.getElementById("b2").disabled = true;
        flag = 1;
    }
}
function b3_func() {
    if (flag == 1) {
        document.getElementById("b3").value = "X";
        document.getElementById("b3").disabled = true;
        flag = 0;
    }
    else {
        document.getElementById("b3").value = "O";
        document.getElementById("b3").disabled = true;
        flag = 1;
    }
}
function b4_func() {
    if (flag == 1) {
        document.getElementById("b4").value = "X";
        document.getElementById("b4").disabled = true;
        flag = 0;
    }
    else {
        document.getElementById("b4").value = "O";
        document.getElementById("b4").disabled = true;
        flag = 1;
    }
}
function b5_func() {
    if (flag == 1) {
        document.getElementById("b5").value = "X";
        document.getElementById("b5").disabled = true;
        flag = 0;
    }
    else {
        document.getElementById("b5").value = "O";
        document.getElementById("b5").disabled = true;
        flag = 1;
    }
}
function b6_func() {
    if (flag == 1) {
        document.getElementById("b6").value = "X";
        document.getElementById("b6").disabled = true;
        flag = 0;
    }
    else {
        document.getElementById("b6").value = "O";
        document.getElementById("b6").disabled = true;
        flag = 1;
    }
}
function b7_func() {
    if (flag == 1) {
        document.getElementById("b7").value = "X";
        document.getElementById("b7").disabled = true;
        flag = 0;
    }
    else {
        document.getElementById("b7").value = "O";
        document.getElementById("b7").disabled = true;
        flag = 1;
    }
}
function b8_func() {
    if (flag == 1) {
        document.getElementById("b8").value = "X";
        document.getElementById("b8").disabled = true;
        flag = 0;
    }
    else {
        document.getElementById("b8").value = "O";
        document.getElementById("b8").disabled = true;
        flag = 1;
    }
}
function b9_func() {
    if (flag == 1) {
        document.getElementById("b9").value = "X";
        document.getElementById("b9").disabled = true;
        flag = 0;
    }
    else {
        document.getElementById("b9").value = "O";
        document.getElementById("b9").disabled = true;
        flag = 1;
    }
}

function main_func(){
    var raw = JSON.stringify({
        b1 : document.getElementById("b1").value,
        b2 : document.getElementById("b2").value,
        b3 : document.getElementById("b3").value,
        b4 : document.getElementById("b4").value,
        b5 : document.getElementById("b5").value,
        b6 : document.getElementById("b6").value,
        b7 : document.getElementById("b7").value,
        b8 : document.getElementById("b8").value,
        b9 : document.getElementById("b9").value,
    });
    var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
    };

    fetch("http://localhost:5000/whoWon", requestOptions)
        .then(async (response) => {
          const data = await response.json();
          who_won_result(data)
        })
        .catch((error) => {
            console.log("offline game" + error)
            play_offline()
        });
}

function who_won_result(data){
    // names = get_names();
    var requestOptions5 = {
        method: "POST",
        headers: myHeaders
    };
    fetch("http://localhost:5000/getNames", requestOptions5)
        .then(async (response) => {
            var data = await response.json();
            x_name = data.x_name
            o_name = data.o_name
    })

    if (data.who_won[data.who_won.length-1] == "X"){
        document.getElementById('final').innerHTML = "X ("+ x_name +") won! Please hit RESET to play again.";
        disable_tiles(data.disable_list)
        get_scores();
    }        
    else if (data.who_won[data.who_won.length-1] == "O"){
        document.getElementById('final').innerHTML = "O ("+ o_name +") won! Please hit RESET to play again. ";
        disable_tiles(data.disable_list)
        get_scores();
    }
    else if (data.who_won[data.who_won.length-1] == "tie"){
        document.getElementById('final').innerHTML = "It's a tie. Please hit RESET to play again. ";
        get_scores();
    }
    else{
        if(flag == 1){
        document.getElementById('final').innerHTML = "X ("+x_name+")'s turn";
        }
        else{
        document.getElementById('final').innerHTML = "O ("+o_name+")'s turn";
        }
    }
}

function disable_tiles(disable_list){
    for(let i = 0; i<disable_list.length; i ++){
        document.getElementById(disable_list[i]).disabled = true;
    }
}

function reset_func() {
    // location.reload();
    document.getElementById("startButton").style.display = "block";
    document.getElementById("resetButton").style.display = "none";
    // document.getElementById("playBoard").style.display = "inline-flex";
    document.getElementById("nameDiv").style.display = "none";
    document.getElementById("scoreboardDiv").style.display = "block";

    // document.getElementById("b1").style.display = "block";
    // document.getElementById("b2").style.display = "block";
    // document.getElementById("b3").style.display = "block";
    // document.getElementById("b4").style.display = "block";
    // document.getElementById("b5").style.display = "block";
    // document.getElementById("b6").style.display = "block";
    document.getElementById("first").style.display = "inline-flex";
    document.getElementById("second").style.display = "inline-flex";
    document.getElementById("third").style.display = "inline-flex";

    document.getElementById("b1").value = "";
    document.getElementById("b2").value = "";
    document.getElementById("b3").value = "";
    document.getElementById("b4").value = "";
    document.getElementById("b5").value = "";
    document.getElementById("b6").value = "";
    document.getElementById("b7").value = "";
    document.getElementById("b8").value = "";
    document.getElementById("b9").value = "";
    document.getElementById("final").innerHTML = "";
    document.getElementById("info").innerHTML = "X goes first and then O. Hit START to start playing!"
    flag = 1;

    document.getElementById("b1").disabled = true;
    document.getElementById("b3").disabled = true;
    document.getElementById("b4").disabled = true;
    document.getElementById("b5").disabled = true;
    document.getElementById("b6").disabled = true;
    document.getElementById("b7").disabled = true;
    document.getElementById("b8").disabled = true;
    document.getElementById("b9").disabled = true;
    document.getElementById("b2").disabled = true;
}

function start_func(){
    document.getElementById("b1").disabled = false;
    document.getElementById("b3").disabled = false;
    document.getElementById("b4").disabled = false;
    document.getElementById("b5").disabled = false;
    document.getElementById("b6").disabled = false;
    document.getElementById("b7").disabled = false;
    document.getElementById("b8").disabled = false;
    document.getElementById("b9").disabled = false;
    document.getElementById("b2").disabled = false;
    document.getElementById("resetButton").style.display = "block";
    document.getElementById("resetButton").disabled = false;
    document.getElementById("startButton").style.display = "none";
    document.getElementById("info").innerHTML = "Game Started! Good Luck."
    // localStorage.setItem("start_game", parseInt(localStorage.getItem("start_game"))+1)
}

function reset_scoreboard(){
    var requestOptions2 = {
        method: "GET",
        headers: myHeaders
    };
    fetch("http://localhost:5000/refreshScoreboard", requestOptions2)
        
    .then(async (response) => {
        // console.log("sjdfh")
        
        document.getElementById("resetButton").style.display = "none";
        document.getElementById("startButton").style.display = "none";
        document.getElementById("scoreboardDiv").style.display = "none";
        document.getElementById("nameDiv").style.display = "block"
        // document.getElementById("playBoard").style.display = "none";
    //     document.getElementById("b1").style.display = "none";
    //     document.getElementById("b2").style.display = "none";
    //     document.getElementById("b3").style.display = "none";
    // document.getElementById("b4").style.display = "none";
    // document.getElementById("b5").style.display = "none";
    // document.getElementById("b6").style.display = "none";
    // document.getElementById("b7").style.display = "none";
    // document.getElementById("b8").style.display = "none";
    // document.getElementById("b9").style.display = "none";

    document.getElementById("first").style.display = "none";
    document.getElementById("second").style.display = "none";
    document.getElementById("third").style.display = "none";

    })
    .catch((error) => {
            localStorage.setItem("X", 0)
            localStorage.setItem("O", 0)
            localStorage.setItem("tie", 0)
            localStorage.setItem("name1", "Player")
            localStorage.setItem("name2", "Player")
            localStorage.setItem("start_game", 0)
            location.reload();
    });

    get_scores();
    get_names();
    // reset_func();
}

function play_offline(){
    let b1, b2, b3, b4, b5, b6, b7, b8, b9;
    b1 = document.getElementById("b1").value;
    b2 = document.getElementById("b2").value;
    b3 = document.getElementById("b3").value;
    b4 = document.getElementById("b4").value;
    b5 = document.getElementById("b5").value;
    b6 = document.getElementById("b6").value;
    b7 = document.getElementById("b7").value;
    b8 = document.getElementById("b8").value;
    b9 = document.getElementById("b9").value;

    if (b1 == 'X' && b2 == 'X' && b3 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b4").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update_offline("X");
    }
    else if (b1 == 'X' && b4 == 'X' && b7 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update_offline("X");
    }
    else if (b7 == 'X' && b8 == 'X' && b9 == 'X'){
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b6").disabled = true;
        scoreboard_update_offline("X");
    }
    else if (b3 == 'X' && b6 == 'X' && b9 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        scoreboard_update_offline("X");
    }
    else if (b1 == 'X' && b5 == 'X' && b9 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        scoreboard_update_offline("X");
    }
    else if (b3 == 'X' && b5 == 'X' && b7 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update_offline("X");
    }
    else if (b2 == 'X' && b5 == 'X' && b8 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update_offline("X");
    }
    else if (b4 == 'X' && b5 == 'X' && b6 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update_offline("X");
    }

    else if (b1 == 'O' && b2 == 'O' && b3 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b4").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update_offline("O");
    }
    else if (b1 == 'O' && b4 == 'O' && b7 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update_offline("O");
    }
    else if (b7 == 'O' && b8 == 'O' && b9 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b6").disabled = true;
        scoreboard_update_offline("O");
    }
    else if (b3 == 'O' && b6 == 'O' && b9 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        scoreboard_update_offline("O");
    }
    else if (b1 == 'O' && b5 == 'O' && b9 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        scoreboard_update_offline("O");
    }
    else if (b3 == 'O' && b5 == 'O' && b7 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update_offline("O");
    }
    else if (b2 == 'O' && b5 == 'O' && b8 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update_offline("O");
    }
    else if (b4 == 'O' && b5 == 'O' && b6 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update_offline("O");
    }
    else if ((b1 == 'X' || b1 == 'O') && (b2 == 'X' || b2 == 'O') && (b3 == 'X' || b3 == 'O') &&
    (b4 == 'X' || b4 == 'O') && (b5 == 'X' || b5 == 'O') && (b6 == 'X' || b6 == 'O') &&
    (b7 == 'X' || b7 == 'O') && (b8 == 'X' || b8 == 'O') && (b9 == 'X' || b9 == 'O')) {
        document.getElementById('final').innerHTML = "It's a tie. Please hit reset button to play again!";
        scoreboard_update_offline("tie");
    }
    else {
        if (flag == 1) {
            console.log("x" + localStorage.getItem("name1"))
            document.getElementById('final').innerHTML = localStorage.getItem("name1") + "'s (X) turn";
        }
        else {
            console.log("o" + localStorage.getItem("name2"))
            document.getElementById('final').innerHTML = localStorage.getItem("name2") + "'s (O) turn";
        }
    }

    function scoreboard_update_offline(param){
        console.log("HEREEEE");
        // if(localStorage.getItem("X") === null){
        //     localStorage.setItem("X", 0)
        // }
        // if(localStorage.getItem("O") === null){
        //     localStorage.setItem("O", 0)
        // }
        // if(localStorage.getItem("tie") === null){
        //     localStorage.setItem("tie", 0)
        // }
        if (param === "X"){
            let score = parseInt(localStorage.getItem("X"))+1;
            localStorage.setItem("X", score)
        }
        else if (param === "O"){
            let score = parseInt(localStorage.getItem("O"))+1;
            localStorage.setItem("O", score)
        }
        else if (param === "tie"){
            let score = parseInt(localStorage.getItem("tie"))+1;
            localStorage.setItem("tie", score)
        }
        document.getElementById("player_x").innerHTML = localStorage.getItem("X");
        document.getElementById("player_o").innerHTML = localStorage.getItem("O");  
        document.getElementById("tie").innerHTML = localStorage.getItem("tie");  
    }
}

function enter_name(){
    var name1 = document.getElementById("name1").value
    var name2 = document.getElementById("name2").value
    var names12 = JSON.stringify({
        name1: name1,
        name2: name2
    });

    var requestOptions4 ={
        method: "POST",
        headers: myHeaders,
        body: names12,
    }; 

    fetch ("http://localhost:5000/enterNames", requestOptions4)
        .catch((error) => {
            console.log("offline" + error)
            if (name1 != ""){
                localStorage.setItem("name1", name1)
            }
            
            if (name2 != ""){
                localStorage.setItem("name2", name2)
            }
    });
    get_names();

    // document.getElementById("b1").style.display = "block";
    // document.getElementById("b3").style.display = "block";
    // document.getElementById("b4").style.display = "block";
    // document.getElementById("b5").style.display = "block";
    // document.getElementById("b6").style.display = "block";
    // document.getElementById("b7").style.display = "block";
    // document.getElementById("b8").style.display = "block";
    // document.getElementById("b9").style.display = "block";
    // document.getElementById("b2").style.display = "block";

    document.getElementById("first").style.display = "inline-flex";
    document.getElementById("second").style.display = "inline-flex";
    document.getElementById("third").style.display = "inline-flex";

    document.getElementById("startButton").style.display = "block";
    document.getElementById("scoreboardDiv").style.display = "block";
    document.getElementById("nameDiv").style.display = "none";
    document.getElementById("info").innerHTML = "X goes first and then O. Hit START to start playing!"

    get_scores();
    get_names();
    console.log("names added")
    localStorage.setItem("start_game", parseInt(localStorage.getItem("start_game"))+1);
}