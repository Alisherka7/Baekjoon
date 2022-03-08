#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;
 
class makeOne{
private:
    int n;  //n
    int arr[1000001];   //array
public:
    void setNum(){
        cin >> n;
        memset(arr, 0, sizeof(int) * (n+1));    //1부터 n까지 이므로 n+1.
    }
  
    void solution(){
        arr[1] = 0; 
        
        for(int i=2; i<=n; i++){
            arr[i] = arr[i-1] + 1;  //규칙 3번 : 1을 뺀다
            if(i%2 == 0){
                arr[i] = min(arr[i], arr[i/2]+1);   //규칙 2번 : 2로 떨어지는 경우
            }
            if(i%3 == 0){
                arr[i] = min(arr[i], arr[i/3]+1);   //규칙 1번 : 3로 떨어지는 경우
            }
        }
    }
    
    void printMin(){
        cout << arr[n];
    }
};
 
int main(void){
    makeOne one;
    one.setNum();
    one.solution();
    one.printMin();
    return 0;
}
