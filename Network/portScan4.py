import nmap

nm = nmap.PortScanner()
print(nm.scan('127.0.0.1', '22-443'))
print(nm.command_line())
print(nm.scaninfo())
print(nm.all_hosts())
print(nm['127.0.0.1'].hostname())
print(nm['127.0.0.1'].state())
print(nm['127.0.0.1'].all_protocol())