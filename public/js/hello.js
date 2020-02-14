console.log("hello");
$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8081/api/get?bookId=1"
    }).then(function(data) {
        console.log(data);
        $('.buddy-id').append("1");
    });
});