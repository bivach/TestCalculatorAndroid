package bivachi.agustin.kotlintest.controller

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

import bivachi.agustin.kotlintest.model.PendingBinaryOperation

/**
 * Created by agustinbivachi on 26/4/17.
 */
class CalculatorController {

    private var accumulator: Double?
    private val pendingOperation: PendingBinaryOperation

    init {
        this.accumulator = 0.0
        this.pendingOperation = PendingBinaryOperation()
    }

    fun setAccumulator(display: String) {
        this.accumulator = parseStringToNumber(display)
    }

    val result: String
        get() {
            if (accumulator != null || accumulator!!.toString() != "Infinity") {
                return formatNumberToString(accumulator)
            } else {
                reset()
                return "Error"
            }
        }

    fun performOperation(currentSymbol: String) {
        executePendingBinaryOperation()
        pendingOperation.setOperationValues(accumulator, currentSymbol)
    }

    private fun executePendingBinaryOperation() {
        if (pendingOperation.currentOperationToPerform != null) {
            accumulator = pendingOperation.currentOperationToPerform!!.operation(pendingOperation.firstOperand!!, accumulator!!)
            pendingOperation.resetPendingBinaryOperation()
        }
    }

    fun reset() {
        this.accumulator = 0.0
        pendingOperation.resetPendingBinaryOperation()
    }

    fun formatNumberToString(result: Double?): String {
        val nf = NumberFormat.getNumberInstance(Locale.GERMAN)
        val decimalFormat = nf as DecimalFormat
        return decimalFormat.format(result)
    }

    private fun parseStringToNumber(display: String): Double {

        return java.lang.Double.parseDouble(display.replace(".", "").replace(",", ".").replace("Error", "0"))
        //replace methods are to handle parse errors
    }


}
