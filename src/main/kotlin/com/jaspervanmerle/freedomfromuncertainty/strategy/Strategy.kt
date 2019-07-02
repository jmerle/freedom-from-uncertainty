package com.jaspervanmerle.freedomfromuncertainty.strategy

import com.jaspervanmerle.freedomfromuncertainty.model.Record

class Strategy(private val records: List<Record>) {
    fun execute() {
        val previousRecords = mutableListOf<Record>()

        for (record in records) {
            record.predictedPrice = predictPrice(record, previousRecords)
            previousRecords += record
        }
    }

    private fun predictPrice(record: Record, previousRecords: List<Record>): Double {
        return record.exponentialMovingAverage
    }
}
