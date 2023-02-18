$(document).ready(function() {
    $("#submitRegister").click(function() {
        register();
    });
    roleList();
})

function roleList() {
        $.get("http://localhost:8080/api/role", function(data) {
            data.forEach(eachRole)
            function eachRole(role) {
                $("#selectRole").append(new Option(role.name.substr(5), role.id));
            }
        })
    }

function register() {
    var user = {username : $("#inputUsername").val(), password: $("#inputPassword").val(),
    role_id : parseInt($("#selectRole").val())};
//    alert(JSON.stringify(user));

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/register",
        contentType: "application/json",
        data: JSON.stringify(user),
        success: function(data) {

        }
    })
}