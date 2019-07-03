package com.jaspervanmerle.freedomfromuncertainty.runner

import com.jaspervanmerle.freedomfromuncertainty.io.log
import com.jaspervanmerle.freedomfromuncertainty.model.Record
import com.jaspervanmerle.freedomfromuncertainty.strategy.ProductionStrategy
import java.io.File
import java.text.DecimalFormat

class ProductionRunner(private val inputFile: File, private val outputFile: File) : Runner() {
    override fun run() {
        val records = parseRecords(inputFile)
        runStrategy(ProductionStrategy(), records, true)
        saveResults(records)
    }

    private fun saveResults(records: List<Record>) {
        if (!outputFile.exists()) {
            outputFile.parentFile.mkdirs()
            outputFile.createNewFile()
        }

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
