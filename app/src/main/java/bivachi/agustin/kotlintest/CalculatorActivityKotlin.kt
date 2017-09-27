package bivachi.agustin.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import bivachi.agustin.kotlintest.controller.CalculatorController

import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivityKotlin : AppCompatActivity() {

    private var userIsInTheMiddleOfTyping = false
    private var userPerformEquals = false
    private var calculatorController = CalculatorController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        setOnClicks()
    }

    private val displayTxt: String
        get() = displayTextView.text.toString()

    fun touchDigit(button: Button) {
        if (userIsInTheMiddleOfTyping!! && displayTxt != "0") {
            displayTextView.text = displayTxt + button.text
        } else {
            displayTextView.text = button.text.toString()
        }
        userIsInTheMiddleOfTyping = true
    }

    fun performOperation(button: Button) {

        val operatorSymbol = button.text.toString()

        if (userIsInTheMiddleOfTyping || userPerformEquals!!) {
            calculatorController!!.setAccumulator(displayTxt)
            calculatorController!!.performOperation(operatorSymbol)
            userIsInTheMiddleOfTyping = false
        }

        userPerformEquals = operatorSymbol == "="
        displayTextView.text = calculatorController!!.result

    }

    fun clearAll() {
        displayTextView.text = "0"
        userIsInTheMiddleOfTyping = false
        userPerformEquals = false
        calculatorController!!.reset()
    }

    fun setOnClicks() {
        button2.setOnClickListener {
            touchDigit(button2)
        }
        button1.setOnClickListener {
            touchDigit(button1)
        }
        button3.setOnClickListener {
            touchDigit(button3)
        }
        button0.setOnClickListener {
            touchDigit(button0)
        }
        button4.setOnClickListener {
            touchDigit(button4)
        }
        button5.setOnClickListener {
            touchDigit(button5)
        }
        button6.setOnClickListener {
            touchDigit(button6)
        }
        button7.setOnClickListener {
            touchDigit(button7)
        }
        button8.setOnClickListener {
            touchDigit(button8)
        }
        button9.setOnClickListener {
            touchDigit(button9)
        }
        buttonClear.setOnClickListener{
            clearAll()
        }
        buttonMultiply.setOnClickListener {
            performOperation(buttonMultiply)
        }
        buttonAdd.setOnClickListener {
            performOperation(buttonAdd)
        }
        buttonPercentage.setOnClickListener {
            performOperation(buttonPercentage)
        }
        buttonSubtraction.setOnClickListener {
            performOperation(buttonSubtraction)
        }
        buttonEquals.setOnClickListener {
            performOperation(buttonEquals)
        }
    }
}
