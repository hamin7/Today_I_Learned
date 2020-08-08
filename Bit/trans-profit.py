# 수익 - 거래량 비율
import numpy as np
import matplotlib.pyplot as plt

x = ['Feb','Mar','Apr','May','Jun','Jul']
y1 = [20057445,8951034,23967448,11999306,4513842,494149]
y2 = [1.25,3.01,2.39,3.85,2.97,2.59]
# y3 = data_set['data3']

fig, ax1 = plt.subplots()
ax2 = ax1.twinx()

# plot with properties

line1 = ax1.plot(np.arange(len(x)), y1, color='b', linestyle='--', marker='o', label='Profit')
line2 = ax2.plot(np.arange(len(x)), y2, color='g', linestyle='--', marker='^', label='Trans Percentage')
# line3 = ax2.plot(np.arange(len(x)), y3, color='r', linestyle='--', marker='s', label=title[3])

# plot without x sorting
ax1.set_xticklabels(['$Jan$','$Feb$','$Mar$','$Apr$','$May$','$Jun$','$Jul$'])
ax1.set_xlabel('Month')
ax1.set_ylabel('Profit(10,000,000KRW)')
ax2.set_ylabel('Transaction Percentage(%)')

# set y limit
ax1.set_ylim(0, 25000000)
ax2.set_ylim(0, 5.0)

# plot legend for all y axis
lines = line1 + line2
labels = [l.get_label() for l in lines]
plt.legend(lines, labels, loc=2)

plt.grid(True)

# fig.grid(False)

fig.tight_layout()
fig.savefig('trans-profit.png', dpi=1000)
fig.savefig('trans-profit.eps', format='eps', dpi=1000)
plt.show()
