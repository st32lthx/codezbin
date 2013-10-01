/*
 * grunt-link-html
 * https://github.com/pythonandchips/grunt-link-html
 *
 * Copyright (c) 2013 Colin Gemmell
 * Licensed under the MIT license.
 */

'use strict';

module.exports = function(grunt) {

  grunt.registerMultiTask('link_html', 'link css and javascipt in html file', function() {

    var options = this.options({
      expand: true,
      cwd: '.'
    });

    //TODO: test this method away from the rest of the code. not sure how to do that yet.
    var includes = function(template, path, options){
      var cssFiles = grunt.file.expand(options, path);
      var cssIncludes = cssFiles.map( function(file) {
        return grunt.template.process(template, {data: {file: file}});
      });
      cssIncludes.unshift('');
      cssIncludes = cssIncludes.join('\n') + '\n';
      return cssIncludes;
    };

    //TODO: test this method away from the rest of the code. not sure how to do that yet.
    var processIncludes = function(filepath, content, fileType, files) {
      var begin = content.html.match(new RegExp('<!--\\s*begin:' + fileType + '\\s*-->'));
      var skip = false;
      if(begin){
      var end = content.html.match(new RegExp('<!--\\s*end:' + fileType + '\\s*-->')).index;
      var startReplace = begin.index + begin[0].length;
      content.html = content.html.substring(0, startReplace) + files + content.html.substring(end, content.html.length);
      } else {
        skip = true;
        grunt.log.ok('Skipping ' + fileType  + ' for '+filepath);
      }
      return skip;
    };

    var cssIncludes = includes('<link rel="stylesheet" type="text/css" href="<%= file %>">', this.data.cssFiles, options);
    var jsIncludes = includes('<script src="<%= file %>"></script>', this.data.jsFiles, options);
    var targetFiles = grunt.file.expand(options, this.data.targetHtml);

    targetFiles.forEach( function(filepath) {
      var content = {html: grunt.file.read(options.cwd + '/' + filepath)};
      var skipCss = processIncludes(filepath, content, 'css', cssIncludes);
      var skipJs = processIncludes(filepath, content, 'js', jsIncludes);
      if(!skipJs && !skipCss){
        grunt.log.ok('Writing file '+ filepath);
        grunt.file.write(options.cwd + '/' + filepath, content.html);
      }
    });

  });

};
