package com.example.kotlinfirst.sintax.exercises

/*Se definen con listOf()*/
var namesUnMutable : List<String> = listOf("Juan", "Pedro", "Maria", "Ana");
var namesMutable : MutableList<String> = mutableListOf("Juan", "Pedro", "Maria", "Ana");
fun main(){

    //namesUnMutable.add("Lucas"); //Error: UnsupportedOperationException (Las listas por si mismas son inmutables)
    namesMutable.add("Lucas"); //OK: Se puede agregar elementos a una lista mutable

    println("nameUnMutable");
    iteratelist(namesUnMutable);
    println("");

    println("nameUnMutable");
    iteratelist(namesMutable);
    println("");
}

fun iteratelist(list : List<String>){
    //Primer item
    println("first");
    println(list.first());
    println("");

    //Ultimo item;
    println(list.last())
    println("last");
    println("");

    //Por indices
    println("index");
    println("");

    for(index in list.indices){
        println(list[index]);
    }
    println("");

    //Por valores
    for((index, values) in list.withIndex()){
        println("Posición : $index");
        println("Valor : $values");
        println("");
    }

    for(item in list){
        println(item);
        println("");
    }

    //forEach
    list.forEach{ item -> println(item)};

    //Tamaño
    println("tamaño de la lista ${list.size}");
}