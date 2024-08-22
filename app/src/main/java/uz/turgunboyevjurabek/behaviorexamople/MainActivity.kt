@file:OptIn(ExperimentalMaterial3Api::class)

package uz.turgunboyevjurabek.behaviorexamople

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.turgunboyevjurabek.behaviorexamople.ui.theme.BehaviorExamopleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BehaviorExamopleTheme {

                val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

                Scaffold(
                    modifier = Modifier
                        .nestedScroll(scrollBehavior.nestedScrollConnection)
                        .fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "TopAppBar", fontSize = TextUnit.Unspecified)
                            },
                            scrollBehavior = scrollBehavior
                        )
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)

                    ) {
                        val list = listOf(
                            Color.Unspecified,
                            Color.Red,
                            Color.Blue,
                            Color.White,
                            Color.Cyan,
                            Color.Black,
                            Color.DarkGray,
                            Color.Gray,
                            Color.Green,
                            Color.LightGray,
                            Color.Magenta,
                            Color.Transparent,
                            Color.Yellow
                        )
                        val listRemember = rememberSaveable {
                            list
                        }
                        val context=this@MainActivity
                        Toast.makeText(context, "yangilandi", Toast.LENGTH_SHORT).show()

                        LazyColumn(
                            modifier = Modifier
                            .fillMaxSize()
                        ) {
                            items(50){
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 5.dp)
                                        .padding(horizontal = 15.dp),
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = listRemember.random()
                                    ),
                                    border = BorderStroke(2.dp,listRemember.random())
                                ) {
                                    Text(
                                        text = it.toString(),
                                        fontSize = 15.sp,
                                        modifier = Modifier
                                            .padding(15.dp)
                                    )

                                }
                            }
                        }

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BehaviorExamopleTheme {

    }
}