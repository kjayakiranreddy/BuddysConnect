
$(document).ready(function(){
	document.getElementById("main").style.display = "none";
	
	$("#dialog").dialog({
	     autoOpen: false,
	     modal: true
	   });

	  $("#myButton").on("click", function(e) {
	      e.preventDefault();
	      $("#dialog").dialog("open");
	  });
});
let main = document.querySelector('main');

function searchUser(input){
    
    let userInput = input.value;
    	   
    let friends = document.querySelectorAll('.friend');

    friends.forEach(friend => {
    	document.getElementById("main").style.display = "block";
        let email = friend.querySelector('span').innerText;

        if((email).includes(userInput)){
            friend.style.display = 'block';
        }else{
            friend.style.display = 'none';
        }
    }) 
}
function openPopUp()
{
	$( "#dialog1" ).dialog({
	    autoOpen: false
	  });
	  
	  $("#opener").click(function() {
	    $("#dialog1").dialog('open');
	  });
}

