// jQuery(function($){
$("#phoneNumber").mask("+7 (999) 999-9999");

$(function () {

    $('#check_in').datetimepicker({
        format: 'YYYY-MM-DD',
        minDate: moment()
    });
    $('#check_out').datetimepicker({
        format: 'YYYY-MM-DD',
        minDate: moment(),
        useCurrent: false //Important! See issue #1075
    });
    $("#check_in").on("dp.change", function (e) {
        $('#check_out').data("DateTimePicker").minDate(e.date);

    });
    $("#check_out").on("dp.change", function (e) {
        $('#check_in').data("DateTimePiccker").maxDate(e.date);

    });
});

$(function () {
    if (typeof disabledays !== 'undefined') {
        $('#check_out').data("DateTimePicker").disabledDates(disabledays);
        $('#check_in').data("DateTimePicker").disabledDates(disabledays);

    }

});

function getBookings() {
    var login = $("#login").val();
    $.ajax({
        url: "/ajax/getBookings",
        type: "GET",
        data: {
            login: login
        },
        dataType: "html",
        success: function (data) {
            $("#bookings").html(data);

        }
    })
}

