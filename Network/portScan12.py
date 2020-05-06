# 서버 스캔
import optparse
from socket import *
from threading import *
import ipaddress

# connect-scan function, deals with connecting to the host / determining if 
# ports are open / closed, takes arguments tgtHost, tgtPort
def connScan(tgtHost, tgtPort):
       try:
           connSkt = socket(AF_INET, SOCK_STREAM)
           connSkt.connect((tgtHost, tgtPort))
           connSkt.send('\r\n')

           result = connSkt.recv(100)
           # prints result if port is open
           print ('[+] ' + str(tgtPort) + '/tcp open')

       except:
           # prints result if port is closed
           print ('[-] ' + str(tgtPort) + '/tcp closed')

       finally:
           connSkt.close()

# port-scan function, takes arguments tgtHost, tgtPorts 
def portScan(tgtHost, tgtPorts):
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
        print ('\n[+] scan results for: ' + tgtIP + " Domain name is : " + tgtName[0])
        
    except:
        return
        # print ('\n[+] scan results for: ' + tgtIP)
        # sets default time out to 1
    # setdefaulttimeout(1)
       # for every port in tgtPorts
    # for tgtPort in tgtPorts:
        # creates thread, target is connScan function, arguments are tgtHost, int(tgtPort)
        #t = Thread(target=connScan, args=(tgtHost, int(tgtPort)))
        # starts the thread 
        #t.start()

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

if __name__ == '__main__':
       main()