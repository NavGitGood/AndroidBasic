package com.example.jetpackcomposearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposearticle.ui.theme.JetPackComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    ContentPainter(
//                        heading = stringResource(R.string.heading),
//                        about = stringResource(R.string.about),
//                        content = stringResource(R.string.content)
//                    )
                    BusinessCard(
                        name = stringResource(R.string.b_card_name),
                        title = stringResource(R.string.b_card_title),
                        phone = stringResource(R.string.b_card_phone),
                        share = stringResource(R.string.b_card_share),
                        email = stringResource(R.string.b_card_email),
                    )
                }
            }
        }
    }
}

@Composable
fun ContentPainter(heading: String, about: String, content: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(painter = image, contentDescription = null)
        Text(
            text = heading,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = about,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }

}

@Composable
fun TaskManagerScreen(content: String, signature: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.ic_task_completed)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Image(painter = image, contentDescription = null)
        Text(
            text = content,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = signature,
            fontSize = 16.sp
        )
    }
}

@Composable
fun QuadrantScreen(qText: String, qImage: String, qRow: String, qColumn: String,
                   qTextContent: String, qImageContent: String, qRowContent: String, qColumnContent: String,
                   modifier: Modifier = Modifier)
{
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = qText,
                description = qTextContent,
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = qImage,
                description = qImageContent,
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = qRow,
                description = qRowContent,
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = qColumn,
                description = qColumnContent,
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun BusinessCard(name: String, title: String,
                 phone: String, share: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0xFFd2e8d4))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .height(120.dp)
                .width(150.dp)
        )
        Text(
            text = name,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = title,
            color = Color(0xFF013220),
            fontSize = 17.sp
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp)
        ) {
            Icon(Icons.Filled.Phone, null, Modifier.padding(8.dp), Color(0xFF006d3b))
            Text(
                text = phone,
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp)
        ) {
            Icon(Icons.Filled.Share, null, Modifier.padding(8.dp), Color(0xFF006d3b))
            Text(
                text = share,
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp)
        ) {
            Icon(Icons.Filled.Email, null, Modifier.padding(8.dp), Color(0xFF006d3b))
            Text(
                text = email,
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeArticleTheme {
//        ContentPainter(
//            heading = stringResource(R.string.heading),
//            about = stringResource(R.string.about),
//            content = stringResource(R.string.content)
//        )
//        TaskManagerScreen(
//            content = stringResource(R.string.task_content),
//            signature = stringResource(R.string.task_signature)
//        )
//        QuadrantScreen(
//            qText = stringResource(R.string.q_text),
//            qTextContent = stringResource(R.string.q_text_content),
//            qImage = stringResource(R.string.q_image),
//            qImageContent = stringResource(R.string.q_image_content),
//            qRow = stringResource(R.string.q_row),
//            qRowContent = stringResource(R.string.q_row_content),
//            qColumn = stringResource(R.string.q_column),
//            qColumnContent = stringResource(R.string.q_column_content),
//        )
        BusinessCard(
            name = stringResource(R.string.b_card_name),
            title = stringResource(R.string.b_card_title),
            phone = stringResource(R.string.b_card_phone),
            share = stringResource(R.string.b_card_share),
            email = stringResource(R.string.b_card_email),
        )
    }
}