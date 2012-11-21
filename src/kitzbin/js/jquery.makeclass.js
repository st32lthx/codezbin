/*!
    :: http://mahdipedram.com 
    :: jquery.makeclass.js - javascript makeclass plugin
    :: All Code and design by Seyed-Mahdi PedramRazi
    :: Version 1.0 - Jan 2011
    :: Email : pedramphp@gmail.com

 */  


$.makeclass = function( orgObj ){
        if( !$.isEmptyObject(orgObj.Static) ){ 
            $.extend(orgObj,orgObj.Static);
        }
        var obj = $.extend({},{},orgObj);

        var arguments = Array.prototype.slice.call( arguments );
        arguments.shift();
    
        if( !obj.Public ){ obj.Public ={}; } 
        
        var privateObj = ($.isEmptyObject( obj.Private ))?{}:$.extend({},{},obj.Private);
    
        if ( obj.Extends ) {
             var extend = $.extend({},{}, obj.Extends);
             if( !$.isEmptyObject(extend.Static) ){ 
                $.extend(orgObj,extend.Static);
             }
             var parentInitialize = extend.Initialize;
             
             privateObj =$.extend({},extend.Private,privateObj);
             obj.Public.parent ={
               Initialize: function(){ 
                var args = Array.prototype.slice.call( arguments );
                args.unshift( privateObj );
                parentInitialize.apply( this , args); 
               }
             };
             for(var field in extend.Public ){
                if($.isFunction(extend.Public[field])){
                     eval("obj.Public.parent['"+field+"']"+"= function "+field+"(){"+
                        "var args = Array.prototype.slice.call( arguments );"+
                        "args.unshift( privateObj );"+  
                        "return extend.Public[arguments.callee.name].apply(this,args);"+
                    "}");   
                }else{
                  obj.Public.parent[field ] = extend.Public[field];
                }
             }
    
    
             var parentProto = $.extend({}, extend.Public); // copying
             obj.Public  = $.extend({}, parentProto, obj.Public );
             delete extend;
        }
            
    
        var o = function(){          
            if( $.isFunction(obj.Initialize) ){
                  var args = Array.prototype.slice.call( arguments );
                  args.unshift( privateObj );
            
                  obj.Initialize.apply( obj.Public, args );
             }           
        };
         

        var clonePublic = $.extend({},{},obj.Public);
         for( var field in clonePublic){
             if($.isFunction(clonePublic [field])){ 
                eval("clonePublic['"+field+"']"+"= function "+field+"(){"+
                    "var args = Array.prototype.slice.call( arguments );"+
                    "args.unshift( privateObj );"+  
                    "return obj.Public[arguments.callee.name].apply(this,args);"+
                "}");
            }
         }       
     
         o.prototype = clonePublic;
         for( var i =0; i<arguments.length; i++){
            if(typeof arguments[i] === "string"){
                arguments[i] = "'"+arguments[i]+"'";
            }
         }
         return eval("new o("+arguments.toString()+");");
         
     };