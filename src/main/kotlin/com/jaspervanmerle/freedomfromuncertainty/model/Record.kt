package com.jaspervanmerle.freedomfromuncertainty.model

import java.util.*

data class Record(
    val id: Int,
    val date: Date,
    val company: String,
    val simpleMovingAverage: Double,
    val exponentialMovingAverage: Double,
    val waysAndMeansAdvances: Double,
    val doubleExponentialMovingAverage: Double,
    val tripleExponentialMovingAverage: Double,
    val triangularMovingAverage: Double,
    val kaufmansAdaptiveMovingAverage: Double,
    val fAdaptiveMovingAverage: Double,
    val mesaAdaptiveMovingAverage: Double,
    val t3MovingAverage: Double,
    val movingAverageConvergenceDivergence: Double,
    val movingAverageConvergenceDivergenceHistogram: Double,
    val movingAverageConvergenceDivergenceSignal: Double,
    val movingAverageConvergence: Double,
    val movingAverageConvergenceHistogram: Double,
    val movingAverageConvergenceSignal: Double,
    val slowStochasticOscillatorSecondLine: Double,
    val slowStochasticOscillatorMainLine: Double,
    val fastStochasticOscillatorSecondLine: Double,
    val fastStochasticOscillatorMainLine: Double,
    val relativeStrengthIndex: Double,
    val fastStochasticSecondLine: Double,
    val fastStochasticMainLine: Double,
    val willr: Double,
    val averageDirectionalIndex: Double,
    val averageDirectionalIndexRating: Double,
    val absolutePriceOscillator: Double,
    val percentagePriceOscillator: Double,
    val momentumIndicator: Double,
    val balanceOfPower: Double,
    val commodityChannelIndex: Double,
    val chandeMomentumOscillator: Double,
    val rateOfChange: Double,
    val rateOfChangeRating: Double,
    val aroonOscillatorDown: Double,
    val aroonOscillatorUp: Double,
    val aroonOscillator: Double,
    val moneyFlowIndex: Double,
    val tripleSmoothedExponentialMovingAverage: Double,
    val ultimateOscillatorDefinitionAndStrategies: Double,
    val directionalMovementIndex: Double,
    val minusDirectionalIndex: Double,
    val plusDirectionalIndex: Double,
    val minusDirectionalMovementIndex: Double,
    val plusDirectionalMovementIndex: Double,
    val relativeStrengthIndexLowerBand: Double,
    val relativeStrengthIndexMiddleBand: Double,
    val relativeStrengthIndexHighBand: Double,
    val midPoint: Double,
    val midPrice: Double,
    val parabolicStopAndReverse: Double,
    val trange: Double,
    val averageTrueRange: Double,
    val normalizedAverageTrueRange: Double,
    val chaikinAccumulationDistributionLine: Double,
    val accumulationDistributionOscillatorSC: Double,
    val onBalanceVolume: Double,
    val htTrendline: Double,
    val leadSine: Double,
    val sine: Double,
    val trendMode: Double,
    val dcPeriod: Double,
    val htDcPhase: Double,
    val phase: Double,
    val quadrature: Double,
    val actualPrice: Double?
) {
    var predictedPrice: Double? = null
}
