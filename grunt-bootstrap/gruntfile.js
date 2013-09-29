'use strict';

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
                    paths: ["less", "less/font-awesome"]
                },*/
                files: {
                    "dist/css/app.css": "dev/css-less/app/app.less"
                }
            }
        },

        // Minify CSS
        cssmin: {
            compress: {
                files: {
                    "dist/css/app.min.css": ["dist/css/app.css"]
                }
            }
        },

        // Concatenate JavaScript files
        concat: {
          basic: {
            src: ['dev/js/app/*.js'],
            dest: 'dist/js/app.js',
          },
          extras: {
            src: ['dev/js/vendor/bootstrap/*.js'],
            dest: 'dist/js/bootstrap.js',
          },
        },

        // Minify JavaScript
        uglify: {
            all: {
                files: {
                    // "dist/js/bootstrap.min.js": ["dist/js/bootstrap.js"],
                    "dist/js/app.min.js":["dist/js/app.js"]/*,*/
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
              jsFiles: ['dist/js/app.js'],
              cssFiles: ['dist/css/app.css'],
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
    grunt.registerTask('default', ["clean:all", "less", "cssmin", "concat", "uglify","link_html"]);

};