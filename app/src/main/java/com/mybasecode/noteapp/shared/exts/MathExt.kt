package com.mybasecode.noteapp.shared.exts

fun <T> Boolean.triadOperator(firstElement: T, secondElement: T): T {
    if (this) {
        return firstElement
    }
    return secondElement
}