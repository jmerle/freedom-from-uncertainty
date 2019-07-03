# Freedom from Uncertainty
My solution for the [Freedom from Uncertainty](https://www.hackerearth.com/challenges/competitive/freedom-from-uncertainty-hackerearth-machine-learning-challenge/) competition on HackerEarth.

## Approach
My solution is pretty simple. The predicted price of a record (a row in the dataset), I iterate over the following values of the record and pick the first that is not `NaN`:
1. TEMA
2. DEMA
3. EMA 

## Tools
I wrote my solution in Kotlin with Gradle as build system. Initially I also did a bit of trial-and-error in RapidMiner Studio, but that me took too long to get used to again so I switched over to Kotlin.

As far as development tooling is important, the source code was written in IntelliJ IDEA. I also used LibreOffice Calc to view the datasets.

## Relevant sources
The source code can be found in [src/main/kotlin/com/jaspervanmerle/freedomfromuncertainty](./src/main/kotlin/com/jaspervanmerle/freedomfromuncertainty). The price of a record is predicted in the [`Strategy`](./src/main/kotlin/com/jaspervanmerle/freedomfromuncertainty/strategy/Strategy.kt) class.
