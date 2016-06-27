/**
 * Created by pagulane on 26.06.2016.
 */



$(document).ready(function(){
    $diagnoseForm = $(".diagnose-form select");
    $diagnoseForm.select2();
    $diagnoseForm.on("change", function () {
        $.ajax({
            type: "POST",
            data: $(".diagnose-form").serialize(),
            success: function(data) {
                $(".diagnose-result").html(data);
            }
        });
    });
});

$(document).ready(function(){
    $diagnoseForm = $(".diagnose-interactive-form select");
    $diagnoseForm.select2();
    $diagnoseForm.on("change", function () {
        $.ajax({
            type: "POST",
            data: $(".diagnose-interactive-form").serialize(),
            success: function(data) {
                $(".diagnose-result").html(data);
            }
        });
    });
});

function addFilterYes(obj){
    $(".input-fields").append("<input type='hidden' name='test' value=" + $(obj).attr('value') + ">");
    $.ajax({
        type: "POST",
        data: $(".diagnose-interactive-form").serialize(),
        success: function (data) {
            alert(data);
            $(".panel.panel-default").html(data);
        }
    })
}

function addFilterNo(){
    $(".input-fields").append("<input type='hidden' name='test' value='-1'>")
}



