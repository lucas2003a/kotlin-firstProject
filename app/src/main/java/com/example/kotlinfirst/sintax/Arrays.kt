package com.example.kotlinfirst.sintax

/*Los arrays se definen con arrayOf()*/
var ages = arrayOf(1,2,3,4,5);

fun main(){
    bucleFor3();
}

fun bucleFor(){

    for(index in ages.indices){// => Inidces
        println("Posición : $index");
        println("${ages[index]}");
    }
}
fun bucleFor2(){
    for((position, value) in ages.withIndex()){
        println("Posición : $position");
        println("${value}");
    }
}

fun bucleFor3(){

    for(position in ages){
        println("Posición : $position");
    }
}