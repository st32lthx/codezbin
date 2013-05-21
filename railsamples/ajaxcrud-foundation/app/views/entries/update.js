$("#<%= dom_id(@entry) %>").replaceWith("<%= escape_javascript(render(:partial => @entry)) %>");
<% @entry = Entry.new # reset for new form %>
$(".edit_entry").replaceWith("<%= escape_javascript(render(:partial => "form"))%>")
$(".new_entry")[0].reset();