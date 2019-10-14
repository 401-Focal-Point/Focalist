'use strict'
//gets the local
window.onLoad function() {
    var offset = new Date().getTimezoneOffset()/60;
    $('#offset').val(offset);
}