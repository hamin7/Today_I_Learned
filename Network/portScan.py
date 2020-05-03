import socket

s = socket.socket()
# s.connect(('166.104.177.24', 443))
# s.send('Primal Security \n')

# banner = s.recv(1024)
# print(banner)

hosts = ['166.104.177.24']

ports = [22, 445, 80, 443, 3389]

for host in hosts:
    for port in ports:
        try:
            print("[+] Connecting to "+host+":"+str(port))
            s.connect((host, port))
            s.send('Primal Security \n')
            banner = s.recv(1024)
            if banner:
                print("[+] Port "+str(port)+" open: "+banner)
            s.close()
        except:pass