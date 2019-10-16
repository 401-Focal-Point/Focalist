'use strict';

//gets the local time offset from UTC 
(function () {
    var offset = new Date().getTimezoneOffset() / 60;
    $('#offset').val(offset);
})();