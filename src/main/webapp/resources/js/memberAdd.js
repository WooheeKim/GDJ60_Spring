const id = document.getElementById("id");
const idResult = document.getElementById("idResult");

const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");

const pwCheck = document.getElementById("pwCheck");
const pwCheckResult = document.getElementById("pwCheckResult");

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

const name = document.getElementById("name");
const nameResult = document.getElementById("nameResult");

const phone = document.getElementById("phone");
const phoneResult = document.getElementById("phoneResult");

const email = document.getElementById("email");
const emailResult = document.getElementById("emailResult");

const address = document.getElementById("address");
const addressResult = document.getElementById("addressResult");

// ID 검증
id.addEventListener("blur", function() {
    if(id.value.length==0) {
        idResult.innerHTML="아이디는 필수 입력입니다."
    } else {
        idResult.innerHTML='';
    }
});

// PW 검증
pw.addEventListener("keyup", function() {
    if(pw.value.length>5 && pw.value.length<13) {
        pwResult.innerHTML='정상적입니다.'
    } else {
        pwResult.innerHTML='비밀번호는 6글자 이상 12글자 이하여야 합니다.'
    }
});

pw.addEventListener("blur", function() {
    if(pw.value.length==0) {
        pwResult.innerHTML='비밀번호는 필수 입력입니다.'
    }
});

// PW Equal 검증
pwCheck.addEventListener("blur", function() {
    if(pw.value == pwCheck.value) {
        pwCheckResult.innerHTML='비밀번호가 일치합니다.'
    } else {
        pwCheckResult.innerHTML='비밀번호가 일치하지 않습니다.'
    }
});

// form 전송
btn.addEventListener("click", function() {
    frm.submit();
    if(btn.value.click) {
        
    }
});

// 이름 검증
name.addEventListener("blur", function() {
    if(name.value.length==0) {
        nameResult.innerHTML="이름은 필수 입력입니다."
    } else {
        nameResult.innerHTML='';
    }
});

// 번호 검증
phone.addEventListener("blur", function() {
    if(phone.value.length==0) {
        phoneResult.innerHTML="번호는 필수 입력입니다."
    } else {
        phoneResult.innerHTML='';
    }
});

// 이메일 검증
email.addEventListener("blur", function() {
    if(email.value.length==0) {
        emailResult.innerHTML="이메일은 필수 입력입니다."
    } else {
        emailResult.innerHTML='';
    }
});


// 주소 검증
address.addEventListener("blur", function() {
    if(address.value.length==0) {
        addressResult.innerHTML="주소는 필수 입력입니다."
    } else {
        addressResult.innerHTML='';
    }
});
