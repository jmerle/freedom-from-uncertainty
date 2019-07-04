package com.jaspervanmerle.freedomfromuncertainty.strategy

import com.jaspervanmerle.freedomfromuncertainty.model.Record

class ProductionStrategy : Strategy() {
    override fun predictPrice(record: Record, previousRecords: List<Record>, nextRecords: List<Record>): Double {
        if (nextRecords.size < 3) {
            return record.tripleExponentialMovingAverage
        }

        return listOf(
            nextRecords[1].tripleExponentialMovingAverage * 123.15203358224193,
            nextRecords[2].doubleExponentialMovingAverage * 17.577344039041236,
            nextRecords[1].doubleExponentialMovingAverage * -15.984571190011554,
            nextRecords[2].tripleExponentialMovingAverage * -245.2698224864371,
            nextRecords[2].waysAndMeansAdvances * -479.5996636225168,
            nextRecords[0].tripleExponentialMovingAverage * 293.4570099420041,
            nextRecords[2].exponentialMovingAverage * 1088.864351708784,
            nextRecords[1].waysAndMeansAdvances * 63.49676268963094,
            nextRecords[0].doubleExponentialMovingAverage * -0.09261893252123932,
            nextRecords[1].exponentialMovingAverage * -377.4972663029023,
            nextRecords[2].simpleMovingAverage * 0.8758034381174127,
            nextRecords[2].triangularMovingAverage * 1.120192857895411,
            record.tripleExponentialMovingAverage * -188.0585459748954,
            nextRecords[0].waysAndMeansAdvances * -551.2183788834873,
            nextRecords[2].kaufmansAdaptiveMovingAverage * 0.040927027475758715,
            record.doubleExponentialMovingAverage * -0.2127148511493112,
            nextRecords[1].simpleMovingAverage * -86.78145526019165,
            nextRecords[0].exponentialMovingAverage * -127.33468631819233,
            nextRecords[1].triangularMovingAverage * -0.009188313869332498,
            nextRecords[2].t3MovingAverage * -247.13476548147565,
            nextRecords[1].kaufmansAdaptiveMovingAverage * 0.0719570453205782,
            record.waysAndMeansAdvances * 966.1428152539042,
            nextRecords[0].simpleMovingAverage * -74.56594435472323,
            record.exponentialMovingAverage * -228.78088552137,
            record.midPrice * -0.022457799331119355,
            nextRecords[0].triangularMovingAverage * -1.0085508524046587,
            nextRecords[1].t3MovingAverage * 604.6996896135918,
            nextRecords[0].kaufmansAdaptiveMovingAverage * -0.3322802329732611,
            record.midPoint * 0.029255074294027683,
            record.simpleMovingAverage * 1645.8227288930848,
            record.relativeStrengthIndexMiddleBand * 1645.8227288928101,
            record.triangularMovingAverage * -0.3426937362750998,
            nextRecords[0].t3MovingAverage * -492.59704789925377,
            record.kaufmansAdaptiveMovingAverage * 0.2665634645371159,
            record.t3MovingAverage * 133.84575830298203,
            record.relativeStrengthIndexLowerBand * -1733.7314382573677,
            record.relativeStrengthIndexHighBand * -1733.7282842666973,
            record.htTrendline * 0.025724122495752254,
            record.parabolicStopAndReverse * -0.009604881124865981
        ).sum()
    }
}
