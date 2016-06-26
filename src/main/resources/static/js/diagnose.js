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

