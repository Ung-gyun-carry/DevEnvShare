$(document).ready(function () {
    $('#loginBtn').click(function () {
        const id = $('#uid').val();
        const pw = $('#upw').val();
        
        if (id === undefined || id === '') {
            swal("필수입력", "아이디는 필수입력입니다.", "warning");
            return;
        }

        if (pw === undefined || pw === '') {
            swal("필수입력", "비밀번호는 필수입력입니다.", "warning");
            return;
        }
        const loginObj = {
            id: id,
            pw: pw
        };
        $.ajax({
            type: "POST",
            url: "/user/loginUser",
            data: loginObj,
            dataType: "json",
            success: function (data, textStatus, xhr) {
                if (data.result === false) {
                    swal("로그인 실패", "아이디 혹은 패스워드가 일치하지않습니다.", "warning");
                } else {
                    swal("로그인 성공", "메인페이지로 이동합니다.", "success");
                    // window.location.href = 'main.jsp';
                }
            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "error:" + error);
            }
        })
    });

    $('#regBtn').click(function () {
        location.href = '/user/registerForm';
    });

    $('#regDevEnvBtn').click(function () {
        location.href = '/user/registerDevEnvForm';
    });
})