
function openPopUp()
{
	$( "#dialog1" ).dialog({
	    autoOpen: false
	  });
	  
	  $("#opener").click(function() {
	    $("#dialog1").dialog('open');
	  });
}