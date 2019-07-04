# Freedom from Uncertainty
My solution for the [Freedom from Uncertainty](https://www.hackerearth.com/challenges/competitive/freedom-from-uncertainty-hackerearth-machine-learning-challenge/) competition on HackerEarth.

## Approach
To predict the price of a record (a row in the dataset), I used Python to find correlations between all variables and the target (the price). I used a simple regression model to generate the coefficients of all correlating variables. Besides the existing variables, I also added additional variables for the future values of a few columns to see if there is a correlation between the price and a future value (like the SMA of the same company 2 days later). When there are not enough future records (when predicting the stock price of the final days of a company), my strategy falls back on the TEMA of the record.

## Tools
I wrote my solution in Kotlin with Gradle as build system. I also used Python to find correlations between variables and to generate Kotlin code based on the correlations that were found. Initially I also did a bit of trial-and-error in RapidMiner Studio, but that me took too long to get used to again so I switched over to Kotlin and Python.

As far as development tooling is important, the Kotlin code was written in IntelliJ IDEA and the Python code was written in a Jupyter Notebook. I also used LibreOffice Calc to view the datasets.

## Relevant source code
The Kotlin source code can be found in [src/main/kotlin/com/jaspervanmerle/freedomfromuncertainty](./src/main/kotlin/com/jaspervanmerle/freedomfromuncertainty). The price of a record is predicted in the [`ProductionStrategy`](./src/main/kotlin/com/jaspervanmerle/freedomfromuncertainty/strategy/ProductionStrategy.kt) class. The correlation between variables was find using Python in the Jupyter Notebook located at [Freedom_from_Uncertainty.ipynb](./Freedom_from_Uncertainty.ipynb).

The solution can be ran using `./gradlew runProduction` when Java 8 is installed. The program will read the test dataset from [data/test.csv](./data/test.csv) and write the results to [submission/result.csv](./submission/result.csv).
