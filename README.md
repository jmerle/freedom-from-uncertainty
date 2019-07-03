# Freedom from Uncertainty
My solution for the [Freedom from Uncertainty](https://www.hackerearth.com/challenges/competitive/freedom-from-uncertainty-hackerearth-machine-learning-challenge/) competition on HackerEarth.

## Approach
My solution is pretty simple. The predicted price of a record (a row in the dataset), I iterate over the following values record and pick the first that is available (not non-existent and not `NaN`):
1. The TRIMA of the 5th record after the current one
2. The TEMA of the current record
3. The DEMA of the current record
4. The EMA of the current record

## Tools
I wrote my solution in Kotlin with Gradle as build system. Initially I also did a bit of trial-and-error in RapidMiner Studio, but that me took too long to get used to again so I switched over to Kotlin.

As far as development tooling is important, the source code was written in IntelliJ IDEA. I also used LibreOffice Calc to view the datasets.

## Relevant sources
The source code can be found in [src/main/kotlin/com/jaspervanmerle/freedomfromuncertainty](./src/main/kotlin/com/jaspervanmerle/freedomfromuncertainty). The price of a record is predicted in the [`Strategy`](./src/main/kotlin/com/jaspervanmerle/freedomfromuncertainty/strategy/Strategy.kt) class.

The solution can be ran by running `./gradlew runProduction` when Java 8 is installed. The program will read the test dataset from [src/main/resources/test.csv](./src/main/resources/test.csv) and write the results to [submission/result.csv](./submission/result.csv).
