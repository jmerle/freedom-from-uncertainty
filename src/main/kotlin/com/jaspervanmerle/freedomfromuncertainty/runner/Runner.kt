package com.jaspervanmerle.freedomfromuncertainty.runner

import com.jaspervanmerle.freedomfromuncertainty.io.log
import com.jaspervanmerle.freedomfromuncertainty.model.Record
import com.jaspervanmerle.freedomfromuncertainty.strategy.Strategy
import java.io.File
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
            if (it.startsWith("ID") || it.contains("NaN")) {
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
                parts[6].toDouble(),
                parts[7].toDouble(),
                parts[8].toDouble(),
                parts[9].toDouble(),
                parts[10].toDouble(),
                parts[11].toDouble(),
                parts[12].toDouble(),
                parts[13].toDouble(),
                parts[14].toDouble(),
                parts[15].toDouble(),
                parts[16].toDouble(),
                parts[17].toDouble(),
                parts[18].toDouble(),
                parts[19].toDouble(),
                parts[20].toDouble(),
                parts[21].toDouble(),
                parts[22].toDouble(),
                parts[23].toDouble(),
                parts[24].toDouble(),
                parts[25].toDouble(),
                parts[26].toDouble(),
                parts[27].toDouble(),
                parts[28].toDouble(),
                parts[29].toDouble(),
                parts[30].toDouble(),
                parts[31].toDouble(),
                parts[32].toDouble(),
                parts[33].toDouble(),
                parts[34].toDouble(),
                parts[35].toDouble(),
                parts[36].toDouble(),
                parts[37].toDouble(),
                parts[38].toDouble(),
                parts[39].toDouble(),
                parts[40].toDouble(),
                parts[41].toDouble(),
                parts[42].toDouble(),
                parts[43].toDouble(),
                parts[44].toDouble(),
                parts[45].toDouble(),
                parts[46].toDouble(),
                parts[47].toDouble(),
                parts[48].toDouble(),
                parts[49].toDouble(),
                parts[50].toDouble(),
                parts[51].toDouble(),
                parts[52].toDouble(),
                parts[53].toDouble(),
                parts[54].toDouble(),
                parts[55].toDouble(),
                parts[56].toDouble(),
                parts[57].toDouble(),
                parts[58].toDouble(),
                parts[59].toDouble(),
                parts[60].toDouble(),
                parts[61].toDouble(),
                parts[62].toDouble(),
                parts[63].toDouble(),
                parts[64].toDouble(),
                parts[65].toDouble(),
                parts[66].toDouble(),
                parts[67].toDouble(),
                if (parts.size == 69) parts[68].toDouble() else null
            )
        }

        log("Parsed ${records.size} records")

        return records.sortedBy { it.date }
    }
}
