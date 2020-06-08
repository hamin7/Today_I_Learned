# TCPDUMP

## TCPDUMP란?

명령줄에서 실행하는 일반적인 패킷 가로채기 소프트웨어(캡쳐 도구)로서, TCP/IP 뿐 아니라 컴퓨터에 부착된 네트워크를 통해 송수신되는 기타 패킷을 사용자가 가로채고 표시할 수 있도록 도와준다.

- 리눅스, 솔라리스, BSD, 맥 OS X, HP-UX, AIX 등 대부분 유닉스 계열 운영 체제에서 동작하며 여기서 libpcap 라이브러리를 사용하여 패킷을 잡는다.

윈도우용 tcpdump 이식판으로는 WinDump가 있으며, 이는 libpcap의 윈도우 이식판인 WinPcap을 이용한다.

tcpdump 매개변수는 아래와 같다.

tcpdump [ -AdDefKLnNOpqRStuUvxX][ -B buffer_size][ -c Count][ -C file_size][ -G rotate_seconds][ -F file][ -i interface][ -m module][ -M secret][ -r file][ -s snaplen][ -T type][ -w file][ -W filecount][ -E spi@ipaddr algo:secret, ...][ -z postrotate-command][ -Z user]

## option snapshot이란? 

--snapshot-length=snaplen

기본값 262144바이트가 아닌 각 패킷의 데이터 스냅렌 바이트를 snarf하십시오. 
제한된 스냅샷으로 인해 잘린 패킷은 출력에 "[|proto]"로 표시되며, 여기서 프로토는 잘린 프로토콜 수준의 이름이다.
스냅샷을 크게 만들면 패킷 처리에 걸리는 시간이 증가하며 패킷 버퍼링의 양이 감소한다는 점에 유의하십시오. 
이로 인해 패킷이 손실될 수 있다. 
또한 더 작은 스냅샷을 생성하면 전송 계층 위의 프로토콜의 데이터가 삭제되어 중요할 수 있는 정보가 손실된다는 점에 유의하십시오. 
예를 들어 NFS 및 AFS 요청 및 응답은 매우 크며, 스냅샷 길이가 너무 짧으면 세부 정보의 상당 부분을 사용할 수 없다.
스냅샷 크기를 기본값 이하로 줄여야 하는 경우, 관심 있는 프로토콜 정보를 캡처할 최소 숫자로 snaplen을 제한하십시오. 
snaplen을 0으로 설정하면 최근 이전 버전의 tcpdump와의 역호환성을 위해 기본값인 262144로 설정된다.

## 무엇을 하는가?

패킷들로부터 추출하는 샘플을 default값인 68Byte외의 값으로 설정할 때 사용한다(SunOS의 NIT에서는 최소가 96Byte이다). 68Byte는 IP,ICMP, TCP, UDP등에 적절한 값이지만 Name Server나 NFS 패킷들의 경우에는 프로토콜의 정보들을 Truncation할 우려가 있다. 이 옵션을 수정할 때는 신중해야만 한다. 이유는 샘플 사이즈를 크게 잡으면 곧 패킷 하나하나를 처리하는데 시간이 더 걸릴 뿐만아니라 패킷 버퍼의 사이즈도 자연히 작아지게 되어 손실되는 패킷들이 발생할 수 있기 때문이다. 또, 작게 잡으면 그만큼의 정보를 잃게되는 것이다. 따라서 가급적 캡춰하고자 하는 프로토콜의 헤더 사이즈에 가깝게 잡아주어야 한다.

## 왜 사용하는가?