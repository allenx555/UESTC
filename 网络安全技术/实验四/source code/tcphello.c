#pragma comment(lib, "ws2_32.lib")
#include <winsock2.h>
#include <stdio.h>
int main()
{
	SOCKET mysock,tsock; 
	struct sockaddr_in my_addr; 
	struct sockaddr_in their_addr; 
	int sin_size;
	WSADATA wsa;
	WSAStartup(MAKEWORD(2,2),&wsa); 
	mysock = socket(AF_INET, SOCK_STREAM, 0);
	my_addr.sin_family = AF_INET;
	my_addr.sin_port = htons(1234);
	my_addr.sin_addr.s_addr = INADDR_ANY;
	bind(mysock, (struct sockaddr *)&my_addr, sizeof(struct sockaddr));
	listen(mysock, 10); 
	printf("listen......");
	sin_size = sizeof(struct sockaddr_in);
	tsock = accept(mysock, (struct sockaddr *)&their_addr, &sin_size);
	send(tsock, "Hello!\n", sizeof("Hello!\n"), 0);
	printf("send ok!\n");
	closesocket(mysock);
	closesocket(tsock);
	return 0;
}