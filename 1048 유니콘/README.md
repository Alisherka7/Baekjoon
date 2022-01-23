# 1048 유니콘


### 문제

유니콘은 체스에서 나이트와 비슷한 말이다. 단, 나이트는 두 칸을 한 방향으로 움직이고, 또 다른 한 칸을 다른 방향으로  움직이지만, 유니콘은 두 칸보다 많은 칸을 한 방향으로 움직이고, 한 칸보다 많은 칸을 또다른 방향으로 움직인다.

좀 더 정확하게 유니콘이 움직이는 방법을 살펴보면 다음과 같다.

    유니콘을 든다.
    유니콘을 4개의 기본 방향 중 하나로 두 칸보다 많이 움직인다.
    유니콘을 방금 움직인 방향과 수직인 방향 2개 중 하나로 한 칸보다 많이 움직인다.
    유니콘을 놓는다.

체스판의 크기는 N*M이다. 체스판의 각 칸에는 알파벳의 처음 L개의 문자 중 하나가 쓰여 있다.

N, M, L, 그리고 단어가 주어진다. 유니콘이 움직인 경로 (유니콘을 놓은 곳)가 입력으로 주어진 단어와 일치하는 경우의 수를 출력하는 프로그램을 작성하시오.
### 입력

- 첫째 줄에 N, M, L이 주어진다. N과 M은 300보다 작거나 같은 자연수이다. L은 26보다 작거나 같은 자연수이다. 둘째 줄에 단어가 주어진다. 단어의 길이는 최대 50이며, 알파벳 대문자로만 이루어져 있다. 셋째 줄 부터 N개의 줄에 체스판에 쓰여 있는 단어가 주어진다.
### 출력

- 첫째 줄에 경로를 1,000,000,007로 나눈 나머지를 출력한다.
### 예제 입력 1
```
3 4 2
AB
ABBA
AAAA
BBBB
```
### 예제 출력 1
```
2
```
### 예제 입력 2
```
5 5 2
CD
ABBAA
AAABB
BBBBB
ABABA
ABBBB
```
### 예제 출력 2
```
0
```
### 예제 입력 3
```
4 4 1
AA
AAAA
AAAA
AAAA
AAAA
```
### 예제 출력 3
```
20
```
### 예제 입력 4
```
4 4 1
AAAAA
AAAA
AAAA
AAAA
AAAA
```
### 예제 출력 4
```
172
```
### 예제 입력 5
```
1 1 5
ABCDE
C
```
### 예제 출력 5
```
0
```
### 예제 입력 6
```
8 8 26
TOPCODER
AILFPSPF
DZIOMYCE
QOODZARU
YVOTLTRX
LSRIGANL
LCIUUSNF
IWVXKTDE
OVPPNXRD
```
### 예제 출력 6
```
1
```
### 예제 입력 7
```
20 20 2
AAAAA
ABBAAAAABBBBBBBABABA
ABBBBBABAAAABBAAABAA
BAAABAABAABBABABBABB
BBABBAAAABABAAAAABBA
BBABAABABBAABABABBBA
BABABAABABBBABBAABBA
BAABBAAABBBABBABAAAA
BAABBBBABAABAAAAABAA
AABABAAAAABBBABABBBA
BBAABAAABBAABAAAAABA
BAAAAABABBAAABABABBA
ABBAABBBABABBABAAABB
AAAABAAAAAAAABBBAABB
AAABABAAAAAABAAABABB
AAABABABBABABAAABBBA
AAABBBBAABBAABAAABBA
BBBBAAABBABABAAAABAB
BBAABBAABAAAABAABABA
BBBAABBABABBBBBBBBBA
AAABABBBBAABABBBBBBB
```
### 예제 출력 7
```
373977054
```
