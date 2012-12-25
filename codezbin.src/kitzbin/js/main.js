/*
Amin Meyghani
Nov.17.2012
*/
var active_toggler_boolean = "active";
var active_bg_class = "snippet_trigger_bg_active";
var active_trigger_class = "snippet_trigger_active";
var collapse_time;
var slide_toggle_time;
var auto_expand_boolean = 1;


$(function(){

fade_in_page_content();home_welcome();hide_snippets(); add_arrow_to_snippet_titles(" ▸"); add_event_handlers();collapse_all_change_page();enable_expand_all_on_page_load();




var model = $.makeclass(DataModel);
collapse_time = model.getCollapseTime();
slide_toggle_time = model.getSlideToggleTime();


});




function enable_expand_all_on_page_load() {
if(can_expand()){
setTimeout(function(){
toggle_expand_switch();
set_trig_collapse_text("Collapse all (-)");
change_arrow_for_all_snippets(" ▾");
add_active_trigger_class();
slide_down_snippets(slide_toggle_time);
make_snippets_bgs_active();
$(".snippet-trigger").addClass(active_toggler_boolean);

  }, 700);
};
}
function can_expand(){
return (auto_expand_boolean==1);

}
function add_event_handlers() {
$(".snippet-trigger").click(run_trigger);
$("#expand_collapse").click(run_trig_collapse);


}
function run_trigger(){
	$(this).toggleClass(active_toggler_boolean); 
	$(this).siblings().slideToggle(slide_toggle_time);

	
	$(this).contents().last().remove();
	$(this).append(($(this).hasClass(active_toggler_boolean) ? ' ▾' : ' ▸'));
	
	$(this).parent().toggleClass(active_bg_class);
	$(this).toggleClass(active_trigger_class);	
	
	return false;
}
function run_trig_collapse(){
	toggle_expand_switch();
	
	if($("#expand_collapse").hasClass(active_toggler_boolean)){


		
				set_trig_collapse_text("Collapse all (-)");
				change_arrow_for_all_snippets(" ▾");
				add_active_trigger_class();
				slide_down_snippets(slide_toggle_time);
				make_snippets_bgs_active();
				$(".snippet-trigger").addClass(active_toggler_boolean);

			
		}else{



				make_snippet_bgs_inactive();
				set_trig_collapse_text("Expand all (+)");
				change_arrow_for_all_snippets(" ▸");
				make_trigger_color_inactive();
				slide_up_snippets(collapse_time);
				$(".snippet-trigger").removeClass(active_toggler_boolean);

				
		
	}
		return false;
}
function add_arrow_to_snippet_titles(symbol){
$(".snippet-trigger").append(' ▸');
}
function hide_snippets(){
$(".snippet").hide();
}
function slide_up_snippets(time){
	$(".snippet-trigger").siblings().slideUp(time);
}
function make_trigger_color_inactive(){
	$(".snippet-trigger").removeClass(active_trigger_class);
}
function make_snippet_bgs_inactive(){
	$(".snippet-trigger").parent().removeClass(active_bg_class);
}
function toggle_expand_switch(){
	$("#expand_collapse").toggleClass(active_toggler_boolean); 

 
}
function set_trig_collapse_text(text){
	$("#expand_collapse").text(text);
}
function add_active_trigger_class(){
	$(".snippet-trigger").addClass(active_trigger_class);
}
function change_arrow_for_all_snippets(arrow){
$(".snippet-trigger").each(function(index) {
	    $(this).contents().last().remove();
	    $(this).append(arrow);
	});
	
}
function slide_down_snippets(time){
	$(".snippet-trigger").siblings().slideDown(time);
}
function make_snippets_bgs_active(){
	$(".snippet-trigger").parent().addClass(active_bg_class);
}
function home_welcome(){

	animate_in_content_with_delay("welcome",1200,650);
	animate_in_content_with_delay("overall_bar",500,650);
	progress_meter("design_progress",70,1500);
	progress_meter("snippet_material_progress",10,1500);
	progress_meter("snippet_material_progress",10,1500);
	progress_meter("writing_dbs",30,1500);
	progress_meter("overall_progress",20,800);
	
	animate_dots("progress",5,500,50);
	animate_dots("progressoff",10,500,50);
	
}
function animate_in_content_with_delay(class_name,to_wait,fadeIn_time){
$("."+class_name).hide();
setTimeout(function(){
      $("."+class_name).fadeIn(fadeIn_time);
  }, to_wait);

}
function animate_dots(class_name,animation_interval,to_wait_time,dot_length){
var i = 0;
var t = to_wait_time;
while(i<dot_length){
setTimeout(function(){
      $("."+class_name).append(".");
  }, t);
  i++;
  t+=animation_interval;
}
}
function progress_meter(id,progress, to_wait){

var i = 0;
var t = to_wait;
var val=0;
while(i<progress){
setTimeout(function(){
      $("#"+id).contents().last().remove();
      $("#"+id).append(val+=1);
  }, t);
  i++;
  t+=20;
}

}

function is_home(){
return ($("#homepage-flag").length > 0);
}
function fade_in_page_content(){
$("#content").hide();
setTimeout( "jQuery('#content').fadeIn(250);",250 );
}
function collapse_all_change_page() {if(!(is_home())) {
    $("a.topnav").click(function(event){
         event.preventDefault();
         linkLocation = this.href;
         make_snippet_bgs_inactive();
         set_trig_collapse_text("Expand all (+)");
         change_arrow_for_all_snippets(" ▸");
         make_trigger_color_inactive();
         	$(".snippet-trigger").siblings().slideUp(collapse_time,redirectPage);
         $(".snippet-trigger").removeClass(active_toggler_boolean);
         
     });
          
    
}}
function redirectPage() {
     window.location = linkLocation;
 }
function reserved_methods(){

/*
function fadeoutpagecontentonclikc(){

$("a.topnav").click(function(event){
     event.preventDefault();
     linkLocation = this.href;
     $(".maincontent").fadeOut(300, redirectPage);      
 });
      
 function redirectPage() {
     window.location = linkLocation;
 }

}


function add_three_dots(){
var i3 = 0;
var t3 = 1000;
while(i3<3){
setTimeout(function(){
      $(".welcome").append(".");
  }, t3);
  i3++;
  t3+=700;
}

}



function run_only_once(){

/*
only once example
$("p").one("click", function(){
alert( $(this).text() );
});


}
*/ 



 }


/*
add_three_dots();
*/

/*
fadout_page_content_onclik();
*/






