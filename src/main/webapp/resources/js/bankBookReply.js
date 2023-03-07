// 댓글 등록
$("#replyAdd").click(function(){
    // JS에서 사용 할 가상의 Form 태그 생성
    const form = new FormData(); // <form></form>
    form.append("contents", $("#replyContents").val()); //<form><input type="text" name="contents" value="asdf"></form> 
    form.append("bookNumber", $("#replyAdd").attr('data-book-bookNumber')) // <form><input type="text" name="contents" value="asdf"><input type="text" name="bookNumber" value="asdf"></form> 

    fetch('../bankBookComment/add', {
        method:'POST',
        //headers:{"Content-type": "application/x-www-form-urlencoded"},
        body:form,
    }).then((response)=> response.text())
    .then((res)=>{
        if(res.trim()==1){
            alert('댓글이 등록 되었습니다.')
            $("#replyContents").val("");
            getList(1);
        } else {
            alert('댓글 등록에 실패 했습니다.')
        }
    })
})

// List
getList(1);

function getList(page) {

    fetch("/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-bookNumber')+"&page="+page, {
        method:'GET'
        // GET과 HEAD 메서드는 body 속성을 가질 수 없음
    })
    .then((response)=>response.text())
    .then((res)=>{

        $("#commentListResult").html(res.trim());
    })

}

// page
$("#commentListResult").on("click",".page-link", function(e){        
    
    let page = $(this).attr("data-board-page");
    getList(page);
    
    e.preventDefault();

});

// delete
$("#commentListResult").on("click",".del",function(e){
    fetch("../bankBookComment/delete", {
        method:'POST',
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:"num="+$(this).attr("data-comment-num")
        // 응답객체에서 Data 추출
    }).then((response)=> {return response.text()})//then(function(response){return response.text()})
        // 추출한 Data 사용
        .then((res)=>{
        if(res.trim()>0){
            alert("댓글이 삭제되었습니다.");
            getList(1);
        } else {
            alert("삭제를 실패했습니다.");
        }
    })

    e.preventDefault();
});

// Update
$("#commentListResult").on("click", ".update", function(e){
    let num = $(this).attr("data-comment-num");
    $("#contents").val($("#contents"+num).text());
    $("#contentsConfirm").attr("data-comment-num", num);
    e.preventDefault();
})

//
$("#contentsConfirm").click(function(){
    
    fetch('../bankBookComment/update',{
        method:'POST',
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body: "num="+$(this).attr("data-comment-num")+"&contents="+$("#contents").val()
    }).then((response)=>response.text())
      .then((res)=>{
        if(res.trim()>0){
            alert('수정 성공');
            $("#closeModal").click();
            getList(1);
        } else {
            alert('수정 실패');
        }
      })
      .catch(()=>{
        alert('관리자에게 문의바랍니다.');
      })
})