package bivachi.agustin.kotlintest.model

/**
 * Created by emilianobivachi on 10/5/17.
 */
enum class Operation {

    ADDITION {
        override fun operation(x: Double, y:Double) = x + y
    },

    SUBTRACTION {
        override fun operation(x: Double, y:Double) = x - y
    },

    MULTIPLY {
        override fun operation(x: Double, y:Double) = x * y
    },

    DIVISION {
        override fun operation(x: Double, y:Double) = x / y
    },

    EQUALS {
        override fun operation(x: Double, y:Double) = y
    };

    abstract fun operation(x: Double, y: Double): Double

}

