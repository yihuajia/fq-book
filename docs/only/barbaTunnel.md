# BarbaTunnel

!>barbaTunnel已有多年没更新了，再加上VPN服务器可能自身存在些许问题，使得这款软件不怎么好用；我测试了一下也不是很满意，直白的说就是连接OpenVPN的操作并不成功。

> 编译原文：[BarbaTunnelCoder/BarbaTunnel](https://github.com/BarbaTunnelCoder/BarbaTunnel/) 

BarbaTunnel是一款可助您绕开防火墙与互联网审查的软件，它是一个点对点隧道，因此您需要墙外网络的服务器。

在大多数情况下，您可以简单地使用VPN或任何代理服务器，但是当您使用VPN时，防火墙知道您使用VPN，它不知道您在做什么，VPN和其他代理服务器不会隐藏指纹。BarbaTunnel是您的网络上的一个层，并尝试使现有的VPN数据包查看传统数据包。实际上BarbaTunnel不能单独使用，它可以与VPN协同工作。

因此，如果您拥有VPN并且您没有任何问题，则不需要BarbaTunnel，但如果防火墙阻止您的VPN连接或防止VPN连接速度降低，则BarbaTunnel可能对您有所帮助。

注意：BarbaTunnel不是独立的隧道，应在运行BarbaTunnel后运行隧道应用程序或使用标准的VPN连接。

![](https://raw.githubusercontent.com/loremwalker/fq-book/master/docs/images/home_barbatunneldiagram.png)

