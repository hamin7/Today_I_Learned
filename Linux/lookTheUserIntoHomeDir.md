# How to look the user into their home directory?

## 홈 디렉토리 유무에 따른 상태 비교

홈 디렉토리가 있는 상태에서 로그인을 하면 아래 사진처럼 커맨드라인에 계정 이름(hamin)과 현재 디렉토리(~)가 보입니다.
'~'은 홈 디렉토리를 의미합니다.
그리고 홈 디렉토리에서 "ls -al"로 파일 및 폴더를 살펴보면, 계정 정보가 담겨있는 숨겨진 파일 및 폴더들이 있다.

![usr](./images/usr.png)

홈 디렉토리가 없어진 상태에서 로그인을 하면 
1) 홈 디렉토리를 찾을 수 없다고 에러 문구가 보이며
2) root의 홈 디렉토리인 '/'으로 접속하고
3) 계정 이름과 현재 디렉토리가 보이지 않는다.

## 홈 디렉토리를 수동으로 만들기

에러문구를 살펴보면 자신의 홈 디렉토리가 어디로 설정되어 있는지 알 수 있다.

~~~markdown
Could not chdir to home directory /home/testUser:No such file or directory
~~~

먼저 주소에 맞는 디렉토리를 생성하여 홈 디렉토리를 만들도록 한다.
단, 위치에 따라 root 권한이 필요할 수 있으므로, root 계정 또는 "sudo"를 적절히 이용한다.
디렉토리를 만든 후, testUser(ID)이 소유자가 되도록 "chown"으로 디렉토리 소유자를 변경한다.

~~~markdown
$ sudo mkdir /home/testUser
$ sudo chown testUser.testUser /home/testUser
~~~

디렉토리를 만든 다음 다시 로그인을 하면 
1) 에러 문구가 없어지고
2) 방금 만든 디렉토리로 접속하게 된다.


## 계정 기본 정보 가져오기

홈 디렉토리에는 계정 정보에 관한 숨김파일 및 디렉토리들이 있다. 하지만 새로 만든 디렉토리는 텅 비어있기 때문에 홈 디렉토리에 접속하였어도 계정을 정상적으로 이용할 수는 없다.

사용자 계정들이 가져야 하는 기본정보(숨김파일들)는 "/etc/skel"안에 담겨져 있으며, 이를 복사하여 새로 만든 디렉토리 안에 저장하면 된다.
"/etc" 하위 내용들은 root 계정을 위한 정보들이므로, 복사할 때 root 계정 또는 "sudo" 권한을 사용하도록 한다.
복사 후에 복사한 파일들의 소유자를 바꾸는 것도 수행한다.

~~~markdown
$ cd /home/testUser
$ sudo cp -r /etc/skel/. .
$ sudo chown -R testUser.testUser .
~~~

위 작업까지 하면 정상적으로 홈 디렉토리가 있는 상태로 만들었음을 확인할 수 있다.