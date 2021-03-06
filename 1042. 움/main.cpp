# pragma GCC optimize ("O3")
# pragma GCC optimize ("Ofast")
# pragma GCC optimize ("unroll-loops")

#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
#include <ext/rope>

using namespace std;
using namespace __gnu_pbds;
using namespace __gnu_cxx;

typedef long long ll;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef tuple<int, int, int> ti3;
typedef tuple<int, int, int, int> ti4;
typedef stack<int> si;
typedef queue<int> qi;
typedef priority_queue<int> pqi;
typedef pair<ll, ll> pll;
typedef vector<ll> vl;
typedef tuple<ll, ll, ll> tl3;
typedef tuple<ll, ll, ll, ll> tl4;
typedef stack<ll> sl;
typedef queue<ll> ql;
typedef priority_queue<ll> pql;
typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update>ordered_set;

const int dx[4] = { 1,0,-1,0 };
const int dy[4] = { 0,1,0,-1 };
const int ddx[8] = { 0,0,1,1,1,-1,-1,-1 }, ddy[8] = { 1,-1,1,0,-1,1,0,-1 };
ll POW(ll a, ll b, ll MMM) { ll ret = 1; for (; b; b >>= 1, a = (a*a) % MMM)if (b & 1)ret = (ret*a) % MMM; return ret; }
ll GCD(ll a, ll b) { return b ? GCD(b, a%b) : a; }
ll LCM(ll a, ll b) { if (a == 0 || b == 0)return a + b; return a / GCD(a, b) * b; }
ll INV(ll a, ll m) {
	ll m0 = m, y = 0, x = 1;
	if (m == 1)	return 0;
	while (a > 1) {
		ll q = a / m;
		ll t = m;
		m = a % m, a = t;
		t = y;
		y = x - q * y;
		x = t;
	}
	if (x < 0) x += m0;
	return x;
}
pll EXGCD(ll a, ll b) {
	if (b == 0) return { 1,0 };
	auto t = EXGCD(b, a%b);
	return { t.second,t.first - t.second*(a / b) };
}
bool OOB(ll x, ll y, ll N, ll M) { return 0 > x || x >= N || 0 > y || y >= M; }
#define X first
#define Y second
#define rep(i,a,b) for(int i = a; i < b; i++)
#define pb push_back
#define all(x) (x).begin(), (x).end()
#define sz(a) ((int)(a.size()))
#define sf1(a) cin >> a
#define sf2(a,b) cin >> a >> b
#define sf3(a,b,c) cin >> a >> b >> c
#define sf4(a,b,c,d) cin >> a >> b >> c >> d
#define sf5(a,b,c,d,e) cin >> a >> b >> c >> d >> e
#define sf6(a,b,c,d,e,f) cin >> a >> b >> c >> d >> e >> f
#define pf1(a) cout << (a) << ' '
#define pf2(a,b) cout << (a) << ' ' << (b) << ' '
#define pf3(a,b,c) cout << (a) << ' ' << (b) << ' '<< (c) << ' '
#define pf4(a,b,c,d) cout << (a) << ' ' << (b) << ' '<< (c) << ' '<< (d) << ' '
#define pf5(a,b,c,d,e) cout << (a) << ' ' << (b) << ' '<< (c) << ' '<< (d) << ' '<< (e) << ' '
#define pf6(a,b,c,d,e,f) cout << (a) << ' ' << (b) << ' '<< (c) << ' '<< (d) << ' '<< (e) << ' ' << (f) << ' '
#define pf0l() cout << '\n';
#define pf1l(a) cout << (a) << '\n'
#define pf2l(a,b) cout << (a) << ' ' << (b) << '\n'
#define pf3l(a,b,c) cout << (a) << ' ' << (b) << ' '<< (c) << '\n'
#define pf4l(a,b,c,d) cout << (a) << ' ' << (b) << ' '<< (c) << ' '<< (d) << '\n'
#define pf5l(a,b,c,d,e) cout << (a) << ' ' << (b) << ' '<< (c) << ' '<< (d) << ' '<< (e) << '\n'
#define pf6l(a,b,c,d,e,f) cout << (a) << ' ' << (b) << ' '<< (c) << ' '<< (d) << ' '<< (e) << ' ' << (f) << '\n'
#define pfvec(V) for(auto const &t : V) pf1(t)
#define pfvecl(V) for(auto const &t : V) pf1(t); pf0l()

ll MOD = 1e9+7;
ll D[2603];
ll sumD[2603];
int amino[64];
map<string,int> a2i;
int c2i(char c){
  if(c=='A') return 0;
  if(c=='C') return 1;
  if(c=='G') return 2;
  return 3;
  
}
int convert_codon(string a){
  int ret = 0;
  rep(i,0,3){
    if(a[i] == 'A') ret = (ret<<2)+0;
    else if(a[i] == 'C') ret = (ret<<2)+1;
    else if(a[i] == 'G') ret = (ret<<2)+2;
    else ret = (ret<<2)+3;
  }
  return ret;
}
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0);
  fill(amino,amino+64,-1);
  string DNA_tmp;
  int DNA[2603]={}; // 1-indexed
  sf1(DNA_tmp);
  int N = sz(DNA_tmp);
  rep(i,0,N){
    if(DNA_tmp[i]=='A') DNA[i+1]=0;
    else if(DNA_tmp[i]=='C') DNA[i+1]=1;
    else if(DNA_tmp[i]=='G') DNA[i+1]=2;
    else DNA[i+1]=3;    
  }
  int MM;
  sf1(MM);
  while(MM--){
    string C,A;
    sf2(C,A);
    if(a2i.find(A) == a2i.end()) a2i[A] = sz(a2i);
    amino[convert_codon(C)]=a2i[A];
  }
  D[0] = 1;
  sumD[0] = 1;  
  vi occur[4];
  int before[64]; // before[a] : ????????? a?????? amino??? before[a]????????? ???????????? ????????????
  fill(before,before+64,0);
  rep(i,1,N+1){
    int current[64]; // ?????? ???????????? a?????? amino??? ????????? ???????????? ??????????????????.
    fill(current,current+64,-1);
    // AA@ CC@ GG@ TT@
    rep(j,0,4){
      if(sz(occur[j]) < 2) continue;
      int num = amino[20*j+DNA[i]];
      if( num == -1 ) continue;
      if(current[num] >= occur[j][sz(occur[j])-2]) continue;
      current[num] = occur[j][sz(occur[j])-2];
    }
    // etc
    rep(j,0,4){
      if(sz(occur[j]) < 1) continue;
      rep(k,0,4){
        if(j==k) continue;
        if(sz(occur[k]) < 1) continue;
        int num = amino[16*j+4*k+DNA[i]];
        if(num == -1) continue;
        int jpos,kpos;
        kpos = occur[k].back();
        auto tmp = lower_bound(all(occur[j]),kpos);
        if(tmp == occur[j].begin()) continue;
        jpos = *prev(tmp);

        if(current[num] >= jpos) continue;
        current[num] = jpos;
      }
    }
    rep(j,0,64){
      if(current[j] == -1) continue;
      if(current[j] <= before[j]) continue;
      if(before[j]!=0)
        D[i] = (D[i] + sumD[current[j]-1] - sumD[before[j]-1]) % MOD;
      else
        D[i] = (D[i] + sumD[current[j]-1]) % MOD;
      
      before[j] = current[j];
      if(D[i]<0)D[i] += MOD;
    }
    occur[DNA[i]].pb(i);
    sumD[i] = (sumD[i-1]+D[i]) % MOD;
  }
  ll ans = (sumD[N]-1)%MOD;
  if(ans < 0) ans += MOD;
  pf1l(ans);
}
