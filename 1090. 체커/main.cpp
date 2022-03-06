#include <stdio.h>
#include <stdlib.h>
#include <vector>
#include <set>
#include <algorithm>
 
using namespace std;
 
const int INF = 987654321;
int n;
vector<pair<int, int>> vp;
set<int> sx, sy;
 
int main() {
  scanf("%d", &n);
  for (int i = 0 ; i < n ; ++i) {
    int u, v;
    scanf("%d%d", &u, &v);
    vp.push_back({u, v});
    sx.insert(u);
    sy.insert(v);
  }
   
  vector<int> ans(n, INF);
  vector<int> xCoor(sx.begin(), sx.end());
  vector<int> yCoor(sy.begin(), sy.end());
  for (int x : xCoor) {
    for (int y : yCoor) {
      vector<int> dist;
      for(const auto& p : vp) {
        dist.push_back(abs(x - p.first) + abs(y - p.second));
      }
      sort(dist.begin(), dist.end());
       
      int sum = 0;
      for (int k = 0 ; k < (int)dist.size() ; ++k) {
        sum += dist[k];
        ans[k] = min(ans[k], sum);
      }
    }
  }
   
  for (int val : ans) {
    printf("%d ", val);
  }
}
