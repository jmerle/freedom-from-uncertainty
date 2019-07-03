package com.jaspervanmerle.freedomfromuncertainty.runner

import com.jaspervanmerle.freedomfromuncertainty.io.log
import com.jaspervanmerle.freedomfromuncertainty.model.Record
import java.io.File
import java.text.DecimalFormat

class ProductionRunner(inputFile: File, private val outputFile: File) : Runner(inputFile) {
    override fun processResults(records: List<Record>) {
        outputFile.printWriter().use { out ->
            out.println("ID,Price")

            val df = DecimalFormat("#.#")
            df.maximumFractionDigits = 2

            records.sortedBy { it.id }.forEach {
                out.println("${it.id},${df.format(it.predictedPrice)}")
            }
        }

        log("Wrote results to ${outputFile.absolutePath}")
    }
}
