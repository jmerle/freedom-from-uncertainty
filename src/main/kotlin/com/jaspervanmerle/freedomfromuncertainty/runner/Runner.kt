package com.jaspervanmerle.freedomfromuncertainty.runner

import com.jaspervanmerle.freedomfromuncertainty.io.log
import com.jaspervanmerle.freedomfromuncertainty.model.Record
import com.jaspervanmerle.freedomfromuncertainty.strategy.Strategy
import java.io.File
import java.lang.Double.isNaN
import java.text.SimpleDateFormat

abstract class Runner {
    abstract fun run()

    protected fun runStrategy(strategy: Strategy, records: List<Record>, enableLogging: Boolean) {
        records.groupBy { it.company }.forEach { (company, companyRecords) ->
            if (enableLogging) {
                log("Predicting prices for $company (${companyRecords.size} records)")
            }

            strategy.execute(companyRecords)
        }
    }

    protected fun parseRecords(inputFile: File): List<Record> {
        val records = mutableListOf<Record>()

        inputFile.forEachLine {
            if (it.startsWith("ID")) {
                return@forEachLine
            }

            val parts = it.split(",")
            val dateFormat = SimpleDateFormat("dd-MM-yyyy")

            records += Record(
                parts[0].toInt(),
                dateFormat.parse(parts[1]),
                parts[2].trim(),
                parts[3].toDouble(),
                parts[4].toDouble(),
                parts[5].toDouble(),
                parts[6].toDoubleOrNullIfNaN(),
                parts[7].toDoubleOrNullIfNaN(),
                parts[8].toDouble(),
                parts[9].toDoubleOrNullIfNaN(),
                parts[10].toDoubleOrNullIfNaN(),
                parts[11].toDoubleOrNullIfNaN(),
                parts[12].toDoubleOrNullIfNaN(),
                parts[13].toDoubleOrNullIfNaN(),
                parts[14].toDouble(),
                parts[15].toDouble(),
                parts[16].toDouble(),
                parts[17].toDouble(),
                parts[18].toDoubleOrNullIfNaN(),
                parts[19].toDoubleOrNullIfNaN(),
                parts[20].toDouble(),
                parts[21].toDoubleOrNullIfNaN(),
                parts[22].toDoubleOrNullIfNaN(),
                parts[23].toDoubleOrNullIfNaN(),
                parts[24].toDoubleOrNullIfNaN(),
                parts[25].toDoubleOrNullIfNaN(),
                parts[26].toDouble(),
                parts[27].toDouble(),
                parts[28].toDoubleOrNullIfNaN(),
                parts[29].toDoubleOrNullIfNaN(),
                parts[30].toDoubleOrNullIfNaN(),
                parts[31].toDoubleOrNullIfNaN(),
                parts[32].toDoubleOrNullIfNaN(),
                parts[33].toDoubleOrNullIfNaN(),
                parts[34].toDoubleOrNullIfNaN(),
                parts[35].toDoubleOrNullIfNaN(),
                parts[36].toDoubleOrNullIfNaN(),
                parts[37].toDoubleOrNullIfNaN(),
                parts[38].toDoubleOrNullIfNaN(),
                parts[39].toDouble(),
                parts[40].toDouble(),
                parts[41].toDouble(),
                parts[42].toDouble(),
                parts[43].toDouble(),
                parts[44].toDouble(),
                parts[45].toDouble(),
                parts[46].toDouble(),
                parts[47].toDouble(),
                parts[48].toDoubleOrNullIfNaN(),
                parts[49].toDoubleOrNullIfNaN(),
                parts[50].toDouble(),
                parts[51].toDouble(),
                parts[52].toDouble(),
                parts[53].toDoubleOrNullIfNaN(),
                parts[54].toDoubleOrNullIfNaN(),
                parts[55].toDoubleOrNullIfNaN(),
                parts[56].toDoubleOrNullIfNaN(),
                parts[57].toDoubleOrNullIfNaN(),
                parts[58].toDoubleOrNullIfNaN(),
                parts[59].toDoubleOrNullIfNaN(),
                parts[60].toDoubleOrNullIfNaN(),
                parts[61].toDoubleOrNullIfNaN(),
                parts[62].toDoubleOrNullIfNaN(),
                parts[63].toDoubleOrNullIfNaN(),
                parts[64].toDoubleOrNullIfNaN(),
                parts[65].toDoubleOrNullIfNaN(),
                parts[66].toDoubleOrNullIfNaN(),
                parts[67].toDoubleOrNullIfNaN(),
                if (parts.size == 69) parts[68].toDoubleOrNullIfNaN() else null
            )
        }

        log("Parsed ${records.size} records")

        return records.sortedBy { it.date }
    }

    private fun String.toDoubleOrNullIfNaN(): Double? {
        val original = this.toDoubleOrNull()

        if (original != null && isNaN(original)) {
            return null
        }

        return original
    }
}
