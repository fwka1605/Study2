import numpy as np
import time
from numpy.random import rand 

N=150

matA = np.array(rand(N,N))
#print(mathA)

matB = np.array(rand(N,N))
#print(mathB)

matC = np.array([[0]*N for _ in range(N)])
#print(mathC)

start = time.time()

for i in range(N):
    for j in range(N):
        for k in range(N):
            matC[i][j] = matA[i][k]*matB[k][j]

print("Pythonの機能のみでの計算結果：%.2f[sec]"%float(time.time()-start))            

start = time.time()

matC = np.dot(matA,matB)

print("Numpyでの計算結果：%.2f[sec]"%float(time.time()-start))            
