package com.example.kotlinfirst.sintax

/* Valores numéricos*/

val age : Int = 30;
val longNumber: Long = 3000000000000000000; //Posee un mayor rango de valores que Int
val floatNumber : Float = 10.32f;
val doubleNumber : Double = 10.3200000000000000000; //Posee un mayor rango de valores que Float

/* Valores alfanuméricos*/
//Los char solo almacenan un valor y es con ''
val char :Char = 'a';
val charNumber : Char = '1';
val charSpecial : Char = '@';

var string: String = "Lucas";

/* Valores boolenos*/
val trueBoolean: Boolean = true;
val falseBoolean: Boolean = false;



fun main(){
    //println("Hola mundo");

    println("Valores numéricas");
    println("tipo de dato de age: ${age.javaClass.kotlin}, valor : $age");
    println("tipo de dato de longNumber: ${longNumber.javaClass.kotlin}, valor : $longNumber");
    println("tipo de dato de floatNumber: ${floatNumber.javaClass.kotlin}, valor : $floatNumber");
    println("tipo de dato de floatNumber: ${doubleNumber.javaClass.kotlin}, valor : $doubleNumber");
    println("");

    println("Valores alfanuméricas");
    println("tipo de dato de char: ${char.javaClass.kotlin}, valor : $char");
    println("tipo de dato de charNumber: ${charNumber.javaClass.kotlin}, valor : $charNumber");
    println("tipo de dato de charSpecial: ${charSpecial.javaClass.kotlin}, valor : $charSpecial");
    println("tipo de dato de string: ${string.javaClass.kotlin}, valor : $string");
    println("");

    println("Valores booleanas");
    println("tipo de dato de trueBoolean: ${trueBoolean.javaClass.kotlin}, valor : $trueBoolean");
    println("tipo de dato de falseBoolean: ${falseBoolean.javaClass.kotlin}, valor : $falseBoolean");

    /*
    * Al usar la palabra clave "val" se crea una varaible inmutable, es decir, que no puede ser reasignada
    * o modificar su valor. Esto quiere decir que es un valor CONSTANTE.
    * Para crear una variable mutable se utiliza la palabra clave "var"
    * */

    val noMutableValue : Int = 30;
    //noMutableValue = 31; //Error: Val cannot be reassigned

    var mutableValue: Int = 30;
    println("Valor de mutableValue: ${mutableValue}");
    mutableValue = 31; //OK: Var can be reassigned
    println("Valor de mutableValue: ${mutableValue}");
}
