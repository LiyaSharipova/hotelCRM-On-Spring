// f = function (){
//     jQuery.ajax({
//         type: 'GET',
//         url: "/ajax/getBookings",
//         dataType: "json",
//         data: {"login": $("#login").val()},
//         success: function (response_data) {
//             if (response_data.length != 0) {
//                 // jQuery("#res").html("Sort results: ");
//                 console.log('Some text');
//                 for (var i = 0; i < response_data.length; i++) {
//                     jQuery("#res").append("<p>"+response_data[i].id+"</p> ")
//                     jQuery("#res").append("<hr size=1px color=\"#ccc\">");
//                 }
//
//             } else {
//                 jQuery("#res").html("No results");
//             }
//         }
//     })
// };

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
// $(function () {
//     var button = $("#bookBtn");
//     button.onclick(function () {
//         getBookings();
//     });
// });
