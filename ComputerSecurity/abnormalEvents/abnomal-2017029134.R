library(RcppCNPy)
library(hrbrthemes)
library(AnomalyDetection)
library(zoo)
library(xts)
library(tidyverse)
library(scales)
abnormal = npyLoad("/Users/hamin/Documents/GitHub/Today_I_Learned/ComputerSecurity/abnormalEvents/abnormal.npy")

inds <- seq(as.Date("2002-01-01"), as.Date("2012-07-31"), by = "day") # array is 3865 -> 2002.01.01 ~ 2012.07.31
set.seed(25)    ## Create a time series object
anom <- ts(abnormal, start = c(2002, as.numeric(format(inds[1], "%j"))), frequency = 365) # Time-series [1:3865]

data1 = data.frame(timestamp=inds, count = coredata(datx))  # dataframe : timestamp*count
data1$timestamp <- as.POSIXct(data1$timestamp)  # convert to POSIXct (inorder to draw plot)
res <- AnomalyDetectionTs(data1, max_anoms=0.02, direction='both', plot=FALSE)  # AnomalyDetectionTs library
res$anoms$timestamp <- as.POSIXct(res$anoms$timestamp)  # convert to POSIXct (inorder to draw plot)
ggplot(data = data1, aes(x=timestamp, y=count)) + 
  geom_line(data=data1, aes(timestamp, count), color='black') + 
  geom_point(data=res$anoms, aes(timestamp, anoms), color='red') +
  scale_y_continuous(labels = function(x) format(x, scientific = FALSE)) +
  ggtitle("Anomalies (Alpha = 0.02, direction=both)") +
  xlab("Timestamp") + ylab("Abnormal Events Count") +
  theme(plot.title = element_text(hjust = 0.5))

