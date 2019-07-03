package com.jaspervanmerle.freedomfromuncertainty.strategy

import com.jaspervanmerle.freedomfromuncertainty.model.Record
import kotlin.math.absoluteValue
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

class FindCorrelationStrategy(private val property: String, private val index: Int) : Strategy() {
    @Suppress("UNCHECKED_CAST")
    override fun predictPrice(record: Record, previousRecords: List<Record>, nextRecords: List<Record>): Double {
        val list = when {
            index < 0 -> previousRecords
            index > 0 -> nextRecords
            else -> emptyList()
        }

        val targetRecord = when {
            index == 0 -> record
            list.size >= index.absoluteValue -> list[index.absoluteValue - 1]
            else -> null
        }

        if (targetRecord != null) {
            val member = targetRecord::class.memberProperties.first { it.name == property } as KProperty1<Record, *>
            val value = member.get(targetRecord) as Double?

            if (value != null) {
                return value
            }
        }

        return predictPriceFallback(record)
    }

    private fun predictPriceFallback(record: Record): Double {
        if (record.tripleExponentialMovingAverage != null) {
            return record.tripleExponentialMovingAverage
        }

        if (record.doubleExponentialMovingAverage != null) {
            return record.doubleExponentialMovingAverage
        }

        return record.exponentialMovingAverage
    }
}
