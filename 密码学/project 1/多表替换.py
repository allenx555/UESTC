# -*- coding: utf-8 -*-
# @Time    : 2019/3/28 0028 15:33
# @Author  : allenx555
# @FileName: RSA.py
# @Software: PyCharm
from numpy.linalg import *
import numpy as np


def gcd(a, b):
    if a % b == 0:
        return b
    else:
        return gcd(b, a % b)


def extendedGCD(a, b):
    if b == 0:
        return 1, 0, a
    (x, y, r) = extendedGCD(b, a % b)
    tmp = x
    x = y
    y = tmp - (a/b) * y
    return x, y, r


def create_a(n, N):
    A = np.matrix(np.random.randint(0, 1, (n, n)))
    while gcd(det(A), N) != 1 or det(A) == 0:
        A = np.matrix(np.random.randint(0, N, (n, n)))
    A = np.matrix([[11, 2, 19], [5, 23, 25], [20, 7, 17]])
    print("加密过程：\nA:")
    print(A)
    det_i, a, b = extendedGCD(det(A), 26)
    det_i = 11
    A_i = np.matrix([[10, 23, 7], [15, 9, 22], [5, 9, 21]])
    print("A逆:")
    print(A_i)
    B = np.matrix(np.random.randint(0, 1, (n, 1)))
    print("B:")
    print(B)
    return A, B, A_i


def dic(n, str):
    list = [ord(str[i])-65 for i in range(0, len(str))]
    list2 = [[list[i:i+n]] for i in range(0, len(str), n)]
    list3 = [np.transpose(np.matrix(i)) for i in list2]
    print("M:")
    print(list3)
    return list3


def translate(C):
    PlainText = []
    for c in C:
        for i in c:
            PlainText.append(chr(int(str(i + 65).replace("[[", "").replace("]]", ""))))
    PlainText = "".join(PlainText)
    print("密文为：" + PlainText)


def decipher(A_i, list):
    M = []
    for C in list:
        M.append((A_i * C) % 26)
    print("\n解密过程\nM:")
    print(M)
    text = [t.T for t in M]
    text1 = []
    text2 = []
    text3 = []
    for t in text:
        text1.append(t.tolist())
    for t in text1:
        text2.append(str(t).replace("[", "").replace("]", "").replace(",", ""))
    for t in text2:
        text3.append([int(s) for s in t.split() if s.isdigit()])
    print("明文为：")
    for t in text3:
        print(chr(t[0] + 65), end='')
        print(chr(t[1] + 65), end='')
        print(chr(t[2] + 65), end='')


N = 26
A, B, A_i = create_a(3, 25)
list = dic(3, 'YOURPINNOISFOURONETWOSIX')
C = [(A * M + B) % N for M in list]
print("C:")
print(C)
translate(C)
decipher(A_i, C)
