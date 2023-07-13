$(document).ready(function () {
    $('#regBtn').click(function () {
        const id     = $('#id').val();
        const pw     = $('#pw').val();
        const name   = $('#name').val();
        const age    = $('#age').val();
        const gender = $('input[name=gender]:checked').val();
        const email  = $('#email').val();

        if (id === undefined || id === '') {
            swal("필수입력", "아이디는 필수입력입니다.", "warning");
            return;
        }

        if (pw === undefined || pw === '') {
            swal("필수입력", "비밀번호는 필수입력입니다.", "warning");
            return;
        }

        if (name === undefined || name === '') {
            swal("필수입력", "이름은 필수입력입니다.", "warning");
            return;
        }

        if (age === undefined || age === '') {
            swal("필수입력", "나이는 필수입력입니다.", "warning");
            return;
        }

        if (email === undefined || email === '') {
            swal("필수입력", "이메일은 필수입력입니다.", "warning");
            return;
        }
        
        const regObj = {
            id: id,
            pw: pw,
            name: name,
            age: age,
            gender: gender,
            email: email
        };
        $.ajax({
            type: "POST",
            url: "/user/registUser",
            data: regObj,
            dataType: "json",
            success: function (data, textStatus, xhr) {
                if (data.result === false) {
                    swal("저장 실패", "저장이 실패하였습니다.", "warning");
                } else {
                    swal("저장 성공", "로그인 페이지로 이동합니다.", "success");
                    window.location.href = '/'; // 로그인 페이지 이동
                }
            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "error:" + error);
            }
        })
    });
})