#include <iostream>

char board[8][8];
int result = 0;

int main(void){
	for(int i = 0; i < 8; i++){
		for(int j = 0; j < 8; j++){
			scanf(" %c", &board[i][j]);
		}
		"\n";
	}
	for(int i = 0; i < 8; i++){
		for(int j = 0; j < 8; j++){
			if((i+j)%2==0 && board[i][j] == 'F'){ 
				result++; 
			}
		}
	}
	printf("%d\n", result);
	return 0;
}
