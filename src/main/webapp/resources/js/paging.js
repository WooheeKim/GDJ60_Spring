const pl = document.getElementsByClassName("page-link");
const searchForm = document.getElementById("searchForm");
const page = document.getElementById("page");
// for
// for of

for(let p of pl) {
    p.addEventListener("click",function(e) {
        p.getAttribute('data-board-page')
        page.value = v;
        searchForm.submit();
    })
}

let data = '';
function setData(d) {
    data = d;
}
