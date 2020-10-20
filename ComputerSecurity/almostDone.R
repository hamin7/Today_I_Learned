library(RcppCNPy)
library(hrbrthemes)
library(AnomalyDetection)
library(zoo)
library(xts)
library(tidyverse)
library(scales)
abnormal = npyLoad("/Users/hamin/Documents/GitHub/Today_I_Learned/ComputerSecurity/abnormalEvents/abnormal.npy")

inds <- seq(as.Date("2002-01-01"), as.Date("2012-07-31"), by = "day") # 
set.seed(25)    ## Create a time series object
anom <- ts(abnormal, start = c(2002, as.numeric(format(inds[1], "%j"))), frequency = 365)

data1 = data.frame(timestamp=inds, count = coredata(datx))
data1$timestamp <- as.POSIXct(data1$timestamp)
res <- AnomalyDetectionTs(data1, max_anoms=0.02, direction='both', plot=FALSE)
res$anoms$timestamp <- as.POSIXct(res$anoms$timestamp)
ggplot(data1, aes(timestamp, count)) + 
  geom_line(data=data1, aes(timestamp, count), color='black') + 
  geom_point(data=res$anoms, aes(timestamp, anoms), color='red') +
  # scale_y_continuous(labels = comma)
  scale_y_continuous(labels = function(x) format(x, scientific = FALSE))
  
