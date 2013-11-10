
$(":button").click(function() {
       var isbn = this.id;
       
       $.ajax({
               url: '/library/v1/books/' + isbn + '/?status=lost',
               dataType: "json",
               contentType: "application/json",
               type: 'PUT',
               success: function(data) {
                               alert('Reported lost on ISBN ' + isbn);
                               
                               window.location.reload();

                               
                       },
               error: function(xhr, status) {
                               alert("Sorry, there was a problem!");
                       }
               });
        
});

$( function(){

  $('button').each(function(i){
  console.log(i);
  console.log($( this ).text());
  var sibling = $(this).parent().siblings('td[name=status]').get(0);
  console.log(sibling.id);
  if(sibling.id===$(this).get(0).id && sibling.innerHTML==='lost')
  {
    console.log("ready to be disabled");
    $(this).prop("disabled", true);
  }
 
 
 });   

});

