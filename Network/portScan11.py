# 포트 스캔
import optparse
import socket
import nmap

port = '21,22,23,25,42,53,70,79,80,88,110,118,143,156,161,220,443,993,8080'

def nmapScan(tgtHost, tgtPort):
        nmScan = nmap.PortScanner()
        nmScan.scan(tgtHost, tgtPort)
        state = nmScan[tgtHost]['tcp'][int(tgtPort)]['state']
        print(" [*] " + tgtHost + " tcp/" + tgtPort + " " + state)

def main():
        parser = optparse.OptionParser('usage %prog <options> \n-H <target host> : input target host name \n-p <target port> : input target port name \n-A <all port> : target is all port')
        parser.add_option('-H', dest='tgtHost', type='string', help='specify target host')
        parser.add_option('-p', dest='tgtPort', type='string', help='specify target port[s] separated by comma')
        parser.add_option('-A', dest='allPort', action='store_true', help='target port is all')
        (options, args) = parser.parse_args()
        tgtHost = options.tgtHost
        tgtPorts = str(options.tgtPort).split(',')
        allPort = options.allPort

        if ((tgtPorts[0] == 'None') & (allPort == None)) | (tgtHost == None) :
                print(parser.usage)
                exit(0)

        if (allPort == True):
                tgtPorts = str(port).split(',')
                for tgtPort in tgtPorts:
                        nmapScan(tgtHost, tgtPort)

        else:
                for tgtPort in tgtPorts:
                        nmapScan(tgtHost, tgtPort)


if __name__ == '__main__':
        main()   