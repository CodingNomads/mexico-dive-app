// $( '.navbar' ).find( 'li.active' ).removeClass( 'active' );
// $( this ).parent( 'li' ).addClass( 'active' );

//     document.getElementById("myBtn").addEventListener("click", function(){
//         document.getElementById("demo").innerHTML = "Hello World";
//     });
// $( '.nav-item a' ).onclick = function() {
//     alert('blah');
// };

$(document).ready(function () {
    $('.nav-item a').click(function () {
        $('.navbar').find('li.active').removeClass('active');
        $(this).parent('li').addClass('active');
    });
});

