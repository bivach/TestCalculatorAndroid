package bivachi.agustin.kotlintest.model

import java.util.HashMap

/**
 * Created by agustinbivachi on 30/4/17.
 */
class PendingBinaryOperation {
    var firstOperand: Double? = null
        private set
    var currentOperationToPerform: Operation? = null
        private set
    internal var operations: MutableMap<String, Operation> = HashMap()

    init {
        operations.put("x", Operation.MULTIPLY)
        operations.put("+", Operation.ADDITION)
        operations.put("-", Operation.SUBTRACTION)
        operations.put("÷", Operation.DIVISION)
        operations.put("=", Operation.EQUALS)
    }

    fun resetPendingBinaryOperation() {
        this.currentOperationToPerform = null
        this.firstOperand = null
    }

    fun setOperationValues(firstOperand: Double?, currentSymbol: String) {
        this.firstOperand = firstOperand
        this.currentOperationToPerform = operations[currentSymbol]
    }

}
