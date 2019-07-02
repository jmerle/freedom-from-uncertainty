# Freedom from Uncertainty
My solution for the [Freedom from Uncertainty](https://www.hackerearth.com/challenges/competitive/freedom-from-uncertainty-hackerearth-machine-learning-challenge/) competition on HackerEarth.

## Approach
My solution is pretty simple, it simply sets the predicted price of a record to it's exponential moving average.

## Tools
I wrote my solution in Kotlin with Gradle as build system. Initially I also did a bit of trial-and-error in RapidMiner Studio, but that me took too long to get used to again so I switched over to Kotlin.

As far as development tooling is important, the source code was written in IntelliJ IDEA. I used LibreOffice Calc to scan over the provided datasets initially and to find out which columns may contain `NaN` values.

## Relevant sources
The source code can be found in [src/main/kotlin/com/jaspervanmerle/freedomfromuncertainty](./src/main/kotlin/com/jaspervanmerle/freedomfromuncertainty).
