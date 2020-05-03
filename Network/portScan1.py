import socket
 
# HTTPS 검사, domain으로 받기
def port_scan(domain) :
    try :
        ip = socket.gethostbyname(domain)
    except :
        return -1
    
    socket.setdefaulttimeout(2)
    
    ports = [80, 21, 22, 23, 445, 1433, 1521, 3306, 3389]
    for port in ports :
        s = socket.socket()
        if port == 80 :
            try :
                s.connect((ip, port))
#                 print("%d port is open!" % port)
                s.close()
            except :
#                 print("%d port is closed!" % port)
                return -1
        else :
            try :
                s.connect((ip, port))
#                 print("%d port is open!" % port)
                s.close()
                return -1
            except :
#                 print("%d port is closed!" % port)
                pass
            
    return 1

