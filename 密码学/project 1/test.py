# -*- coding: utf-8 -*-
# @Time    : 2019/3/28 0028 22:28
# @Author  : allenx555
# @FileName: test.py
# @Software: PyCharm
import numpy

A = numpy.matrix([[11, 2, 19], [5, 23, 25], [20, 7, 17]])
print(A)
print("det(A):")
print(numpy.linalg.det(A))
