import matplotlib.pyplot as plt
import numpy as np

data = np.load("/Users/hamin/Documents/GitHub/Today_I_Learned/ComputerSecurity/abnormalEvents/abnormal.npy")  # 데이터 로드
plt.plot(data)
