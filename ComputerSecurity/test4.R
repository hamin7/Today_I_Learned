library(RcppCNPy)
library(AnomalyDetection)
library(zoo)
library(xts)
abnormal = npyLoad("/Users/hamin/Documents/GitHub/Today_I_Learned/ComputerSecurity/abnormalEvents/abnormal.npy")


# anom<- ts(abnormal, frequency=1, start=c(2002, 1))
inds <- seq(as.Date("2002-01-01"), as.Date("2012-07-31"), by = "day")
set.seed(25)    ## Create a time series object
anom <- ts(abnormal, start = c(2002, as.numeric(format(inds[1], "%j"))), frequency = 365)


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

