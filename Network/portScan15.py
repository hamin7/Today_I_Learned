import nmap
import time

def main():
    nm = nmap.PortScanner(nmap_search_path=('./venv/lib/python3.7/site-packages','nmap', '/usr/bin/nmap', '/usr/local/bin/nmap', '/sw/bin/nmap', '/opt/local/bin/nmap')) 
    nm.scan(hosts='166.104.177.0/24', arguments='-n -sP')   # 스캔할 호스트 및 argument 설정.
    hosts_list = [(x, nm[x]['status']['state'])
                for x in nm.all_hosts()]

    for host, status in hosts_list:
        print(host + ' : ' + status)

    print('\n Total number of web servers: ' + str(len(hosts_list)))
    print('\n Scan duration : ', time.time() - start, 'sec')

if __name__ == '__main__':
    start = time.time() # 시간 측정 시작
    main()