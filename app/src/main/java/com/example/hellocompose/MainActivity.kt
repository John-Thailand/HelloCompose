package com.example.hellocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                        NestedLayoutSample()
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








