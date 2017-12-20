module.exports = function(grunt) { // 設定記述開始  ...（1）
    grunt.initConfig({  // Gruntの初期設定          ...（2）
        uglify: {       // contrib-uglifyのタスク   ...（3）
            target1: {
                files: [
                        // timer.js -> timer.min.js ...（4）
                    {'js/timer.min.js':
                        ['js_src/timer.js']},
                        // color.js -> color.min.js ...（5）
                    {'js/color.min.js': 
                        ['js_src/color.js']},
                ]
            },
            options: {   // オプション指定          ...（6）
//              sourceMap: true,
//              maxLineLen: 1000
            }
        }
    });
    
    // contrib-uglifyプラグインをロード             ...（7）
    grunt.loadNpmTasks('grunt-contrib-uglify');
    
    // uglifyタスクをdefaultに設定                  ...（8）
    grunt.registerTask("default", ["uglify"]);
};