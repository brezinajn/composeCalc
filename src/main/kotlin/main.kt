import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

fun main() = Window {
    var state by remember { mutableStateOf(State()) }
    var resultState by remember { mutableStateOf<Double?>(null) }

    MaterialTheme {
        Column {
            Row {
                Column {
                    BasicTextField(value = state.firstValue.toString(), onValueChange = {
                        state = state.copy(firstValue = it.toDouble())
                    })
                }

                Column {
                    BasicTextField(value = state.op, onValueChange = {
                        state = state.copy(op = it)
                    })
                }

                Column {
                    BasicTextField(value = state.secondValue.toString(), onValueChange = {
                        state = state.copy(secondValue = it.toDouble())
                    })
                }
            }
            Row {
                Column {
                    Button(onClick = {
                        resultState = getResult(state)
                    }) {
                        Text("=")
                    }
                }

                Column {
                    Text("Result: $resultState")
                }
            }
        }
    }
}

data class State(
    val firstValue: Double = .0,
    val secondValue: Double = .0,
    val op: String = ""
)


fun getResult(state: State): Double = .0