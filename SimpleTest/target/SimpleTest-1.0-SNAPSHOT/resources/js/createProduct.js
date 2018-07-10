$(document).ready(function () {
    $("#btn-create").click(function () {
        var code = $("input[name = 'code']").val();
        var productName = $("input[name = 'name']").val();
        var price = $("input[name = 'price']").val();
        if(code.length > 0 ){
            if(productName.length >0){
                if(!isNaN(price)){
                    $.ajax({url: "http://localhost:8080/apicreateProduct",
                        type: "post",
                        data : {
                            code:code,
                            name :productName,
                            price:price
                        },
                        success: function(result){
                            $("#txt1").text(result);
                        }});
                } else {
                    $("#errPrice").html("<b>Price Error</b>");
                }
            } else {
                $("#errName").html("<b>Name Error</b>");
            }

        } else {
            $("#errCode").html("<b>Code error</b>");
        }
    });
});