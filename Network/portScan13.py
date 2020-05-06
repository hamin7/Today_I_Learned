# 서버 스캔
import optparse
from socket import *
from threading import *
import ipaddress
import time

cnt = 0

# port-scan function, takes arguments tgtHost, tgtPorts 
def portScan(tgtHost, tgtPorts):
    global cnt
    try:
        tgtHost = str(tgtHost)
        # tries to get target IP address
        tgtIP = gethostbyname(tgtHost)
    except:
        # if unsuccesful, prints out following result
        print ('[-] cannot resolve ' + tgtHost + ': unknown host')
        return

    try:
        # tries to get target address
        tgtName = gethostbyaddr(tgtIP)
        cnt += 1
        print ('\n[+] scan results for: ' + tgtIP + " Domain name is : " + tgtName[0])
        
    except:
        return

def main():
       parser = optparse.OptionParser('usage %prog -t <target-host> -p <target-port(s)>')
       parser.add_option('-t', dest='tgtHost', type='string', help='specify target host')
       parser.add_option('-p', dest='tgtPort', type='string', help='specify target port(s), seperated by a comma, seperate ranges with a -')
       (options, args) = parser.parse_args()

       if (options.tgtHost == None) | (options.tgtPort == None):
           print (parser.usage)
           exit(0)
       else:
            tgtHost = options.tgtHost
            if tgtHost.endswith('.0'):
                hosts = ipaddress.ip_network(tgtHost+'/24')
            else:
                hosts = [tgtHost]

            if '-' in str(options.tgtPort):
                tgtPorts = options.tgtPort.split('-')
                tgtPorts = range(int(tgtPorts[0]),int(tgtPorts[1]))
            else:
                tgtPorts = str(options.tgtPort).split(',')
            
            for tgtHost in hosts:
                # print(tgtHost)
                portScan(tgtHost, tgtPorts)
            
            print('\n Total number of web servers: ' + str(cnt))
            print('\n Scan duration : ', time.time() - start, 'sec')

if __name__ == '__main__':
    start = time.time() # 시작 시간 설정
    main()