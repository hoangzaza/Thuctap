$(document).ready(function(){


    $("#btn-register").click(function () {
        var name = $("input[name = 'userName']").val();
        if(name.length < 6){
            $("#result").css("display","block");
            return false;
        }
    });


})