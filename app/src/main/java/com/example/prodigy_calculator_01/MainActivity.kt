package com.example.prodigy_calculator_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import java.lang.Exception
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.xml.xpath.XPathExpression
import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    private lateinit var input: TextView
    private lateinit var result: TextView
    private lateinit var clear: Button
    private lateinit var backspace: Button
    private lateinit var percent: Button
    private lateinit var divide: Button
    private lateinit var multiply: Button
    private lateinit var sub: Button
    private lateinit var add: Button
    private lateinit var equal: Button
    private lateinit var dot: Button
    private lateinit var zero: Button
    private lateinit var doublezero: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.input)
        result = findViewById(R.id.result)
        clear = findViewById(R.id.clear)
        backspace = findViewById(R.id.backspace)
        percent = findViewById(R.id.percent)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        sub = findViewById(R.id.sub)
        add = findViewById(R.id.add)
        equal = findViewById(R.id.equal)
        dot= findViewById(R.id.dot)
        zero = findViewById(R.id.zero)
        doublezero = findViewById(R.id.doublezero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)

        input.movementMethod = ScrollingMovementMethod()
        input.isActivated = true
        input.isPressed = true

        var str:String

        clear.setOnClickListener {
            inputText("0" )
            input.textSize = 60f
            result.textSize = 30f
            resultText()
        }
        backspace.setOnClickListener {
            if (input.text.toString().isNotEmpty()){
                val lastIndex = input.text.toString().lastIndex
                str = input.text.toString().substring(0, lastIndex)
                inputText(str)
                resultText()
            }
        }
        percent.setOnClickListener {
           if ( input.text.toString().endsWith("%") || input.text.toString().endsWith("/") || input.text.toString().endsWith("*") || input.text.toString().endsWith("+") || input.text.toString().endsWith("-")
               || input.text.toString().endsWith(".")){
               str = input.text.toString()
               inputText(str)
           }
            else{
                str = input.text.toString() + "%"
               inputText(str)
           }
        }
        divide.setOnClickListener {
            if ( input.text.toString().endsWith("%") || input.text.toString().endsWith("/") || input.text.toString().endsWith("*") || input.text.toString().endsWith("+") || input.text.toString().endsWith("-")
                || input.text.toString().endsWith(".")){
                str = input.text.toString()
                inputText(str)
            }
            else{
                str = input.text.toString() + "/"
                inputText(str)
            }
        }
        multiply.setOnClickListener {
            if ( input.text.toString().endsWith("%") || input.text.toString().endsWith("/") || input.text.toString().endsWith("*") || input.text.toString().endsWith("+") || input.text.toString().endsWith("-")
                || input.text.toString().endsWith(".")){
                str = input.text.toString()
                inputText(str)
            }
            else{
                str = input.text.toString() + "*"
                inputText(str)
            }
        }
        sub.setOnClickListener {
            if ( input.text.toString().endsWith("%") || input.text.toString().endsWith("/") || input.text.toString().endsWith("*") || input.text.toString().endsWith("+") || input.text.toString().endsWith("-")
                || input.text.toString().endsWith(".")){
                str = input.text.toString()
                inputText(str)
            }
            else{
                str = input.text.toString() + "-"
                inputText(str)
            }
        }
        add.setOnClickListener {
            if ( input.text.toString().endsWith("%") || input.text.toString().endsWith("/") || input.text.toString().endsWith("*") || input.text.toString().endsWith("+") || input.text.toString().endsWith("-")
                || input.text.toString().endsWith(".")){
                str = input.text.toString()
                inputText(str)
            }
            else{
                str = input.text.toString() + "+"
                inputText(str)
            }
        }
        equal.setOnClickListener {
            if ( input.text.toString().endsWith("%") || input.text.toString().endsWith("/") || input.text.toString().endsWith("*") || input.text.toString().endsWith("+") || input.text.toString().endsWith("-")
                || input.text.toString().endsWith(".")){
                str = input.text.toString()
                inputText(str)
            }
            else{
                str = input.text.toString() + "="
                inputText(str)
            }
        }
        dot.setOnClickListener {
            if ( input.text.toString().endsWith("%") || input.text.toString().endsWith("/") || input.text.toString().endsWith("*") || input.text.toString().endsWith("+") || input.text.toString().endsWith("-")
                || input.text.toString().endsWith(".")){
                str = input.text.toString()
                inputText(str)
            }
            else{
                str = input.text.toString() + "."
                inputText(str)
            }
        }
        zero.setOnClickListener {
            if (input.text.toString().startsWith("0")){
                str = input.text.toString().replace("0", "") + "0"
                inputText(str)
                resultText()
            }else{
                str = input.text.toString() + "0"
                inputText(str)
                resultText()
            }
        }
        doublezero.setOnClickListener {
            if (input.text.toString().startsWith("0")){
                str = input.text.toString().replace("0", "") + "00"
                inputText(str)
                resultText()
            }else{
                str = input.text.toString() + "00"
                inputText(str)
                resultText()
            }
        }
        one.setOnClickListener {
            if (input.text.toString().startsWith("0")){
                str = input.text.toString().replace("0", "") + "1"
                inputText(str)
                resultText()
            }else{
                str = input.text.toString() + "1"
                inputText(str)
                resultText()
            }
        }
        two.setOnClickListener {
            if (input.text.toString().startsWith("0")){
                str = input.text.toString().replace("0", "") + "2"
                inputText(str)
                resultText()
            }else{
                str = input.text.toString() + "2"
                inputText(str)
                resultText()
            }
        }
        three.setOnClickListener {
            if (input.text.toString().startsWith("0")){
                str = input.text.toString().replace("0", "") + "3"
                inputText(str)
                resultText()
            }else{
                str = input.text.toString() + "3"
                inputText(str)
                resultText()
            }
        }
        four.setOnClickListener {
            if (input.text.toString().startsWith("0")){
                str = input.text.toString().replace("0", "") + "4"
                inputText(str)
                resultText()
            }else{
                str = input.text.toString() + "4"
                inputText(str)
                resultText()
            }
        }
        five.setOnClickListener {
            if (input.text.toString().startsWith("0")){
                str = input.text.toString().replace("0", "") + "5"
                inputText(str)
                resultText()
            }else{
                str = input.text.toString() + "5"
                inputText(str)
                resultText()
            }
        }
        six.setOnClickListener {
            if (input.text.toString().startsWith("0")){
                str = input.text.toString().replace("0", "") + "6"
                inputText(str)
                resultText()
            }else{
                str = input.text.toString() + "6"
                inputText(str)
                resultText()
            }
        }
        seven.setOnClickListener {
            if (input.text.toString().startsWith("0")){
                str = input.text.toString().replace("0", "") + "7"
                inputText(str)
                resultText()
            }else{
                str = input.text.toString() + "7"
                inputText(str)
                resultText()
            }
        }
        eight.setOnClickListener {
            if (input.text.toString().startsWith("0")){
                str = input.text.toString().replace("0", "") + "8"
                inputText(str)
                resultText()
            }else{
                str = input.text.toString() + "8"
                inputText(str)
                resultText()
            }
        }
        nine.setOnClickListener {
            if (input.text.toString().startsWith("0")){
                str = input.text.toString().replace("0", "") + "9"
                inputText(str)
                resultText()
            }else{
                str = input.text.toString() + "9"
                inputText(str)
                resultText()
            }
        }

    }

    private fun inputText(str:String){
        input.text = str
    }

    private fun resultText(){
        val exp = input.text.toString()
        val engine:ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val res = engine.eval(exp)
            if (res.toString().endsWith("0")){
                result.text = "=" + res.toString().replace("o","")
            }else{
                result.text = "=$res"
            }
        }catch (e:Exception){
            input.text = input.text.toString()
            result.text = input.text.toString()
        }
    }
}