'use strict';
//gets the local
(function() {
    var offset = new Date().getTimezoneOffset()/60;
    $('#offset').val(offset);
//    set form to disabled?
})();

//https://stackoverflow.com/questions/12742595/show-how-many-characters-remaining-in-a-html-text-box-using-javascript
function textCounter(field,field2,maxlimit)
{
 var countfield = document.getElementById(field2);
 if ( field.value.length > maxlimit ) {
  field.value = field.value.substring( 0, maxlimit );
  return false;
 } else {
  countfield.value = maxlimit - field.value.length;
 }
}

