package com.jaspervanmerle.freedomfromuncertainty.runner

import com.jaspervanmerle.freedomfromuncertainty.io.log
import com.jaspervanmerle.freedomfromuncertainty.model.Record
import java.io.File
import java.text.DecimalFormat
import kotlin.math.absoluteValue
import kotlin.math.max

class DevelopmentRunner(inputFile: File) : Runner(inputFile) {
    override fun processResults(records: List<Record>) {
        records.groupBy { it.company }.forEach { (company, companyRecords) ->
            logResults(company, companyRecords)
        }

        logResults("Overall", records)
    }

    private fun logResults(label: String, records: List<Record>) {
        val errors = records.map { (it.actualPrice!! - it.predictedPrice!!).absoluteValue }

        val minError = errors.min()
        val maxError = errors.max()
        val averageError = errors.average()
        val score = max(0.0, 100.0 - averageError)

        val df = DecimalFormat("#.#")
        df.maximumFractionDigits = 5

        log()
        log("$label results")
        log()

        log("Score: ${df.format(score)}")
        log("Min error: ${df.format(minError)}")
        log("Max error: ${df.format(maxError)}")
        log("Average error: ${df.format(averageError)}")
    }
}
