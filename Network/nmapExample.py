import os

# options인자는 CLI의 옵션을 받기 위해. 
def get_nmap(options, ip):
    command = "nmap" + options + " " + ip
    process = os.popen(command)
    results = str(process.read())
    return results

print(get_nmap(' -F', '166.104.177.24'))