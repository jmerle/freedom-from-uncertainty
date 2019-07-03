package com.jaspervanmerle.freedomfromuncertainty.runner

import com.jaspervanmerle.freedomfromuncertainty.io.log
import com.jaspervanmerle.freedomfromuncertainty.model.Record
import com.jaspervanmerle.freedomfromuncertainty.strategy.Strategy
import java.io.File
import java.text.SimpleDateFormat

abstract class Runner(private val inputFile: File) {
    protected abstract fun processResults(records: List<Record>)

    fun run() {
        val records = parseRecords(inputFile)

        records.groupBy { it.company }.values.forEach {
            log("Predicting prices for company ${it[0].company} (${it.size} records)")
            Strategy(it).execute()
        }

        processResults(records)
    }

    private fun parseRecords(inputFile: File): List<Record> {
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
                parts[6].toDoubleOrNull(),
                parts[7].toDoubleOrNull(),
                parts[8].toDouble(),
                parts[9].toDoubleOrNull(),
                parts[10].toDoubleOrNull(),
                parts[11].toDoubleOrNull(),
                parts[12].toDoubleOrNull(),
                parts[13].toDoubleOrNull(),
                parts[14].toDouble(),
                parts[15].toDouble(),
                parts[16].toDouble(),
                parts[17].toDouble(),
                parts[18].toDoubleOrNull(),
                parts[19].toDoubleOrNull(),
                parts[20].toDouble(),
                parts[21].toDoubleOrNull(),
                parts[22].toDoubleOrNull(),
                parts[23].toDoubleOrNull(),
                parts[24].toDoubleOrNull(),
                parts[25].toDoubleOrNull(),
                parts[26].toDouble(),
                parts[27].toDouble(),
                parts[28].toDoubleOrNull(),
                parts[29].toDoubleOrNull(),
                parts[30].toDoubleOrNull(),
                parts[31].toDoubleOrNull(),
                parts[32].toDoubleOrNull(),
                parts[33].toDoubleOrNull(),
                parts[34].toDoubleOrNull(),
                parts[35].toDoubleOrNull(),
                parts[36].toDoubleOrNull(),
                parts[37].toDoubleOrNull(),
                parts[38].toDoubleOrNull(),
                parts[39].toDouble(),
                parts[40].toDouble(),
                parts[41].toDouble(),
                parts[42].toDouble(),
                parts[43].toDouble(),
                parts[44].toDouble(),
                parts[45].toDouble(),
                parts[46].toDouble(),
                parts[47].toDouble(),
                parts[48].toDoubleOrNull(),
                parts[49].toDoubleOrNull(),
                parts[50].toDouble(),
                parts[51].toDouble(),
                parts[52].toDouble(),
                parts[53].toDoubleOrNull(),
                parts[54].toDoubleOrNull(),
                parts[55].toDoubleOrNull(),
                parts[56].toDoubleOrNull(),
                parts[57].toDoubleOrNull(),
                parts[58].toDoubleOrNull(),
                parts[59].toDoubleOrNull(),
                parts[60].toDoubleOrNull(),
                parts[61].toDoubleOrNull(),
                parts[62].toDoubleOrNull(),
                parts[63].toDoubleOrNull(),
                parts[64].toDoubleOrNull(),
                parts[65].toDoubleOrNull(),
                parts[66].toDoubleOrNull(),
                parts[67].toDoubleOrNull(),
                if (parts.size == 69) parts[68].toDoubleOrNull() else null
            )
        }

        log("Parsed ${records.size} records")

        return records.sortedBy { it.date }
    }
}
