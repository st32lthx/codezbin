 // require('angular')
 // $(function() {
 //     console.log("but when you turn off it is all goodslow");
 //     console.log("theer is also other tings that can ne done");
 //        $("<h1>test passes</h1>").appendTo("body");
 //     console.log($("body").html());
 // })
 // console.log("e")

 var jsdom = require("jsdom");

 jsdom.env(

     '<html ng-app>' +
     '<body>' +
     '</body>' +
     '</html>',
     // ["http://code.jquery.com/jquery.js"], /* scripts could also be added to the page*/
     function() { /* callback required by jsdom */
         var $ = require('jQuery');

         $(function() {
             $('body').append("<div class='testing'>Hello World</div>");
             console.log($(".testing").text()); // outputs Hello World
         })
     }
 );