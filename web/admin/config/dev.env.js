'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

//获取本机ip地址
function getIPAdress() {
  var interfaces = require('os').networkInterfaces();　　
  for (var devName in interfaces) {　　　　
      var iface = interfaces[devName];　　　　　　
      for (var i = 0; i < iface.length; i++) {
          var alias = iface[i];
          if (alias.family === 'IPv4' && alias.address !== '127.0.0.1' && !alias.internal) {
              return alias.address;
          }
      }　　
  }
}

const ip = getIPAdress();
console.log(ip);
module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  BASE_API: `"http://${ip}:7777"`,
})
