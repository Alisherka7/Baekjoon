# 1090. 체커


### 문제

N개의 체커가 엄청 큰 보드 위에 있다. i번 체커는 (xi, yi)에 있다. 같은 칸에 여러 체커가 있을 수도 있다. 체커를 한 번 움직이는 것은 그 체커를 위, 왼쪽, 오른쪽, 아래 중의 한 방향으로 한 칸 움직이는 것이다.
### 입력

- 첫째 줄에 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 각 체커의 x좌표와 y좌표가 주어진다. 이 값은 1,000,000보다 작거나 같은 자연수이다.
### 출력

- 첫째 줄에 수 N개를 출력한다. k번째 수는 적어도 k개의 체커가 같은 칸에 모이도록 체커를 이동해야 하는 최소 횟수이다.
### 예제 입력 1
```
4
15 14
15 16
14 15
16 15
```
### 예제 출력 1
```
0 2 3 4
```
### 예제 입력 2
```
4
1 1
2 1
4 1
9 1
```
### 예제 출력 2
```
0 1 3 10
```
### 예제 입력 3
```
2
4 7
4 7
```
### 예제 출력 3
```
0 0
```
