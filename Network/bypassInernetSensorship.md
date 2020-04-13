# Bypassing SNI blocking internet censorship

## Department of Information System 2017029134 Hamin Lee.

After the https block execution, the bypass method is shared and supported by each community. This is because there is concern that the government's method of censorship leads to the inspection of personal information while opposing indiscriminate censorship. For this reason, as in the Kakao Talk temple controversy, a bypass method is shared to strengthen security. Anyway, even in China, censorship goes away. The United States implicitly supports bypass programs to spread the truth to the Chinese Communist Party. Koreans reading this article can ride there.

For some reason, in Safari for ios, xHamster, pornhub, and other illegal comics sites will not be accessed the first time they are accessed, but press refresh several times to enter. It is also valid in some cases for Windows Chrome. Check out Chrome for Android. I am not sure if I am currently blocked.

In this description, there are many cases where mobile or pc-only items are modified to be applied to other platforms.

## PC, mobile common
- SNI encryption - Encrypts plaintext SNI, a vulnerability that could cause the censorship. Firefox is the only browser supported because it is not yet standard. You can set up DNS to 1.1.1.1 through Firefox Windows and Android, and enable TLS 1.3, encrypted SNI (eSNI), and DNS Over HTTPS to avoid government hacking and access via https. Censorship attempts can be blocked, but not available if the web server does not support TLS 1.3 and ESNI connections.
See this document for how to use it.

- VPN - Slow but the most obvious way is VPN. VPN encrypts all communication processes, so it is impossible to know where to access, so blocking through hacking is also impossible. In addition to blocking HTTPS, existing HTTP blocking can be avoided. In fact, even in China, which is famous for its golden shield, it is technically trying to block VPNs, but only some free VPNs are temporarily blocked. That is why China is considering it as a way for the Public Security to visit and catch whether it was considered technically impossible to prevent it. However, in the case of a VPN, if the VPN server is not trusted, the security risk is extreme, and a secure and fast VPN has a limitation in that it is a paid service. This is because the VPN server takes care of the user's packet processing. Since operating systems that do not support VPN access are rare, the compatibility is wide. See the VPN documentation for details.

- Proxy - There is a method of using a proxy site for PC and mobile sharing, but the latency is higher at loading than direct access or VPN. The domain of the proxy site you want to use must be https. It is suitable for brief use on a public computer where it is difficult to install programs or change network configuration.

- Light mode (formerly: Data Saver) - Even when using the data saver provided by browsers such as Chrome and Firefox, it was possible to bypass the blocking. Google's proxy server (by bypassing the server via a connection). It is a proxy function, but includes data saving function. The fatal drawback is for GET transfers only. The reason is that it cannot be cached individually in the case of POST. It is not a proxy server, but a CDN method like Cloudflare.
Puffin Browser-Because it uses its own VPN, it can bypass all blocking without any additional procedures.
Dynamic network-The site also provides a mobile version in QR code format.

- Using the cable Internet - The decision of blocking the Internet site is made by the Korea Communications Commission, but the actual blocking work is done by the ISP that received the list of blocked sites. SKT, SKB, KT, and LG U + started blocking https using SNI fields, but cable broadcasters do not block https or because of the lack of technology or against censorship. As of March 2020, most of the illegal sites are normally accessed if https is supported on the Internet lines of LG Hello, TV, and Delive.

## PC

- Safe Visit https - Originally, it is a program that fragments packets so that a third party cannot see my network. It's just fragmenting packets without using a VPN, but it works better than any program. It's a GUI environment and works by just running and clicking the Connect button. Fixed a driver unloading problem that caused the network to become unstable even when GoodbyeDPI terminated. An Android version is also provided.

- GoodbyeDPI http https - Bypassing a packet that is frequently used for censorship or using a program called GoodbyeDPI that modulates the packet so that it is difficult to analyze can be bypassed. Originally intended to neutralize the Russian government's website blocking, it does not require any additional measures other than running the program and is free from ping and speed issues through VPN, and above all, it does not depend on a specific browser or a specific site. It is regarded as the most powerful means possible. However, be cautious that compatibility problems may occur if the program blocks the redirect and connection reset packets generated for normal reasons, or if the site does not understand the result of packet tampering. Still, it's much better than the ESNI, a completely new technology, for a bypass right now. However, if ESNI is fundamentally blocked, this program is only for real-time processing, so ESNI is better in terms of security.

- GreenTunnel - While GoodbyeDPI only works on Windows, this program can be used on Windows, macOS and Linux. For Linux, only the Debian family provides binary releases, but since it is a pure Node.js application, it can be used simply by power users familiar with Linux and CLI.

- SoftEther VPN Client + VPN Gate - The VPN Gate module is integrated into SoftEther VPN, a non-profit VPN client. When the program is turned on for VPN access, the user's computer also becomes a VPN server, allowing other users to access it. It's a kind of volunteer. So, not only Korea, but also VPN servers from around the world, which boasts giga internet speed and low latency, are overflowing. However, due to the nature of the server, the majority of servers are using domestic ISPs in the region. You can get out of censorship by choosing a VPN server in a country without an internet censorship system. If you are a Korean resident, it is recommended to use a Japanese VPN server nearby.

- Tor Browser - Can be used for blocking bypass, but its speed is very slow. In addition, the small bandwidth makes it unsuitable for video viewing. Anonymity is very strong, but because of this, many sites are suspicious of users who access through Tor, or they are often blocked at all, making it difficult to use. Use other means of bypass.

- Adjusting the MTU value - Another method is to lower the MTU value used in the network and split the query to send it. In this method, the address query is set to be divided into two or more, so it is not a valid address during analysis, and it is a method of avoiding it. You may not be able to access certain sites. If you don't like the above program, you can try it.
You can also access the Google Translator-or link to the Google Translator. Since all queries are made on the Google side, it is a breakthrough method that cannot block or intercept the Google Translation Service itself or block it unless the Google side cooperates. However, there is a disadvantage that login is not possible due to the characteristics of the method.

- Meerkat browser - A browser equipped with a bypass function for Chromium developed by a domestic developer. Similar to the past Dodge Chrome. It is fast and bypasses automatically when you use the browser without the need for further action. It also comes with an Android version and can be downloaded from the Play Store.

- Unicorn HTTPS http https - HTTPS bypass program for PC made by Unicorn developer, famous for advertisement blocking application. Released on August 31, 19 for macOS. ##
Chrome extensions-If you are in a chrome extension, there is a chrome web store. There are VPN, proxy, etc.
Opera browser-The browser is equipped with a VPN. As it is a free VPN operated by a for-profit organization, you should not expect much security.

## mobile
### Android
- Google Intra, Cloudflare 1.1.1.1 App - These apps change the DNS address set in the terminal to its DNS address and avoid the interception of TLS packets through the TLS over DNS method. How to install and use Configure a local SOCKS proxy on the client side and limit it to TLS-related packets to connect to its DNS server via VPN. 1.1.1.1 TLS over DNS option based on app,
<ul>
    <li> Split Tunnel - Only DNS over TLS and DNS over HTTPS communicate through TLS over DNS.
    <li> Full Tunnel - TLS over DNS is used for all communication (HTTPS, secure DNS, etc.) transmitted through TLS.
</ul>
Since this method is used to block HTTPS as well as DNS servers as well as routing servers on carrier lines, it should not be used under normal circumstances. You can bypass the net. In the KT line, there have been many reports of 1.1.1.1 not working, and Android 6.0 and below are said to be working.
For reference, the HTTPS blocking can be bypassed by the TLS over DNS technique, but the existing HTTP blocking cannot be bypassed.

- Safe Visit - Similar to Intra. The PC version of SafeVisit fragments the packets, while the Android version takes a similar approach to Intra. It is fast and there is no risk of personal information exposure.

- ASPEAR (formerly Sniper) - App developed by domestic developers. It has the advantage that it bypasses interception and does not slow down because it chose to transmit by splitting and sending only the Client Hello packet containing the SNI field, rather than bypassing the MTU. It works normally on Android 5.0 or higher. As of February 24, 2019, it declared full free and removed all advertisements. IOS was also released on June 12th.

- Dawn - Likewise domestic developer development. It is fast and there is no risk of personal information exposure.

- Unicorn HTTPS bypass app - App Store, the highest ranking among HTTPS bypass apps based on Google Play. It is a company that created a unicorn ad blocking app and is highly recognized in Korea. Currently, Android, iOS, and Windows versions have been released, and all existing HTTP blocks are bypassed.

- Puffin browser - It is a browser that bypasses the US IP because the VPN is built-in. This allows bypass.

- Opera Mini

- VPN Gate Connector - VPN app using the VPN Gate module. In the free version, ads often appear inside the app.

### iOS
- Unicorn HTTPS
- Sniper

### Cloud Server
- Google cloud computing engine
- Amazon web service EC2
- Microsoft Azure

It is also a good idea to rent a cloud server if your funds are broad. When a server is rented, an instance for the user is created inside the server like a virtual machine, and the user can remotely access and use the instance. It's like renting a virtual machine located inside a server. Websites are already operating by installing the http server daemon on a cloud server instance and linking the website with the daemon.

When renting a server, you can select the server location, OS, CPU performance, RAM capacity, HDD and SSD capacity, and whether to use the GPU. The OS can be selected from Ubuntu, Cent OS, Windows Server 2019, and even whether to include a GUI.

In order to connect to the server instance, you only need to know the public IP (external IP) address, account name, and account password of the server. After remote access, you can use the same as your personal PC.

However, when the server instance is activated, it is charged unconditionally. When not using a server instance, it is best to terminate the instance and activate it only when necessary. Note that as the traffic increases, the server rental cost may increase exponentially. Be careful not to block remote access even in firewall settings. Incorrect firewall settings may make remote access impossible or difficult to recover.

#### Direct access from server instance
You can install browsers such as Chrome and Firefox directly on the server instance.

In the case of the cloud server, it is free from censorship because it does not use the line of a domestic carrier. Because of this, sites blocked in Korea can be accessed from the server instance.

#### VPN deployment on server instance
If you can afford the huge cost of traffic, you can even build your own VPN on the server.

You can rent a server instance from the cloud service and install the VPN server daemon. It should be taken into account that as the number of VPN users increases, the server needs higher performance.

Building a VPN by renting a server in a domestic data center is meaningless because it uses the domestic line as it is.

Outline is a non-profit project that develops an open source VPN server daemon to be installed on instances inside the server.

Please refer to the document for details.

### Commercial network (domestic)
The commercial network is a contract network, but if you censor it and intercept the packet, the responsiveness decreases, so not only does the overall quality decrease, but the usage is also largely unsuccessful, so it is generally not good to search the server on the Internet. So if you access a blocked address in this network, it works! As an aside, if you tried this method, but it is still blocked, you can say that the service is only a commercial network on the outside and actually did not enter the IDC and serviced in the home network.