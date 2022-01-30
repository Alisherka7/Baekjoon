#include<cstdio>
#include<unordered_map>
#include<algorithm>
#include<cmath>
#include<iostream>
using namespace std;
using ll = long long;
const ll LIMIT = (1ULL << 63) - 1, RANGE = 2e9;
const double LOG_L = log(LIMIT);
ll limit[63] = {};
 
// a^n
ll _pow(ll a, int n) {
    if (n <= 1) return n % 2 ? a : 1;
    ll h = _pow(a, n >> 1);
    return h * h * (n % 2 ? a : 1);
}
 
// n보다 크거나 같은 a^k에 대해 a를 찾는 함수. 단, maxi보다 커질 순 없음. maxi는 g함수에 의해 계산됩니다.
ll f(ll& n, int k, ll& maxi) {
    ll l = 1, r = maxi;
    ll mid;
    while (l <= r) {
        mid = (l + r) >> 1;
        if (_pow(mid, k) < n) l = mid + 1;
        else r = mid - 1;
    }
    return l;
}
 
// a^k 꼴에서 오버플로우를 방지하기 위해 a의 최대값을 찾는 이분탐색
ll g(int k) {
    ll l = 2, r = 1LL << 40, mid;
    mid = (l + r) >> 1;
    while (l <= r) {
        mid = (l + r) >> 1;
        if (k * log(mid) + 1e-9 <= LOG_L) l = mid + 1;
        else r = mid - 1;
    }
    return r;
}
unordered_map<ll, ll> dp; // 이미 방문했던 지점을 두 번 이상 방문하지 않기 위함. 다이나믹 프로그래밍
ll gv(ll n) {
    if (n == 1) return 0;
 
    ll& ret = dp[n];
    if (ret) return ret;
    ret = n - 1; // 1부터 1씩 증가해서 접근하는 경우의 답(1번 연산)
    ll l, r;
 
    // 승수 고정
    // 왼쪽(변수 l), 오른쪽(변수 r)에 대해 l^i <= n <= r^i을 만족하는 값을 찾습니다.
    for (int i = 61; i > 1; i--) {
        r = f(n, i, limit[i]);
        l = r - 1;
        if (1 < l && RANGE > abs(n - _pow(l, i))) ret = min(ret, gv(l) + 1 + abs(n - _pow(l, i)));
        if (1 < r && RANGE > abs(n - _pow(r, i))) ret = min(ret, gv(r) + 1 + abs(n - _pow(r, i)));
    }
    return ret;
}
int main() {
    ll N, i;
    for (i = 2; i < 62; i++)
        limit[i] = g(i);
    scanf("%lld", &N);
    printf("%lld", gv(N));
    return 0;
}
