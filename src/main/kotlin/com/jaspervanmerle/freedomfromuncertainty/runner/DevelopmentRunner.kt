package com.jaspervanmerle.freedomfromuncertainty.runner

import com.jaspervanmerle.freedomfromuncertainty.io.log
import com.jaspervanmerle.freedomfromuncertainty.model.Record
import com.jaspervanmerle.freedomfromuncertainty.model.Results
import com.jaspervanmerle.freedomfromuncertainty.strategy.FindCorrelationStrategy
import com.jaspervanmerle.freedomfromuncertainty.strategy.ProductionStrategy
import java.io.File
import java.text.DecimalFormat
import kotlin.math.absoluteValue
import kotlin.reflect.full.memberProperties

class DevelopmentRunner(private val inputFile: File) : Runner() {
    private val df = DecimalFormat("#.#").apply {
        maximumFractionDigits = 5
    }

    override fun run() {
        val records = parseRecords(inputFile)

        // findCorrelation(records)
        runProductionStrategy(records)
    }

    private fun findCorrelation(records: List<Record>) {
        val properties = Record::class
            .memberProperties
            .map { it.name }
            .minus(listOf("id", "date", "company", "actualPrice", "predictedPrice"))

        var bestResults: Results? = null
        var bestProperty: String? = null
        var bestIndex: Int? = null

        for (property in properties) {
            for (index in -50..50) {
                runStrategy(FindCorrelationStrategy(property, index), records, false)
                val results = getResults(records)

                if (bestResults == null || results.averageError < bestResults.averageError) {
                    bestResults = results
                    bestProperty = property
                    bestIndex = index
                }
            }
        }

        log("Property: $bestProperty, index: $bestIndex")
        logResults(bestResults!!)
    }

    private fun runProductionStrategy(records: List<Record>) {
        runStrategy(ProductionStrategy(), records, true)

        records.groupBy { it.company }.forEach { (company, companyRecords) ->
            logResults(company, getResults(companyRecords))
        }

        logResults("Overall", getResults(records))
    }

    private fun getResults(records: List<Record>): Results {
        val errors = records.map { (it.actualPrice!! - it.predictedPrice!!).absoluteValue }
        return Results(errors.min()!!, errors.max()!!, errors.average())
    }

    private fun logResults(label: String, results: Results) {
        log()
        log("$label results")
        log()

        logResults(results)
    }

    private fun logResults(results: Results) {
        log("Min error: ${df.format(results.minError)}")
        log("Max error: ${df.format(results.maxError)}")
        log("Average error: ${df.format(results.averageError)}")
    }
}
