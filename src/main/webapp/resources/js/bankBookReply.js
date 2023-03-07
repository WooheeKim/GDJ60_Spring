const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentListResult = document.getElementById("commentListResult");
//const pageLink = document.querySelectorAll(".page-link");


// 댓글 등록
replyAdd.addEventListener("click", function(){
    console.log("num : "+replyAdd.getAttribute('data-book-bookNumber'));

    // JS에서 사용 할 가상의 Form 태그 생성
    const form = new FormData(); // <form></form>
    form.append("contents", replyContents.value); //<form><input type="text" name="contents" value="asdf"></form> 
    form.append("bookNumber", replyAdd.getAttribute('data-book-bookNumber')) // <form><input type="text" name="contents" value="asdf"><input type="text" name="bookNumber" value="asdf"></form> 

    fetch('../bankBookComment/add', {
        method:'POST',
        //headers:{"Content-type": "application/x-www-form-urlencoded"},
        body:form,
    }).then((response)=> response.text())
    .then((res)=>{
        if(res.trim()==1){
            alert('댓글이 등록 되었습니다.')
            replyContents.value="";
            getList(1);
        } else {
            alert('댓글 등록에 실패 했습니다.')
        }
    }).catch(()=>{
        console.log('error 발생');
    });

    // let xhttp = new XMLHttpRequest();

    // xhttp.open("POST", "../bankBookComment/add");

    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // xhttp.send("contents="+replyContents.value+"&bookNumber="+replyAdd.getAttribute('data-book-bookNumber'));

    // xhttp.addEventListener('readystatechange', function(){
    //     if(this.readyState==4 && this.status==200) {
    //         if(this.responseText.trim()==1){
    //             alert("댓글이 등록 되었습니다.");
    //             replyContents.value="";
    //             getList();
    //         } else {
    //             alert("댓글 등록에 실패 했습니다.");
    //         }
    //     }
    // });

})

// List
getList(1);

function getList(page) {

    fetch("/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-bookNumber')+"&page="+page, {
        method:'GET',
        // GET과 HEAD 메서드는 body 속성을 가질 수 없음
    })
    .then((response)=>response.text())
    .then((res)=>{
        commentListResult.innerHTML=this.res.trim();
    })

    // let count = 0;

    // let xhttp = new XMLHttpRequest();

    // xhttp.open("GET", "/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-bookNumber')+"&page="+page);

    // xhttp.addEventListener('readystatechange', function() {
    //     if(this.readyState==4 && this.status==200) {            
    //         commentListResult.innerHTML=this.responseText.trim();
    //         count++;
    //     }
    // })
    
    // xhttp.send();
    
    // // 0이 출력 : 비동기 방식이기 때문에
    // console.log("count : ", count);

}

// page
commentListResult.addEventListener("click",function(e){
    let pageLink = e.target;
    if(pageLink.classList.contains("page-link")) {
        let page = pageLink.getAttribute("data-board-page");
        getList(page);
    } 

    e.preventDefault();
});

// delete
commentListResult.addEventListener("click",function(e){
    let del = e.target;
    if(del.classList.contains("del")) {
        fetch("../bankBookComment/delete", {
            method:'POST',
            headers:{
                "Content-type": "application/x-www-form-urlencoded"
            },
            body:"num="+del.getAttribute("data-comment-num")
            // 응답객체에서 Data 추출
        }).then((response)=>response.text())//then(function(response){return response.text()})
            // 추출한 Data 사용
          .then((res)=>{
            if(res.trim()>0){
                alert("댓글이 삭제되었습니다.");
                getList(1);
            } else {
                alert("삭제를 실패했습니다.");
            }
        }).catch(()=>{
            alert('삭제 실패');
        });
        

        // let xhttp = new XMLHttpRequest();
        // xhttp.open("POST", "../bankBookComment/delete");
        // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        // xhttp.send("num="+del.getAttribute("data-comment-num"));
        // xhttp.addEventListener('readystatechange', function() {
        //     if(this.readyState==4 && this.status==200) {            
        //         let result = this.responseText.trim();
        //         if(result>0){
        //             alert("댓글이 삭제되었습니다.");
        //             getList(1);
        //         } else {
        //             alert("삭제를 실패했습니다.")
        //         }
        //     }
        // })
    }

    e.preventDefault();
});

// Update
commentListResult.addEventListener("click",function(e){
    let updateButton = e.target;
    if(updateButton.classList.contains("update")) {
    //     fetch("../bankBookComment/update", {
    //         method:'POST',
    //         headers:{
    //             "Content-type": "application/x-www-form-urlencoded"
    //         },
    //         body:"num="+num+"&contents="+updateButton
    //     }).then((response)=>response.text())
    //       .then((res)=>{
    //         if(res.trim()>0){
    //             alert("수정 성공");
    //             getList(1);
    //         } else {
    //             alert("수정 실패");
    //         }
    //     }).catch(()=>{
    //         alert('삭제 실패');
    //     });
        


        // console.log(updateButton.parentNode.previousSibling.previousSibling.previousSibling.previousSibling);
        let num = updateButton.getAttribute("data-comment-num");
        let contents = document.getElementById("contents"+num);
        console.log(contents);
        // contents.innerHTML='<textarea name="" id="" cols="30" rows="3">'+contents.innerHTML+'</textarea>';
        contents.firstChild.removeAttribute("readonly");
        let btn = document.createElement("button");
        let attr = document.createAttribute("class");
        attr.value="btn btn-primary";
        btn.setAttributeNode(attr);
        contents.appendChild(btn);
        attr = document.createTextNode("확인");
        btn.appendChild(attr);

        btn.addEventListener("click", function(){
            console.log(contents.firstChild.value);
            console.log(num);

            let xhttp = new XMLHttpRequest();
            xhttp.open("POST", "../bankBookComment/update");
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("num="+num+"&contents="+contents.firstChild.value);
            xhttp.addEventListener('readystatechange', function() {
                if(this.readyState==4 && this.status==200) {            
                    let result = this.responseText.trim();
                    if(result>0){
                        alert("수정 성공");
                        getList(1);
                    } else {
                        alert("수정 실패");
                    }
                }
            })
        })

    }
    e.preventDefault();
});
