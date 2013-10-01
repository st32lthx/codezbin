'use strict';
//TODO: use variables for paths

module.exports = function (grunt) {

    // Project configuration
    grunt.initConfig({

        pkg: grunt.file.readJSON('package.json'),

        // Clean files and folders
        clean: {
            all: {
                src: ["dist/css/app.min.css","dist/js/app.min.js","dist/**/*.css","dist/**/*.js"]
            }
        },

        // Compile LESS (Bootstrap v3.0.0 & Font Awesome v3)
        less: {
            all: {
                /*
                options: {
                    yuicompress: true,
                    //TODO: need to add the fonts.
                    paths: ["less", "less/font-awesome"]
                },*/
                files: {
                    "dev/css-less/app/app.css": "dev/css-less/app/app.less"
                }
            }
        },

        // Minify CSS
        cssmin: {
            compress: {
                files: {
                    "dist/css/app.min.css": ["dev/css-less/app/app.css"]
                }
            }
        },

        // Concatenate JavaScript files
        // TODO: how to a better concat? for example:
        // concat bootstrap files -> bootstrap.js
        // concat angular files -> angular.js
        // concat app files -> app.js 
        concat: {
          basic: {
            src: ['dev/js/app/src/*.js'],
            dest: 'dev/js/app/app.js',
          },
          extras: {
            //TODO: fix the issue of ordering bootstrap files to compile or concat them in order
            src: ['dev/js/vendor/bootstrap/src/modal.js','dev/js/vendor/bootstrap/src/tooltip.js'],
            dest: 'dev/js/vendor/bootstrap/bootstrap.js',
          },
        },

        // Minify JavaScript
        uglify: {
            all: {
                files: {
                    "dist/js/bootstrap.min.js": ["dev/js/vendor/bootstrap/bootstrap.js"],
                    "dist/js/app.min.js":["dev/js/app/app.js"]/*,*/
                    /* production libs */
                    /*
                    "dist/js/jquery-1.10.2.min.js":["dev/js/vendor/jquery/jquery-1.10.2.js"],
                    "dist/js/jquery-2.0.3.min.js":["dev/js/vendor/jquery/jquery-2.0.3.js"],
                    "dist/js/jquery-migrate-1.2.1.min.js":["dev/js/vendor/jquery/jquery-migrate-1.2.1.js"]
                    */
                }
            }
        },
        connect: {
            server: {
              options: {
                port: 9001,
                base: '.',
                keepalive: true
              }
            }
          },
          link_html: {
            html: {
              /*TODO: Add another configuration for produciton */
              jsFiles: ['dev/js/vendor/jquery/jquery-2.0.3.js','dev/js/vendor/bootstrap/bootstrap.js','dev/js/app/app.js'],
              /*TODO: Add another configuration for produciton */
              cssFiles: ['dev/css-less/app/app.css'],
              targetHtml: ['index.html'],
              
            }
          },

        // Watch for file changes
        watch: {
            files: [
                "dev/css-less/**/*.less",
                "dev/js/**/*.js",
                "**/*.html"
            ],
            tasks: ["default"],
            options: {
                nospawn: true,
                livereload: true
            }
        }

    });

    // Load the pluigns the provide the tasks.
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks('grunt-link-html');

    // Default task(s)
    // TODO:
    // the clean all module removes files and folders, will add later
    // not sure how i can use it yet, do u know ?
    // for more info: https://github.com/gruntjs/grunt-contrib-clean
    grunt.registerTask('default', [/*"clean:all", */"less", "cssmin", "concat", "uglify","link_html"]);

};