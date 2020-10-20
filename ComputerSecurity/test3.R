library(RcppCNPy)
library(AnomalyDetection)
library(zoo)
library(xts)
abnormal = npyLoad("/Users/hamin/Documents/GitHub/Today_I_Learned/ComputerSecurity/abnormalEvents/abnormal.npy")

# data(abnormal)
anom<- ts(abnormal, frequency=1, start=c(2006, 1))


datx = as.xts(anom)
df = data.frame(date=index(datx), coredata(datx))
#res = AnomalyDetectionTs(df)
#res$plot
#res$plot

#data(df)
# AnomalyDetectionTs(df, max_anoms = 0.02, direction = 'both', plot=TRUE)
res = AnomalyDetectionTs(df, max_anoms = 0.02, direction = 'both', only_last = 'day', plot = TRUE)

# res = AnomalyDetectionTs(abnormal, max_anoms=0.02, direction='both', plot=TRUE)
res$plot

