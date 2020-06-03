import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from pylab import figure, axes, pie, title, savefig
# %matplotlib inline

data = np.load("/Users/hamin/Documents/GitHub/Today_I_Learned/ComputerSecurity/abnormalEvents/abnormal.npy")  # 데이터 로드

data.size

plt.plot(data, 'ko', markersize=1) # 마커 사이즈 작게
plt.xlabel('year')   # x축은 연도
plt.ylabel('Event count')  # y축은 이벤트의 수

x = range(0,data.size)   # 연도를 계산하기 위해 데이터의 날짜수를 대입
x_ticks = [day for day in x if day%365 == 0]   # 365를 1년으로 계산
x_labels = [str(i+2002) for i in range(len(x_ticks))]  # x축 라벨 표시

plt.xticks(x_ticks, x_labels)
  
plt.yscale('log')   # y축 스케일을 조정
plt.savefig('/Users/hamin/Documents/GitHub/Today_I_Learned/ComputerSecurity/abnormalEvents/timeseries.png', dpi='300')
plt.show()