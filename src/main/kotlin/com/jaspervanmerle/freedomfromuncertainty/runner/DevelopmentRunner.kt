package com.jaspervanmerle.freedomfromuncertainty.runner

import com.jaspervanmerle.freedomfromuncertainty.io.log
import com.jaspervanmerle.freedomfromuncertainty.model.Record
import java.io.File
import java.text.DecimalFormat
import kotlin.math.absoluteValue
import kotlin.math.max

class DevelopmentRunner(inputFile: File) : Runner(inputFile) {
    override fun processResults(records: List<Record>) {
        val meanAbsoluteError = records
            .map { (it.actualPrice!! - it.predictedPrice!!).absoluteValue }
            .average()

        val score = max(0.0, 100.0 - meanAbsoluteError)

        val df = DecimalFormat("#.#")
        df.maximumFractionDigits = 5

        log("Score: ${df.format(score)}")
    }
}
