# goagent

> 原文：[GoAgent原理和实现\(一\) ：基本原理介绍](https://studygolang.com/articles/4319)&emsp;作者：[zhaqiwen](https://my.csdn.net/zhaqiwen)

 GoAgent的结构其实很简单。通过对它的配置和使用来看，它的基本结构应该是这样的

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/goagengstuture.jpg)

 正常上网的情况是下面这条红色的路径。由于网络一般通过明文通信，且需要请求公共的DNS服务器。当你请求的内容被认为不符合规矩时，长城牌防火墙就会阻断你的请求数据。

于是，GoAgent仅仅是简单的通过Google GAE API绕过了GFW。它的原理是在自己的本机安装client代理，将你需要请求的数据通过浏览器的代理设置，重新定向到了图中的Client端。client加密你的数据，并将其发送到GAE的Server端，在那里Server将数据解密，帮助你请求需要的数据，并回传给Client。

可以发现，在配置GoAgent时，主要需要两部分操作。Server的配置上传操作和浏览器端的更改代理设置操作。上网时，只要打开local中的client程序就可以畅通无阻了。而其他的那些洋洋洒洒的篇幅，主要是教你Google账号的设置和GAE的申请设置，如果你熟悉它们，完全可以略过。

应该清楚实现它的方法了。编写两部分软件，做好它们之间的通信就即可。client端的实现可以用任何语言。GoAgent选择了Python，并利用Python优秀的跨平台特性，实现了对各种操作系统（包括手机和路由设备）的支持。

