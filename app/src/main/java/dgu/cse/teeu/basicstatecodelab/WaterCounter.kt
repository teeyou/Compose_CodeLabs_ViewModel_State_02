package dgu.cse.teeu.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//@Composable
//fun WaterCounter(modifier: Modifier = Modifier) {
////    val count : MutableState<Int> = remember { mutableStateOf(0) }
//
//    var count by rememberSaveable {
//        mutableStateOf(0)
//    }
//
//    Column(modifier = modifier.padding(16.dp)) {
//        if (count > 0) {
//            var showTask by remember { mutableStateOf(true) }
//            if (showTask) {
//                WellnessTaskItem(
//                    onClose = { showTask = false},
//                    taskName = "Have you taken your 15 minute walk today?"
//                )
//            }
//            Text(text = "You've had $count glasses.")
//        }
//
//        Row(Modifier.padding(top = 8.dp)) {
//            Button(
//                enabled = count < 10,
//                onClick = { count++ }) {
//                Text(text = "Add one")
//            }
//
//            Button(
//                onClick = { count = 0 },
//                modifier = Modifier.padding(start = 8.dp)) {
//                Text(text = "Clear water count")
//            }
//        }
//
//    }
//}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }

    var waterCount by remember { mutableStateOf(0) }
    var juiceCount by remember { mutableStateOf(0) }

    StatelessCounter(count, { count++ }, modifier)
//    StatelessCounter(waterCount, { waterCount++ })  //Stateless Composable 재사용
//    StatelessCounter(juiceCount, { juiceCount++ })  //Stateless Composable 재사용

}