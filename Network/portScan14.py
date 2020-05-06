import optparse
from threading import *
from socket import *
import ipaddress
import time

screenLock = Semaphore(value=1)
cnt = 0

def printResult():
    print('\n Total number of web servers: ' + str(cnt))
    print('\n Scan duration : ', time.time() - start, 'sec')

def connScan(tgtHost, tgtPort):
    try:
        connSkt = socket(AF_INET, SOCK_STREAM)
        connSkt.connect((tgtHost, tgtPort))
        # connect 까진 됨
        #connSkt.send('Hi Hanyang\r\n')
        # send부터 안됨.
        #results = connSkt.recv(100)
        # print('[+] %d/tcp open' % tgtPort)
        result = str('[+] %d/tcp open' % tgtPort)
        return result
    except:
        result = str('[-] %d/tcp closed' % tgtPort)
        return result
    finally:
        connSkt.close()

def portScan(tgtHost, tgtPorts):
    global cnt
    try:
        tgtHost = str(tgtHost)
        tgtIP = gethostbyname(tgtHost)
    except:
        print("[-] Cannot resolve '%s' : Unknown host" %tgtHost)
        return
    
    try:    
        tgtName = gethostbyaddr(tgtIP)
        cnt += 1
        screenLock.acquire()
        print('\n[+] Scan Results for: ' + tgtIP + " Domain name is : " + tgtName[0])
        # for tgtPort in tgtPorts:
        #     result = connScan(tgtHost, int(tgtPort))
        #     print(result)
    except:
        return
    finally:
        screenLock.release()
    
def main():
    parser = optparse.OptionParser('usage %prog -H <target host> -p <target port>')
    parser.add_option('-H', dest = 'tgtHost', type = 'string', help = 'specify target host')
    parser.add_option('-p', dest = 'tgtPort', type = 'string', help = 'specify target port[s] separated by comma')

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
            setdefaulttimeout(1)
            # 스레드 생성
            t = Thread(target=portScan, args=(tgtHost, tgtPorts))
            t.start()
        
        t.join()    # 스레드가 종료될 때까지 기다림
        printResult()
        
if __name__ == '__main__':
    start = time.time() # 시작 시간 설정
    main()

    

    