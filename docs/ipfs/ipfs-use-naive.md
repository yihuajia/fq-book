# IPFS简单使用

!> 在看了有位该书读者的邮箱来信后，确实若是被勒令这不可抗拒的因素删除仓库也是毫无办法，何况我已经因其他缘由被迫删除好几次仓库，而这次就需要着手准备使用ipfs这类去中心化的网络应用了

## 安装

打开[ipfs](https://ipfs.io/docs/install/)，选择[getting started with ipfs](https://ipfs.io/docs/getting-started/)

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_092613.png)

[install ipfs now](https://ipfs.io/docs/getting-started/)

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_093125.png)

[download ipfs for your platorm](https://dist.ipfs.io/#go-ipfs)

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_093548.png)

点击即可下载

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_093946.png)

解压并用CLI进入当前文件夹，输入`ipfs.exe init`完成初始化操作

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_095305.png)

`ipfs.exe daemon`开启守护进程

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_095836.png)

输入`http://localhost:5001/webui`进入主界面，在`connection`版块中可以看到全球共有267个节点，这一数字也是动态变化的

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_100854.png)

## 上传文件

在`files`版块中点击`create folder`创建文件夹，目前除图片外，若要正确上传文件，必须使用文件夹的`hash`加载

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_113127.png)

选择需要上传的文件，右键`copy hash`，转到DAG板块中粘贴进输入框GO

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_114055.png)

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_114452.png)

将如上hash连接复制，并在前面加上`htttps://ipfs.io`

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_114812.png)

hash链接始终是太长了，就需要使用[tinyURL](https://tinyurl.com/)生成短链接

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_120243.png)

测试， [https://tinyurl.com/ycn3d6nj](https://tinyurl.com/ycn3d6nj)

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_121017.png)

你愿意把它当作无限存储的网盘也可以，只不过任何人包括你在内不能删除它罢了；速度的话，聊天群、问答社区以及贴吧各种宣传，人多了应该自然也就会快一些。

## 部署静态网站

在这里我已预先提供了一份基于gitbook生成的静态网站文件夹

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_164203.png)

命令行定位到文件夹的上层文件夹，执行`ipfs add -r web-book`上传整个目录

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_171923.png)

`web-book`文件夹的指令输出的最后一行的哈希值，就是你的网站的根目录

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_172511.png)

复制最后一行的hash值

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_173142.png)

输入`localhost:8080/ipfs`后面追加已复制的哈希值即可

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_173114.png)

虽数据已添加到当前的ipfs节点中，但是并没有同步到ipfs网络；此时还只是离线部署，现在要将它发布在互联网上。

运行了`ipfs add -r` 的指令的窗口不要关闭，新建一个cmd命令行窗口

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_180127.png)

进入ipfs文件夹再输入`ipfs.exe daemon`便发布成功了

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_175819.png)

测试，[https://ipfs.io/ipfs/QmVbeGQ7kEgLev9VUZeL5Kzpn4fBL9Pcq3iwpkAJjGSnHi/](https://ipfs.io/ipfs/QmVbeGQ7kEgLev9VUZeL5Kzpn4fBL9Pcq3iwpkAJjGSnHi/)

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_181051.png)

## IPNS同步更新

由于去中心化的缘故，一但上传也就不能更改了，为此需要ipns的新目录以及节点id映射在新的hash值，用户只需访问`ipfs.io/ipns/节点id`查看相关的更新，也就是说以前的`ipfs.io/ipfs/目录hash值`被废弃了；这也看出来去中心化一个弊端就是产生大量垃圾，虽然链接很长很长...

为了演示方便在`book.json`文件中添加了新的插件，并再次使用了`ipfs add -r web-book`指令使其生成新的hash值。

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_213304.png)

使用`ipfs name publish`后面跟上站点根目录的hash值进行发布操作

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_220829.png)

使用`ifps id`查看节点id

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_221733.png)

`ipfs name resolve`后面追加已查到的节点id

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_222850.png)

此时，已经可以本地访问了，`localhost:8080/ipns/节点id`

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_223735.png)

关掉之前的使用`ipfs daemon`指令的窗口，再打开命令行窗口重新运行该指令即可，由于访问人数不多再加上GFW的干扰，可能会很慢。

这里已提供一个短链接地址：[http://bit.ly/2L1C77f](http://bit.ly/2L1C77f)

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_225417.png)

## 备份

备份这很重要，但也很简单，在`C:\Users\lorem\.ipfs`下找到`config`文件并将其拷贝至云盘即可,lorem是我的用户名

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/2018-05-27_232208.png)

