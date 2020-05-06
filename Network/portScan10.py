import os
import shutil

f = open("/Users/hamin/target.txt",'r')
while True:
    line = f.readline()
    if not line:
        break
    line = line.split("\n")
    target_ip = line[0]
    nmap_command = "sudo nmap -T4 -O -A -oA " + line[0] + " " + target_ip
    print("scanIP : ", nmap_command)
    os.system(nmap_command)

    if not os.path.exists(line[0]):
        os.makedirs(line[0])

        nmap_xml = line[0] + ".xml"
        nmap_nmap = line[0] + ".nmap"
        nmap_gnmap = line[0] + ".gnmap"
        target_dir = line[0]

        try:
            shutil.move(nmap_gnmap, target_dir)
            shutil.move(nmap_nmap, target_dir)
            shutil.move(nmap_xml, target_dir)
        except:
            pass