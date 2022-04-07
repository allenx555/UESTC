# -*- coding: utf-8 -*-
# @Time    : 2018/12/12 0012 13:53
# @Author  : allenx555
# @FileName: 2.py
# @Software: PyCharm

a = int(input("请输入a:"))
k1 = int(input("请输入k:"))
m = int(input("请输入m:"))
k = list(str(bin(k1)))
k.reverse()
t = len(k)

b = 1
A = a
if k[0] == "1":
    b = a
for i in range(1, t):
    A = (A * A) % m
    if k[i] == "1":
        b = (A * b) % m

print(b)

