'use strict';

var path = require('path');
var gulp = require('gulp');
var conf = require('./conf');
var gutil = require('gulp-util');
var ngConstant = require('gulp-ng-constant');

gulp.task('config', function () {
  var configPath = 'config/config-dev.json';
  if (process.env.NODE_ENV === 'integ') {
    configPath = 'config/config-integ.json';
  }
  return gulp.src(configPath)
    .pipe(ngConstant({templatePath:'config/custom.constant.tpl.ejs'}))
    .pipe(gulp.dest('src/app/'));
});