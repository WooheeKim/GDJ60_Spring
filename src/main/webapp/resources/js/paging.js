const pl = document.getElementsByClassName("page-link");
const searchForm = document.getElementById("searchForm");
// for
// for of

for(let p of pl) {
    p.addEventListener("click",function(e) {
        p.getAttribute('data-board-page')
        p.setAttribute('page')
        searchForm.submit();
    })
}
