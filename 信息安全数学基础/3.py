# -*- coding: utf-8 -*-
# @Time    : 2018/12/12 0012 15:23
# @Author  : allenx555
# @FileName: 3.py
# @Software: PyCharm


def gcd(m, n):
    if not n:
        return m
    else:
        return gcd(n, m % n)


def get(a, b):
    if b == 0:
        return 1, 0
    else:
        k = a // b
        remainder = a % b
        x1, y1 = get(b, remainder)
        x, y = y1, x1 - k * y1
    return x, y


print("请输入rs≡1 mod m的参数\n")
a = int(input("请输入r："))
b = int(input("请输入m："))

flag = gcd(a, b)

if flag == 1:
    x, y = get(a, b)
    result = x % abs(b)
    print(result)
