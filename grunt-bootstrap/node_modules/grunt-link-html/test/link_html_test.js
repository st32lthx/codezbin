'use strict';

var grunt = require('grunt');

/*
  ======== A Handy Little Nodeunit Reference ========
  https://github.com/caolan/nodeunit

  Test methods:
    test.expect(numAssertions)
    test.done()
  Test assertions:
    test.ok(value, [message])
    test.equal(actual, expected, [message])
    test.notEqual(actual, expected, [message])
    test.deepEqual(actual, expected, [message])
    test.notDeepEqual(actual, expected, [message])
    test.strictEqual(actual, expected, [message])
    test.notStrictEqual(actual, expected, [message])
    test.throws(block, [error], [message])
    test.doesNotThrow(block, [error], [message])
    test.ifError(value)
*/

exports.link_html = {
  setUp: function(done) {
    done();
  },
  link_html: function(test) {
    test.expect(2);
    var content = grunt.file.read('test/fixtures/index.html');
    console.log(content);
    var cssIndex = content.indexOf('<link rel="stylesheet" type="text/css" href="test.css">');
    var jsIndex = content.indexOf('<script src="test.js"></script>');

    test.notEqual(-1, cssIndex, 'should contain link css');
    test.notEqual(-1, jsIndex, 'should contain link javascript link');
    test.done();
  },
  tearDown: function(done) {
    var htmlFile = '<!doctype html>\n' +
                   '<html>\n' +
                   '  <head>\n' +
                   '    <meta charset="utf-8">\n' +
                   '    <!-- begin:css -->\n' +
                   '    <!-- end:css -->\n' +
                   '  </head>\n' +
                   '  <body>\n' +
                   '    <!-- begin:js -->\n' +
                   '    <!-- end:js -->\n' +
                   '  </body>\n' +
                   '</html>\n';
    grunt.file.write('test/fixtures/index.html', htmlFile);
    done();
  }
};
