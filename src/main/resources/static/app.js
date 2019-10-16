'use strict';
//gets the local
console.log("working");
(function() {
    var offset = new Date().getTimezoneOffset()/60;
    $('#offset').val(offset);
})();

