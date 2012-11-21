

// F. Permadi 2005.
// (C) F. Permadi
// Print DOM tree
////////////////////////////////////////////
// This function traverses the DOM tree of an element and prints the tree.  
// This function called recursively until the DOM tree is fully traversed.
// 
// Parameters:
// - targetDocument is where the tree will be printed into
// - currentElement is the element that we want to print
// - depth is the depth of the current element 
//   (it should be 1 for the initial element)
////////////////////////////////////////////
function traverseDOMTree(targetDocument, currentElement, depth)
{
  if (currentElement)
  {
    var j;
    var tagName=currentElement.tagName;
    // Prints the node tagName, such as <A>, <IMG>, etc
    if (tagName)
      targetDocument.writeln("&lt;"+currentElement.tagName+"&gt;");
    else
      targetDocument.writeln("[unknown tag]");

    // Traverse the tree
    var i=0;
    var currentElementChild=currentElement.childNodes[i];
    while (currentElementChild)
    {
      // Formatting code (indent the tree so it looks nice on the screen)
      targetDocument.write("<BR>\n");
      for (j=0; j<depth; j++)
      {
        // &#166 is just a vertical line
        targetDocument.write("&nbsp;&nbsp;&#166");
      }								
      targetDocument.writeln("<BR>");
      for (j=0; j<depth; j++)
      {
        targetDocument.write("&nbsp;&nbsp;&#166");
      }					
      if (tagName)
        targetDocument.write("--");

      // Recursively traverse the tree structure of the child node
      traverseDOMTree(targetDocument, currentElementChild, depth+1);
      i++;
      currentElementChild=currentElement.childNodes[i];
    }
    // The remaining code is mostly for formatting the tree
    targetDocument.writeln("<BR>");
    for (j=0; j<depth-1; j++)
    {
      targetDocument.write("&nbsp;&nbsp;&#166");
    }			
    targetDocument.writeln("&nbsp;&nbsp;");
    if (tagName)
      targetDocument.writeln("&lt;/"+tagName+"&gt;");
  }
}
////////////////////////////////////////////
// This function accepts a DOM element as parameter and prints
// out the DOM tree structure of the element.
////////////////////////////////////////////
function printDOMTree(domElement, destinationWindow)
{
  // Use destination window to print the tree.  If destinationWIndow is
  //   not specified, create a new window and print the tree into that window
  var outputWindow=destinationWindow;
  if (!outputWindow)
    outputWindow=window.open();

  // make a valid html page
  outputWindow.document.open("text/html", "replace");
  outputWindow.document.write("<HTML><HEAD><TITLE>DOM</TITLE></HEAD><BODY>\n");
  outputWindow.document.write("<CODE>\n");
  traverseDOMTree(outputWindow.document, domElement, 1);
  outputWindow.document.write("</CODE>\n");
  outputWindow.document.write("</BODY></HTML>\n");
  
  // Here we must close the document object, otherwise Mozilla browsers 
  //   might keep showing "loading in progress" state.
  outputWindow.document.close();
}
