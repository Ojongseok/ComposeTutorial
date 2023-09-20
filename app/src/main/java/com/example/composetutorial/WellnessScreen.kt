package com.example.composetutorial

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
//    WaterCounter(modifier)
    Column(modifier= modifier) {
        StatefulCounter(modifier)
//        WellnessTasksList()
        val list = remember {
            getWellnessTasks().toMutableStateList()
        }
        WellnessTasksList(
            list = list,
            onCloseTask = {
                list.remove(it)
            }
        )
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }