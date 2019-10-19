'use strict';
// gets the offset in hours from local time and UTC time
// pass the offset to a hidden input that will get passed along with the form for adding tasks.
// Michelle dont hack the hidden input for offset. Just pretend it is actually hidden.
(function() {
    var offset = new Date().getTimezoneOffset()/60;
    $('#offset').val(offset);
})();

// Resource:
// https://stackoverflow.com/questions/12742595/show-how-many-characters-remaining-in-a-html-text-box-using-javascript
// textCounter keeps track of how many characters are typed into the message box by the user
{
 var countfield = document.getElementById(field2);
 if ( field.value.length > maxlimit ) {
  field.value = field.value.substring( 0, maxlimit );
  return false;
 } else {
  countfield.value = maxlimit - field.value.length;
 }
}

