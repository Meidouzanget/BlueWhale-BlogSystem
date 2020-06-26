function updatePersonage() {
    var phone=$("#phone").val();
    var nickName=$("#nickName").val();
    var sex=$("#sex").val();
    var birth=$("#birth").val();
    var signature=$("#signature").val();
    var email=$("#email").val();

    $.ajax({
        url:"",
        type:"post",
        data:{
            phone:phone,
            nickName:nickName,
            sex:sex,
            birth:birth,
            signature:signature,
            email:email,
        }
    })
}