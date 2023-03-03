// css 선택자 유형
const btn1 = document.querySelector("#btn1"); //document.getElementById("btn1");

// querySelector == querySelectorAll[0];

const buttons = document.querySelectorAll(".buttons"); //document.getElementsByClassName("buttons");

const d1 = document.querySelector("#d1 > .buttons li");

console.log('Old');
for(let i=0;i<Array.length;i++) {
    console.log(ar[i]);
}

console.log('For of');
for(let a of ar) {
    console.log(a);
}

console.log('For in');
for(let j in ar);

console.log('For each');
ar.forEach(function(v, i, list){
    console.log();
});


btn1.addEventListener("click", function(){
    console.log("btn1");
});

for(let b of buttons) {
    b.addEventListener("click", function(){
        console.log("buttons")
    });
}

alert(buttons);
alert(ar);
console.log(buttons);
console.log(ar);

buttons.forEach(function)

