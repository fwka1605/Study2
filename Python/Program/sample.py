import numpy as np

import matplotlib.pyplot as plt 

from matplotlib import cm

from mpl_toolkits.mplot3d import Axes3D

t = np.linspace(-2*np.pi,2*np.pi)

X,Y = np.meshgrid(t,t)

R = np.sqrt(X**2+Y**2)

Z = np.sin(R)

fig = plt.figure(figsize=(6,6))

ax = fig.add_subplot(1,1,1,projection="3d")

ax.plot_surface(X,Y,Z,cmap=cm.coolwarm)
plt.show()


