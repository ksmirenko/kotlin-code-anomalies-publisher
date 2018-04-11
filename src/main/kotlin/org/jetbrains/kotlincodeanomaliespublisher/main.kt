package org.jetbrains.kotlincodeanomaliespublisher

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody
import org.jetbrains.kotlincodeanomaliespublisher.structures.AnomalyType
import org.jetbrains.kotlincodeanomaliespublisher.structures.ProcessMethod


fun main(args : Array<String>) = mainBody {
    val parser = ArgParser(args)
    val anomaliesFolder by parser.storing("-d", "--directory", help="path to folder with grouped anomaly source code files")
    val type by parser.mapping(
            "--cst" to AnomalyType.CST,
            "--bytecode" to AnomalyType.BYTECODE,
            "--hwm" to AnomalyType.HWM,
            help = "anomalies type (--cst, --bytecode, or --hwm)")
    val processMethod by parser.mapping("--append" to ProcessMethod.APPEND, "--overwrite" to ProcessMethod.OVERWRITE, help = "anomalies site config file process method (--append or --overwrite)")
    val publisherName by parser.storing("-p", "--publisher_name", help="path to folder with grouped anomaly source code files")

    Runner.run(anomaliesFolder, type, processMethod, publisherName)
}
