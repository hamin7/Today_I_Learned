## $s에는 보통 지역변수를 $v에는 보통 결과값을
## jal은 j 포맷이고 jr은 R 포맷
## jal은 label로 향하고, jr은 레지스터를 향함


# 2019 Midterm

## 1. $s2의 값

(a)
~~~asm
addi $s2, $0, 9
~~~

$s2 == 9

(b)
~~~asm
addi $t0, $0, 3
sll $s3, $t0, 3
~~~
11을 sll 3칸 하면 11000
11000 = 16+8 = 24
$s2 == 9

(c)
~~~asm
addi $t0, $0, 12
addi $t1, $0, 9
xor $s2, $t0, $t1
~~~
$t0 == 1100
$t1 == 1001
xor == 0101 == 5
$s2 == 5

### xor은 같으면 0 다르면 1

(d)
~~~asm
addi $t0, $0, -2
addi $t1, $0, -1
nor $s2, $t0, $t1
~~~
$t0 => 2 == 0000 0010 1의보수 => 1111 1101 1++ => 1111 1110 
$t1 == 1 == 0000 0001 1의보수 => 1111 1110 1++ => 1111 1111
nor == 0000 0000
$s2 == 0

### nor은 or에서 not 한것

(e)
~~~asm
addi $t0, $0, 3
addi $t1, $0, 3
slt $s2, $t0, $t1
bne $s2, $0, ELSE
nop
j DONE
nop

ELSE: addi $s2, $s2, 2
DONE: addi $s2, $s2, 1
~~~

$s2 == 1

### slt $s2, $t0, $t1 -> $t0 < $t1이라면 $s2 == 1, 아니라면 $s2 == 0
### j DONE 뒤에 nop 있는 거겠지..? nop 없으면 실행 안되는것? pipelining 때문에?

(f) 
~~~asm
addi $t1, $0, 100
addi $s2, $0, 0

LO: slt $t2, $0, $t1
beq $t2, $0, DONE
nop

addi $t1, $t1, -1
add $s2, $s2, $t1
j LO
nop

DONE:
~~~
99+98+97+96+...+1=101*50-100=5050-100=4950
$s2 = 4950

## 2. Translate MIPS from C. f=$1, g=$2, h=$3, i=$4
(a)
~~~cpp
f = g - h;
~~~
~~~asm
sub $1, $2, $3
~~~

(b)
~~~cpp
f = (g+h) - (f+i);
~~~
~~~asm
add $7, $2, $3
add $8, $1, $4
sub $1, $7, $8
~~~

(c)
~~~c
f = 3 << 4;
~~~
~~~asm
addi $7, $0, 3
sll $1, $7, 4
~~~
$7 == 11
11 << 4 => 110000 == 32+16 == 48

(d)
~~~c
f = g*h - 3;
~~~
~~~asm
mul $5, $2, $3
addi $1, $5, -3
~~~

(e)
~~~c
if(i < 5){
    i++;
} else{
    i = -1;
}
~~~
~~~asm
slti $5, $4, 5
beq $5, $0, XXX     # $4 < 5 라면 $5 ==1이니 패스 아니면(else) XXX
nop
addi $4, $4, 1
j EXIT
nop

XXX: addi $4, $0, -1

EXIT:
~~~

(f)
~~~c
int f(int a, int b){
    return f(a-1, b) + f(a,b-1);
}
~~~
~~~asm

~~~