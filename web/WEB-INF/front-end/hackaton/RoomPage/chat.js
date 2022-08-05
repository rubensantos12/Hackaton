$("#exit-button").click(function(){
  
    document.location.href = "http://localhost:5501/rooms.html";

});

  var input = document.getElementById("#message");

  input.addEventListener("keypress", function(event){
      if(event.key === "Enter"){
          event.preventDefault();

          document.getElementById("#send").click();
      }
  })