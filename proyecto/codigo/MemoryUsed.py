import os
import psutil
from math import e
import matplotlib.pyplot as plt
import DecisionTree

arrM = []
for i in range(100):
  DecisionTree.lalala()
  process = psutil.Process(os.getpid())
  arrM.append((process.memory_info().rss)/(1e+6))

plt.plot(arrM, color='c')
plt.xlabel('Numero de prueba')
plt.ylabel('[MB]')
plt.title('Espacio de Memoria')

plt.show()