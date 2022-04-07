# -*- coding: utf-8 -*-

"""
名字：Mod(a,b,n),a,b表示列表，长度都为n
功能：返回a模b的列表
"""


def Mod(a, b, n):
      result = a[:]
      d = b[:]
      a_len = n
      b_len = n
      for i in range(n):
            if a[i] != 0:
                  break
            a_len -= 1
      for i in range(n):
            if b[i] != 0:
                  break
            b_len -= 1
      if a_len >= b_len:
            for i in range(b_len, a_len):
                  d.append(0)
            for i in range(a_len-1, b_len-2, -1):
                  if result[n-i-1] == 1:
                        result=addsub(result, d[i - b_len + 1:n + i - b_len + 1], n)
      return result


"""
名字：AddSub(a,b,n),a,b为列表，长度为n
功能：返回a减b或者a加b
说明：无论是加运算,还是减运算，在模2运算中算法相同
"""


def addsub(a, b, n):
    c=[]
    for i in range(n):
        c.append(a[i] ^ b[i])
    return c


"""
名字：Multiply(a,b,n),a,b为列表，长度为n
功能：返回a乘b的元素
"""


def multiply(a, b, n, mod):
     c = a[:]
     while n < len(mod):
           c.insert(0, 0)
           b.insert(0, 0)
           n += 1
     result = [0 for i in range(n)]
     for i in range(n-1, -1, -1):
        if b[i] == 1:
            result = addsub(result, c, n)
        c.append(0)          
        c.pop(0)
        c = list(Mod(c, mod, n))
     return result


"""
名字：Divide(a,b,n),a,b为列表，长度为n
功能：返回a整除b后的多项式
"""


def divide(a, b, n):
      c = a[:]
      d = b[:]
      result = [0 for i in range(n)]
      a_len = n
      b_len = n
      for i in range(n):
            if a[i] != 0:
                  break
            a_len -= 1
      for i in range(n):
            if b[i] != 0:
                  break
            b_len -= 1
      if a_len >= b_len:
            for i in range(b_len, a_len):
                  d.append(0)
            for i in range(a_len-1, b_len-2, -1):
                  if c[n-i-1] == 1:
                        result[n-i+b_len-2] = 1
                        c = addsub(c, d[i - b_len + 1:n + i - b_len + 1], n)
      return result
                  
                  
"""
名字：getRes(a,b,n,mod),a,b为列表，长度为n
功能：求多项式a关于b的逆元

原扩展欧几里得算法
def OGLD_pro(a,b):
    if (b==0):
        return {'d':a,'x':1,'y':0}
    else:
        t=OGLD_pro(b,a%b)
        temp=t['x']
        t['x']=t['y']
        t['y']=temp-int(a/b)*t['y']
        return t
"""


def getres(a, b, n, mod):
     if max(b) == 0:
       x = [0 for i in range(n-1)]
       x.append(1)
       return {'d': a[:], 'x': x, 'y': [0 for i in range(n)]}
     else:
          t = getres(b, Mod(a, b, n), n, mod)
          temp = list(t['x'])
          t['x'] = list(t['y'])
          t['y'] = addsub(temp, multiply(divide(a, b, n), t['y'], n, mod), n)
          
          return t


"""
名字：ExpOfMod(a,k,myMod,n):列表a,k为指数，myMod为要模的多项式，n为列表长度
功能：模的指数运算，重复平方算法

"""


def ExpOfMod(a,k,mod,n):
      result=[0 for i in range(n-1)]
      result.append(1)
      if k != 0:
            A = a[:]
            if k % 2 == 1:
                  result = a[:]
            k = k // 2
            while k != 0:
                  A = multiply(A, A, n, mod)
                  if k % 2 == 1:
                        result = multiply(A, result, n, mod)
                  k = k // 2
      return result


"""
名字：transList(lst),lst为列表
功能:用于把列表中二进制数转化为10进制
"""


def translist(lst):
      result=0
      for i in lst:
            result *= 2
            result += i
            
      return result


"""
名字：基准，即要模得多项式，用多项式基表示
功能：作为全局变量
注意：多项式一定不能拆分，即不可约多项式
"""


myMod = [1,0,1,1,0,0,0,1,1]
testMod =[1,0,0,1,1]


a = [0, 0, 0, 0, 0, 0, 1, 1, 1]
b = [0, 1, 0, 1, 0, 1, 1, 0, 1]
print("a=", a)
print("b=", b)
print("a+b=a-b=", addsub(a, b, len(a)))
print("b/a=", divide(b, a, len(a)))
print("a*b=", multiply(a, b, len(a), myMod))
t = getres(a, myMod, 9, myMod)
a_ = t['x']
print("a得逆元为：", a_)


base = [0, 0, 0, 0, 0, 0, 0, 1, 0]
ExpList = [0 for i in range(256)]
LogList = [0 for i in range(256)]
LogList[0] = 255
for i in range(255):
      index = translist(ExpOfMod(base, i, myMod, len(base)))
      ExpList[i] = index
      LogList[index] = i
print("\n\t\t\t\t\t指数对数表\n\n")
i = 0
while i < 256:
      while True:
            if i % 16 == 0:
                  print("{:8s}".format("序号"), end=' ')
            print("{:4d}".format(i), end=' ')
            if (i+1)%16 == 0:
                  print('\n')
                  i = i-15
                  break
            i += 1
      while True:
            if i % 16 == 0:
                  print("{:9s}".format("(02)^i"), end=' ')
            print("{:4d}".format(ExpList[i]), end=' ')
            if (i+1) % 16 == 0:
                  print('\n')
                  i = i-15
                  break
            i += 1
      while True:
            if i % 16 == 0:
                  print("{:7s}".format("log(02)^i"), end=' ')
            print("{:4d}".format(LogList[i]), end=' ')
            if (i+1) % 16 == 0:
                  print('\n\n')
                  i += 1
                  break
            i += 1
