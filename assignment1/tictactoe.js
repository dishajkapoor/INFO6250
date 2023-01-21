flag = 1;
// console.log("sdkjb" + localStorage.getItem("X") + typeof localStorage.getItem("X"));

// reset_func();

if(localStorage.getItem("X") === null){
    // console.log("Inside")
    localStorage.setItem("X", 0)
    // document.querySelector('#player_x').innerHTML = localStorage.getItem("X")
}
if(localStorage.getItem("O") === null){
    localStorage.setItem("O", 0)
    // document.getElementById("player_o").innerHTML = 0;
}
if(localStorage.getItem("tie") === null){
    localStorage.setItem("tie", 0)
    // document.getElementById("tie").innerHTML = 0;
}

if (localStorage.getItem("start_game") === null){
    localStorage.setItem("start_game", 0)
}

if (parseInt(localStorage.getItem("start_game")) != 0){
    document.getElementById("name_one").innerHTML = "";
    document.getElementById("name_two").innerHTML = "";
    document.getElementById("enter").innerHTML = "";
}   

document.getElementById("player_x").innerText = parseInt(localStorage.getItem("X"));
document.getElementById("player_o").innerHTML = parseInt(localStorage.getItem("O"));
document.getElementById("tie").innerHTML = parseInt(localStorage.getItem("tie"));

document.getElementById("b1").disabled = true;
document.getElementById("b3").disabled = true;
document.getElementById("b4").disabled = true;
document.getElementById("b5").disabled = true;
document.getElementById("b6").disabled = true;
document.getElementById("b7").disabled = true;
document.getElementById("b8").disabled = true;
document.getElementById("b9").disabled = true;
document.getElementById("b2").disabled = true;
document.getElementById("resetButton").disabled = true;

console.log ("name 1" + localStorage.getItem("name1") + typeof localStorage.getItem("name1"))

if (localStorage.getItem("name1") === null){
    localStorage.setItem("name1", "Player")
}

if (localStorage.getItem("name2") === null){
    localStorage.setItem("name2", "Player")
}

    document.getElementById("player_x_name").innerHTML = localStorage.getItem("name1") + "(X)";
    // document.getElementById("name_one").innerHTML = "";
    // document.getElementById("name_two").innerHTML = "";
    // document.getElementById("enter").innerHTML = "";


    document.getElementById("player_o_name").innerHTML = localStorage.getItem("name2") + "(O)";
    // 
    // }
// else{
//     localStorage.setItem("name2", "Player O")
// }

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
    document.getElementById("resetButton").disabled = false;
    // document.getElementById("resetScoreboardButton").disabled = false;
    document.getElementById("startButton").disabled = true;

    document.getElementById("info").innerHTML = "Game Started! Good Luck."

    localStorage.setItem("start_game", parseInt(localStorage.getItem("start_game"))+1)
}


function scoreboard_update(param){
    if(localStorage.getItem("X") === null){
        localStorage.setItem("X", 0)
    }
    if(localStorage.getItem("O") === null){
        localStorage.setItem("O", 0)
    }
    if(localStorage.getItem("tie") === null){
        localStorage.setItem("tie", 0)
    }
    if (param === "X"){
        var score = parseInt(localStorage.getItem("X"))+1;
        // console.log("score"+ localStorage.getItem("X"))
        localStorage.setItem("X", score)
        
    }
    else if (param === "O"){
        var score = parseInt(localStorage.getItem("O"))+1;
        // console.log("score"+ localStorage.getItem("O"))
        localStorage.setItem("O", score)
    }
    else if (param === "tie"){
        var score = parseInt(localStorage.getItem("tie"))+1;
        // console.log("score"+ localStorage.getItem("tie"))
        localStorage.setItem("tie", score)
    }
    document.getElementById("player_x").innerHTML = localStorage.getItem("X");
    document.getElementById("player_o").innerHTML = localStorage.getItem("O");  
    document.getElementById("tie").innerHTML = localStorage.getItem("tie");  

}

function enter_name(){
    name1 = document.getElementById("name1").value;
    name2 = document.getElementById("name2").value;
    // console.log(typeof name1 + name2)
    document.getElementById("name_one").innerHTML = "";
    document.getElementById("name_two").innerHTML = "";
    document.getElementById("enter").innerHTML = ""
    if (name1 != ""){
        localStorage.setItem("name1", name1)
        document.getElementById("player_x_name").innerHTML = name1 + "(X)";
    }
    
    if (name2 != ""){
        localStorage.setItem("name2", name2)
        document.getElementById("player_o_name").innerHTML = name2 + "(O)";
    }
}

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
    var b1, b2, b3, b4, b5, b6, b7, b8, b9;
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
        scoreboard_update("X");
    }
    else if (b1 == 'X' && b4 == 'X' && b7 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update("X");
    }
    else if (b7 == 'X' && b8 == 'X' && b9 == 'X'){
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b6").disabled = true;
        scoreboard_update("X");
    }
    else if (b3 == 'X' && b6 == 'X' && b9 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        scoreboard_update("X");
    }
    else if (b1 == 'X' && b5 == 'X' && b9 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        scoreboard_update("X");
    }
    else if (b3 == 'X' && b5 == 'X' && b7 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update("X");
    }
    else if (b2 == 'X' && b5 == 'X' && b8 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update("X");
    }
    else if (b4 == 'X' && b5 == 'X' && b6 == 'X') {
        document.getElementById('final').innerHTML = "Player X (" + localStorage.getItem("name1") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update("X");
    }

    else if (b1 == 'O' && b2 == 'O' && b3 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b4").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update("O");
    }
    else if (b1 == 'O' && b4 == 'O' && b7 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update("O");
    }
    else if (b7 == 'O' && b8 == 'O' && b9 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b6").disabled = true;
        scoreboard_update("O");
    }
    else if (b3 == 'O' && b6 == 'O' && b9 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b5").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        scoreboard_update("O");
    }
    else if (b1 == 'O' && b5 == 'O' && b9 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        scoreboard_update("O");
    }
    else if (b3 == 'O' && b5 == 'O' && b7 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update("O");
    }
    else if (b2 == 'O' && b5 == 'O' && b8 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b4").disabled = true;
        document.getElementById("b6").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update("O");
    }
    else if (b4 == 'O' && b5 == 'O' && b6 == 'O') {
        document.getElementById('final').innerHTML = "Player O (" + localStorage.getItem("name2") +") won. Please hit reset button to play again!";
        document.getElementById("b1").disabled = true;
        document.getElementById("b2").disabled = true;
        document.getElementById("b3").disabled = true;
        document.getElementById("b7").disabled = true;
        document.getElementById("b8").disabled = true;
        document.getElementById("b9").disabled = true;
        scoreboard_update("O");
    }
    else if ((b1 == 'X' || b1 == 'O') && (b2 == 'X' || b2 == 'O') && (b3 == 'X' || b3 == 'O') &&
    (b4 == 'X' || b4 == 'O') && (b5 == 'X' || b5 == 'O') && (b6 == 'X' || b6 == 'O') &&
    (b7 == 'X' || b7 == 'O') && (b8 == 'X' || b8 == 'O') && (b9 == 'X' || b9 == 'O')) {
        document.getElementById('final').innerHTML = "It's a tie. Please hit reset button to play again!";
        scoreboard_update("tie");
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
}

function reset_func() {
    location.reload();
}

function reset_scoreboard() {
    localStorage.setItem("X", 0)
    localStorage.setItem("O", 0)
    localStorage.setItem("tie", 0)
    localStorage.setItem("name1", "Player")
    localStorage.setItem("name2", "Player")
    localStorage.setItem("start_game", 0)
    location.reload();
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