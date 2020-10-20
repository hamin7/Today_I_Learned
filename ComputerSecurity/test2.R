library(RcppCNPy)
library(AnomalyDetection)
library(zoo)
library(xts)
abnormal = npyLoad("/Users/hamin/Documents/GitHub/Today_I_Learned/ComputerSecurity/abnormalEvents/abnormal.npy")

# data(abnormal)
anom<- ts(abnormal, frequency=1, start=c(2006, 1))


datx = as.xts(anom, dataFormat="POSIXct")
data1 = data.frame(date=index(datx), coredata(datx))
# data(data1)
# data1$timestamp <- as.POSIXct(data1$timestamp)
res <- AnomalyDetectionTs(data1, max_anoms=0.02, direction='both', plot=FALSE)
res$anoms$timestamp <- as.POSIXct(res$anoms$timestamp)
ggplot(data1, aes(timestamp, count)) + 
  geom_line(data=data1, aes(timestamp, count), color='blue') + 
  geom_point(data=res$anoms, aes(timestamp, anoms), color='red')
