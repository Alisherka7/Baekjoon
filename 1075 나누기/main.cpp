#include <cstdio>

using namespace std;

 

int n, f;

int ans;

 

int main() {

    scanf("%d %d", &n, &f);

    n -= (n % 100);        //뒤 두 자리 0

 

    while (true) {

        if ((n + ans) % f == 0) break;

        ans++;

    }

 

    printf("%02d\n", ans);

 

    return 0;

}
