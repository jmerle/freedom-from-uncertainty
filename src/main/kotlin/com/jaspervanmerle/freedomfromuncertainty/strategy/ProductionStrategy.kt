package com.jaspervanmerle.freedomfromuncertainty.strategy

import com.jaspervanmerle.freedomfromuncertainty.model.Record

class ProductionStrategy : Strategy() {
    override fun predictPrice(record: Record, previousRecords: List<Record>, nextRecords: List<Record>): Double {
        if (nextRecords.size >= 2) {
            val value = nextRecords[1].tripleExponentialMovingAverage
            if (value != null) {
                return value
            }
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
