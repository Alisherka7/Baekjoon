#include<cstdio>
#include<algorithm>
#include<string.h>
using namespace std;
int n,m,d[60],i,j,l;
struct E{
    int s[60];
    bool operator <(const E &a)const{
        for(int i=59;i>=0;i--){
            if(s[i]>a.s[i])return true;
            if(s[i]<a.s[i])return false;
        }
        return false;
    }
}e[36];
char s[51],t;
int main(){
    scanf("%d",&n);
    for(i=0;i<n;i++){
        scanf("%s",s);
        l=strlen(s);
        for(j=0;j<l;j++){
            t=s[l-j-1];
            if(t<'A'){
                d[j]+=t-'0';
                e[t-'0'].s[j]+=('9'-t+26);
            }else{
                d[j]+=t-'A'+10;
                e[t-'A'+10].s[j]+=('Z'-t);
            }
        }
    }
    scanf("%d",&m);
    for(i=0;i<59;i++){
        d[i+1]+=d[i]/36;
        d[i]%=36;
        for(j=0;j<36;j++){
            e[j].s[i+1]+=e[j].s[i]/36;
            e[j].s[i]%=36;
        }
    }
    sort(e,e+36);
    for(l=i=0;i<59;i++){
        for(j=0;j<m;j++)d[i]+=e[j].s[i];
        d[i+1]+=d[i]/36;
        d[i]%=36;
        if(d[i])l=i;
    }
    for(;l>=0;l--)printf("%c",d[l]>9?d[l]-10+'A':'0'+d[l]);
}
