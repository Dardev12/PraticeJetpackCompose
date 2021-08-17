package com.dardev.experimentationone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dardev.experimentationone.layout.AspectRatiocompo
import com.dardev.experimentationone.layout.CustomisePadding
import com.dardev.experimentationone.layout.HorsSet
import com.dardev.experimentationone.layout.PaddingIdentical
import com.dardev.experimentationone.material.AlertActivity
import com.dardev.experimentationone.material.ClicText
import com.dardev.experimentationone.ui.theme.ExperimentationOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    ClicText()
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    PaddingIdentical()
                    CustomisePadding()
                    HorsSet()
                    AspectRatiocompo()
                }
            }
    }
}



