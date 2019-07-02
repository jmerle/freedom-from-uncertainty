package com.jaspervanmerle.freedomfromuncertainty

import com.jaspervanmerle.freedomfromuncertainty.runner.DevelopmentRunner
import com.jaspervanmerle.freedomfromuncertainty.runner.ProductionRunner
import java.io.File

fun main(args: Array<String>) {
    if (args.size == 2) {
        ProductionRunner(File(args[0]), File(args[1])).run()
    } else {
        DevelopmentRunner(File(args[0])).run()
    }
}
