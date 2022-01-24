#include <cstdio>
#include <climits>
using namespace std;

int get_min(int a, int b) { return a < b ? a : b; }
int main() {

    int n, m, i, package = INT_MAX, single = INT_MAX, pquant, temp, temp1, temp2, mix, allp, alls, price = __INT_MAX__;
    bool flag;
    scanf("%d %d", &n, &m);

    for (i = 0; i < m; i++) {
        flag = false;
        scanf("%d %d", &temp1, &temp2);
        package = get_min(package, temp1);
        single = get_min(single, temp2);
    }

    if (n % 6 == 0) flag = true;
    pquant = n/6;
    mix = (pquant * package) + (n - pquant * 6) * single;
    if (flag) allp = pquant * package;
    else allp = (pquant + 1) * package;
    alls = single * n;
    
    temp = get_min(mix, allp);
    temp = get_min(temp, alls);
    price = get_min(price, temp);

    printf("%d\n", price);

    return 0;
}
