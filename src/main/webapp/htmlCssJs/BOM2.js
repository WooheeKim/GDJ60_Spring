const btn = document.getElementById("btn");
// row의 갯수
let r1 = document.getElementById("r1");
// column의 갯수
let c1 = document.getElementById("c1");

let t1 = document.getElementById("t1");

const s1 = document.getElementById("s1");

const ch = document.getElementsByClassName("ch");
// 배열
const options = document.getElementsByClassName("options");

const s2 = document.getElementById("s2");
const foods = document.getElementsByClassName("foods");

s1.addEventListener("click", function(){
    for(let i=0; i<options.length; i++) {
        if(options[i].selected) {
            console.log(options[i].value);
            break;
        }
    }
});

btn.addEventListener("click", function() {
    
    let result = '';

    for(let i=0;i<r1.value;i++) {
        result = result+"<tr>";
        for(let j=0;j<c1.value;j++) {
            result = result+"<td>";
            result = result+"</td>";    
        }
        result = result+"</tr>";
    }
    t1.innerHTML = result;
});

s2.addEventListener("click", function(){
    for(let i=0; i<foods.length; i++) {
        if(foods[i].checked) {
            console.log(foods[i].value);
            break;
        }
    }
});


for(let i=0; i<ch.length; i++) {
    ch[i].addEventListener("click", function() {
        console.log(this.checked);
        for(let j=0; j<ch.length; j++){
            ch[j].checked = this.checked;
        }
    })
};