package com.jaspervanmerle.freedomfromuncertainty.strategy

import com.jaspervanmerle.freedomfromuncertainty.model.Record

abstract class Strategy {
    protected abstract fun predictPrice(
        record: Record,
        previousRecords: List<Record>,
        nextRecords: List<Record>
    ): Double

    fun execute(records: List<Record>) {
        val previousRecords = mutableListOf<Record>()
        val nextRecords = records.toMutableList()

        for (record in records) {
            nextRecords -= record
            record.predictedPrice = predictPrice(record, previousRecords, nextRecords)
            previousRecords.add(0, record)
        }
    }
}
