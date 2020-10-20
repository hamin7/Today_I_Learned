library(AnomalyDetection)
library(hrbrthemes)
library(tidyverse)
data(raw_data)
raw_data$timestamp <- as.POSIXct(raw_data$timestamp)
res <- AnomalyDetectionTs(raw_data, max_anoms=0.02, direction='both', plot=FALSE)
res$anoms$timestamp <- as.POSIXct(res$anoms$timestamp)
ggplot(raw_data, aes(timestamp, count)) + 
  geom_line(data=raw_data, aes(timestamp, count), color='red') + 
  geom_point(data=res$anoms, aes(timestamp, anoms), color='green')

