const fileList = document.getElementById("fileList");
const fileAdd = document.getElementById("fileAdd");

let count = 0;
let max = 5;
let param = files;

function setParam(p) {
    param = p;
}

function setMax(m) {
    max = m;
}

fileAdd.addEventListener('click', function(){
    if(count>=max) {
        alert('첨부파일은 최대 '+max+'개입니다.');
        return;
    }
    count++;

    // Element, Text 생성
    let d = document.createElement('div'); // 부모 div
    let l = document.createElement('label'); // label
    let t = document.createTextNode('이미지');
    let i = document.createElement('input'); // input
    let b = document.createElement('button'); // button
    let x = document.createTextNode('X');

    // Element 조합
    d.appendChild(l);
    d.appendChild(i);
    d.appendChild(b);
    l.appendChild(t);
    b.appendChild(x);

    // attribute 생성 적용
    // div
    let attr = document.createAttribute("class");
    attr.value = 'row mb-3';
    d.setAttributeNode(attr);

    // label
    attr = document.createAttribute("class");
    attr.value = 'form-label';
    l.setAttributeNode(attr);

    attr = document.createAttribute("for");
    attr.value = 'files';
    l.setAttributeNode(attr);

    // input
    attr = document.createAttribute("type");
    attr.value = "file";
    i.setAttributeNode(attr);

    attr = document.createAttribute("class");
    attr.value = 'form-label';
    i.setAttributeNode(attr);

    attr = document.createAttribute("id");
    attr.value = 'files';
    i.setAttributeNode(attr);

    attr = document.createAttribute("name");
    attr.value = param;
    i.setAttributeNode(attr);

    // button
    attr = document.createAttribute("type");
    attr.value = "button"
    b.setAttributeNode(attr);

    fileList.prepend(d);
});

