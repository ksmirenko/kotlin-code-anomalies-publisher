package org.jetbrains.kotlincodeanomaliespublisher.structures

enum class AnomalyType(private val anomalyTypeName: String, val anomalyTypeDescription: String) {
    CST("cst", "CST"),
    BYTECODE("bytecode", "JVM-bytecode"),
    HWM("hwm", "CST with human-written metrics");

    override fun toString(): String {
        return this.anomalyTypeName
    }
}
