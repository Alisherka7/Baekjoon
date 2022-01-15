#include <cstdio>

#include <vector>

#include <queue>

#include <algorithm>

using namespace std;

int N, M;

vector<int> adj[111];

int C[111][111], f[111][111];

const int src = 0, sink = 110;

void add_edge(int from, int to, int cc) {

    adj[from].push_back(to);

    adj[to].push_back(from);

    C[from][to] = cc;

}

int max_flow() {

    int ret = 0;

    while (1) {

        queue<int> q;

        int par[111];

        fill(par + 1, par + 111, -1);


        q.push(src);

        while (!q.empty() && par[sink] == -1) {

            int here = q.front();

            q.pop();

            for (int next : adj[here]) {

                if (C[here][next] - f[here][next] > 0 && par[next] == -1) {

                    q.push(next);

                    par[next] = here;

                }

            }

        }

        if (par[sink] == -1) break;

        for (int i = sink;i != src;i = par[i])

            f[par[i]][i]++, f[i][par[i]]--;

        ret++;

    }

    return ret;

}

bool isPossible_erase(int from, int to) {

    f[from][to] = 0, f[to][from] = 1;

    f[src][from]--, f[from][src]++;

    f[to][sink]--, f[sink][to]++;

    int ret = 0;

    while (1) {

        queue<int> q;

        int par[111];

        fill(par + 1, par + 111, -1);


        q.push(src);

        while (!q.empty() && par[sink] == -1) {

            int here = q.front();

            q.pop();

            for (int next : adj[here]) {

                //이전의 값들은 영향 받지 않게 예외 처리

                if ((here == from && next == to) || (here == to && next == from)) continue;

                if (here > src && here < from && f[here][next] == 0) continue;

                if (here == from && next > N && next < to && f[here][next] == 0) continue;

                if (C[here][next] - f[here][next] > 0 && par[next] == -1) {

                    q.push(next);

                    par[next] = here;

                }

            }

        }

        if (par[sink] == -1) break;

        for (int i = sink;i != src;i = par[i])

            f[par[i]][i]++, f[i][par[i]]--;

        ret++;

    }

    return ret == 1;        //0으로 만들기 가능함

}

int main() {

    int sum_A = 0, sum_B = 0;

    scanf("%d%d", &N, &M);

    for (int n = 1;n <= N;n++) {

        int A;

        scanf("%d",&A);

        add_edge(src, n, A);

        sum_A += A;

    }

    for (int m = 1;m <= M;m++) {

        int B;

        scanf("%d", &B);

        add_edge(m + N, sink, B);

        sum_B += B;

    }

    if (sum_A != sum_B) {

        printf("-1\n");

        return 0;

    }

    for (int n = 1;n <= N;n++) {

        for (int m = 1;m <= M;m++) 

            add_edge(n, m + N, 1);

    }

    if (max_flow() != sum_A) {

        printf("-1\n");

        return 0;

    }

    else {

        for (int n = 1;n <= N;n++) {

            for (int m = 1;m <= M;m++) {

                if (f[n][m + N]) {        //1 -> 0으로 만드는게 가능한가?

                    if (!isPossible_erase(n, m + N)){        //불가능 원상복귀

                        f[n][m+N] = 1, f[m+N][n] = 0;

                        f[src][n]++, f[n][src]--;

                        f[m+N][sink]++, f[sink][m+N]--;

                    }

                }

            }

        }

        for (int n = 1;n <= N;n++) {

            for (int m = 1;m <= M;m++) 

                printf("%d", f[n][m + N]);

            printf("\n");

        }

    }

    return 0;

}
