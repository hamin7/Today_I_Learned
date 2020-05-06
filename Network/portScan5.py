from socket import *
from threading import Thread
import re
import time
 
global ThreadCnt
ThreadCnt = 0
PortList = {20:'FTP', 21:'FTP', 22:'SSH', 23:'Telnet', 24:'mail', 25:'SMTP', 80:'HTTP', 443:'HTTPS',  3306:'MySQL',}
 
def ConnScan(Target_Host, Target_Port):
    try:
        connskt = socket(AF_INET, SOCK_STREAM)
        connskt.connect((Target_Host, Target_Port))
        connskt.send('hello')
        result = connskt.recv(1024)
        file_result = open('result.txt','a')
        file_result.write( '[' + PortList[Target_Port] + ']' + '[' + str(Target_Port) + ']' + Target_Host + '\n')
        file_result.close()
        connskt.close()
    
    except:
        pass
     
    global ThreadCnt
    ThreadCnt -= 1
 
  
 
def PortScan(Target_Host, Target_Port):
    global ThreadCnt
    for ip in Target_Host:
        print('Scanning : ' + ip)
        #print str(ThreadCnt)
        for port in Target_Port:
            while True :
                if ThreadCnt > 500  :
                    continue
                t = Thread (target=ConnScan, args=(ip, port))
                ThreadCnt +=1
                t.start()
                break
             
             
     
  
 
def main():
    # file = open("iplist.txt", "r")
    Target_Host = [166.104.177.24]
    Target_Port = PortList.keys()
    cnt = 0
    for text in file.readlines():
        text = text.rstrip()
        regex = re.findall(r'(?:[\d]{1,3})\.(?:[\d]{1,3})\.(?:[\d]{1,3})\.(?:[\d]{1,3})$', text)
        if regex is not None and regex not in Target_Host:
            cnt += 1
            Target_Host.append("".join(regex))
             
 
    print (Target_Host)
    PortScan(Target_Host, Target_Port)
  
if __name__ == '__main__':
    main()

