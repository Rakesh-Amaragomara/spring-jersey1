module.exports = function(grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        ngAnnotate: {
            options: {
                singleQuotes: true
            },
            app: { //"app" target
                files: {
                    './src/main/webapp/js/apiService.js': ['.src/main/webapp/js/contoller/apiService.js'],
                    './src/main/webapp/js/profile.js': ['./src/main/webapp/js/controller/profile.js'],
                    './src/main/webapp/js/app.js': ['./src/main/webapp/js/controller/app.js']
                }
            }
        },
        concat: {
            js: { //target
                src: ['./src/main/webapp/js/contoller/app.js','./src/main/webapp/js/contoller/*.js'],
                dest: './profile-min.js'
            }
        },
        uglify: {
            js: { //target
                src: ['./profile-min.js'],
                dest: './profile-min.js'
            }
        }



        //grunt task configuration will go here     
    });
    //load grunt task
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-ng-annotate');
    //register grunt default task
    grunt.registerTask('default', ['ngAnnotate', 'concat', 'uglify']);
}