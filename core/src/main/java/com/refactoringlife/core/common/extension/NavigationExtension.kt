package com.refactoringlife.core.common.extension

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

//todo navegamos hacia una ruta
fun NavBackStack<NavKey>.navigateTo(screen: NavKey) {
    add(screen)
}
//todo navegamos hacia atras
fun NavBackStack<NavKey>.back(){
    if (isEmpty()) return
    removeLastOrNull()
}
//todo navegamos hacia atras hasta una ruta especifica
fun NavBackStack<NavKey>.backTo(targetScreen: NavKey) {
    if (isEmpty()) return
    if (targetScreen != this) return

    while (isEmpty() && last()  != targetScreen) {
        removeLastOrNull()
    }
}