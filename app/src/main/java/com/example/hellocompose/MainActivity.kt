package com.example.hellocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hellocompose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        OutlinedTextField(
                            value = "Customized TextField",
                            onValueChange = {},
                            label = { Text("TextField") },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.build),
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TextSample() {
    Column {
        val story = "昔あるところにおじいさんとおばあさんがいました。" + "おじいさんは山へ芝刈りに、おばあさんは川へ洗濯に行きました。"
        Text(text = story)
        Text(text = story, maxLines = 1, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ImageSample() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = "A dog image",
        contentScale = ContentScale.None,
        modifier = Modifier.size(300.dp)
    )
}

@Composable
fun ModifierSample() {
    Text(
        text = "I like Compose",
        modifier = Modifier
            .size(width = 200.dp, height = 100.dp)
            .background(
                brush = Brush.linearGradient(listOf(Color.White, Color.Gray)),
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { println("Click!") }
            .padding(10.dp)
    )
}

@Composable
fun ColumnSample() {
    Column {
        Text(text = "Good Morning!")
        Text(text = "Good Afternoon!")
        Text(text = "Good Evening!")
        Text(text = "Good Night")
    }
}

@Composable
fun RowSample() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.bird),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun BoxSample() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = "This is a dog.",
            color = Color.White
        )
    }
}

@Composable
fun AbsoluteSizeSample() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.size(size = 100.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.size(width = 150.dp, height = 200.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Composable
fun RelativeToParentSizeSample() {
    Column(modifier = Modifier.width(300.dp)) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.fillMaxWidth(),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.fillMaxWidth(0.7f),
            contentDescription = null
        )
    }
}

@Composable
fun RelativeToSiblingsSample1() {
    Row(modifier = Modifier.width(600.dp)) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.weight(2f),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.weight(1f),
            contentDescription = null
        )
    }
}

@Composable
fun RelativeToSiblingsSample2() {
    Row(modifier = Modifier.width(500.dp)) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.weight(1f),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.width(100.dp),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.bird),
            modifier = Modifier.weight(1f),
            contentDescription = null
        )
    }
}

@Composable
fun SpacerSample() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.width(100.dp),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(50.dp))
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.width(100.dp),
            contentDescription = null
        )
    }
}

@Composable
fun PaddingSample() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.width(100.dp).padding(10.dp),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.width(100.dp).padding(10.dp),
            contentDescription = null
        )
    }
}

@Composable
fun ArrangementSample() {
    Column(
        modifier = Modifier.height(400.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.bird),
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Composable
fun AlignmentSample1() {
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.size(70.dp),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.size(100.dp),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.bird),
            modifier = Modifier.size(130.dp),
            contentDescription = null
        )
    }
}

@Composable
fun AlignmentSample2() {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.size(70.dp).align(Alignment.End),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.size(100.dp),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.bird),
            modifier = Modifier.size(130.dp),
            contentDescription = null
        )
    }
}

@Composable
fun NestedLayoutSample() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.dog),
                modifier = Modifier.size(100.dp),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.cat),
                modifier = Modifier.size(100.dp),
                contentDescription = null
            )
            Image(
                painter = painterResource(id = R.drawable.bird),
                modifier = Modifier.size(100.dp),
                contentDescription = null
            )
        }
        Text("There are three animal pictures")
    }
}

@Composable
fun CounterSample() {
    var count by remember { mutableIntStateOf(0) }
    Text(
        text = "$count",
        modifier = Modifier.clickable { count++ }
    )
}

@Composable
fun TextFieldSample() {
    var text by remember { mutableStateOf("") }
    TextField(value = text, onValueChange = { text = it })
}

@Composable
fun ScrollSample() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(state = scrollState)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dog),
            modifier = Modifier.fillMaxWidth().aspectRatio(1f),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.cat),
            modifier = Modifier.fillMaxWidth().aspectRatio(1f),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.bird),
            modifier = Modifier.fillMaxWidth().aspectRatio(1f),
            contentDescription = null
        )
    }
}

data class Animal(
    @DrawableRes val resourceId: Int,
    val text: String
)

@Composable
fun AnimalSection(animals: List<Animal>) {
    var selectedAnimal by remember { mutableStateOf<Animal?>(null) }
    Column {
        Message(selectedAnimal = selectedAnimal)
        AnimalList(
            animals = animals,
            onAnimalClick = { selectedAnimal = it }
        )
    }
}

@Composable
fun Message(selectedAnimal: Animal?) {
    Text(
        text = "Select an image.",
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth().padding(20.dp)
    )
    if (selectedAnimal != null) {
        Text(
            text = "${selectedAnimal.text} is selected",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
    }
}

@Composable
fun AnimalList(
    animals: List<Animal>,
    onAnimalClick: (Animal) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        for (animal in animals) {
            AnimalCard(
                animal = animal,
                onClick = onAnimalClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun AnimalCard(
    animal: Animal,
    onClick: (Animal) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable { onClick(animal) }
    ) {
        Image(
            painter = painterResource(id = animal.resourceId),
            contentDescription = null
        )
        Text(text = animal.text)
    }
}

@Composable
fun OnOffSwitch(on: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "Off",
            style = MaterialTheme.typography.titleLarge
        )
        Switch(
            checked = on,
            onCheckedChange = {},
            modifier = Modifier.padding(horizontal = 4.dp)
        )
        Text(
            text = "On",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnOffSwitchPreview() {
    OnOffSwitch(on = true)
}

// テーマのコンポーザブル関数でラップし、Surfaceでラップすると、アプリのテーマが適用される
@Preview
@Composable
fun OnOffSwitchPreviewWithTheme() {
    HelloComposeTheme {
        Surface {
            OnOffSwitch(on = true)
        }
    }
}

val lambda1: () -> Unit = { println("Lambda") }
val lambda2 = { println("Lambda") }

val lambdaX = lambda1
// lambdaX()

val labmda3 = { name: String -> println("My name is $name") }
val lambda4: (String) -> Unit = { name -> println("My name is $name") }
val lambda5: (String) -> Unit = { println("My name is $it") }

val lambda6 = { name: String, age: Int ->
    println("$name is $age years old")
}
val lambda7: (String, Int) -> Unit = { name, age ->
    println("$name is $age years old")
}

val lambda8: (String) -> Unit = { println("args is not used") }
val lambda9: (String, Int) -> Unit = { _, _ ->
    println("args is not used")
}
val lambda10: (String, Int) -> Unit = { name, _ ->
    println("arg1 is $name")
}

val lambda11: (Int, Int) -> Int = { x, y -> x + y }
val lambda12: (Int, Int) -> Int = { x, y ->
    val sum = x + y
    sum / 2
}

fun process(input: Int = 0, innerProcess: (value: Int) -> Unit) {}

// 拡張関数の定義方法
fun String.printLengthIfNotBlank() {
    if (isNotBlank()) {
        println(this.length)
    }
}

val hello = "Hello"
hello.printLengthIfNotBlank()

// クラス内拡張関数
class PrintLengthScope() {
    fun String.printLength() {
        println(length)
    }

    fun checkLength(text: String) {
        text.printLength()
    }
}

val scope = PrintLengthScope()
scope.checkLength("Hello")