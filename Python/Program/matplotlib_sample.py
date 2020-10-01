import numpy as np

import matplotlib.pyplot as plt 

x_upper = np.linspace(0,5)
x_lower = np.linspace(0,2*np.pi)
x_tan = np.linspace(-np.pi/2,np.pi/2)

position_upper = [i for i in range(5)]
position_lower = [0, np.pi/2, np.pi, np.pi*3/2,np.pi*2]
position_tan = [-np.pi/2,0,np.pi/2]

label_upper = [i for i in range(5)]
label_lower = ["0°","90°","180°","270°","360°"]
label_tan = ["-90°","0°","90°"]

fig = plt.figure(figsize=(9,6))

plt.subplots_adjust(wspace=0.4,hspace=0.4)

for i in range(3):
    y_upper = x_upper ** (i+1)
    ax = fig.add_subplot(2,3,i+1)
    ax.grid(True)
    ax.set_title("$y=x^%i$" % (i+1))
    ax.set_xlabel("x-axis")
    ax.set_ylabel("y-axis")

    ax.set_xticks(position_upper)
    ax.set_xticklabels(label_upper)
    ax.plot(x_upper,y_upper)

y_lower_list = [np.sin(x_lower),np.cos(x_lower)]

title_list =  ["$y=sin(x)$","$y=cos(x)$"]

for i in range(2):
    y_lower = y_lower_list[i]
    ax = fig.add_subplot(2,3,i+4)
    ax.grid(True)
    ax.set_title(title_list[i])
    ax.set_xlabel("x-axis")
    ax.set_ylabel("y-axis")

    ax.set_xticks(position_lower)
    ax.set_xticklabels(label_lower)
    ax.plot(x_lower,y_lower)

ax = fig.add_subplot(2,3,6)
ax.grid(True)
ax.set_title("$y=tan(x)$")
ax.set_xlabel("x-axis")
ax.set_ylabel("y-axis")
ax.set_xticks(position_tan)
ax.set_xticklabels(label_tan)
ax.set_ylim(-1,1)

ax.plot(x_tan,np.tan(x_tan))


plt.show()