package br.com.heiderlopes.calculaflex.extension

fun Double.format(digits: Int) = String.format("%.${digits}f", this)
