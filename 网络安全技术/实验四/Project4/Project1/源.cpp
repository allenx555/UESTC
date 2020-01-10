#pragma comment(lib, "ws2_32.lib")
#include <winsock2.h>
#include <stdio.h>
int main()
{
	SOCKET mysock, tsock; // �����׽���
	struct sockaddr_in my_addr; // ���ص�ַ��Ϣ
	struct sockaddr_in their_addr; // �����ߵ�ַ��Ϣ
	int sin_size;
	WSADATA wsa;
	WSAStartup(MAKEWORD(2, 2), &wsa); //��ʼ�� Windows Socket
	//���� socket
	mysock = socket(AF_INET, SOCK_STREAM, 0);
	//bind �����Ķ˿�
	my_addr.sin_family = AF_INET; // Э�������� INET
	my_addr.sin_port = htons(1234); // �󶨶˿� 1234
	my_addr.sin_addr.s_addr = INADDR_ANY; // ���� IP
	bind(mysock, (struct sockaddr*) & my_addr, sizeof(struct sockaddr));
	//listen�������˿�
	listen(mysock, 10); // �ȴ�������Ŀ
	printf("listen......");
	//�ȴ��ͻ�������
	sin_size = sizeof(struct sockaddr_in);
	tsock = accept(mysock, (struct sockaddr*) & their_addr, &sin_size);
	//�����Ӿͷ��� Hello!�ַ�����ȥ
	send(tsock, "Hello!\n", sizeof("Hello!\n"), 0);
	printf("send ok!\n");
	//�ɹ����ر��׽���
	closesocket(mysock);
	closesocket(tsock);
	return 0;
}