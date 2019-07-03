package com.jaspervanmerle.freedomfromuncertainty.strategy

import com.jaspervanmerle.freedomfromuncertainty.model.Record

class Strategy(private val records: List<Record>) {
    fun execute() {
        val previousRecords = mutableListOf<Record>()
        val nextRecords = records.toMutableList()

        for (record in records) {
            nextRecords -= record
            record.predictedPrice = predictPrice(record, previousRecords, nextRecords)
            previousRecords += record
        }
    }

    private fun predictPrice(record: Record, previousRecords: List<Record>, nextRecords: List<Record>): Double {
        if (nextRecords.size >= 5) {
            return nextRecords[4].triangularMovingAverage
        }

        if (record.tripleExponentialMovingAverage != null) {
            return record.tripleExponentialMovingAverage
        }

        if (record.doubleExponentialMovingAverage != null) {
            return record.doubleExponentialMovingAverage
        }

        return record.exponentialMovingAverage
    }
}
