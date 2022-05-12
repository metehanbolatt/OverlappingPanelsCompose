package com.metehanbolat.overlappingpanelscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.metehanbolat.overlappingpanelscompose.ui.theme.OverlappingPanelsComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OverlappingPanelsComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ComposeOverlappingPanels() {
    val panelState = rememberOverlappingPanelsState()
    val coroutineScope = rememberCoroutineScope()
    val gesturesEnabled by remember { mutableStateOf(true) }

    OverlappingPanels(
        modifier = Modifier.fillMaxSize(),
        panelsState = panelState,
        gesturesEnabled = gesturesEnabled,
        panelStart = {
            PanelSurface {
                PanelColumn {
                    PanelHeaderText(
                        text = stringResource(id = R.string.app_name),
                        modifier = Modifier.align(CenterHorizontally)
                    )
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                panelState.closePanels()
                            }
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.app_name)
                        )
                    }
                }
            }
        },
        panelCenter = {
            PanelSurface {
                PanelColumn {
                    PanelHeaderText(
                        text = stringResource(id = R.string.app_name),
                        modifier = Modifier.align(CenterHorizontally)
                    )
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                panelState.openStartPanel()
                            }
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.app_name)
                        )
                    }
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                panelState.openEndPanel()
                            }
                        }
                    ) {
                        Text(text = stringResource(R.string.app_name))
                    }
                }
            }
        },
        panelEnd = {
            PanelSurface {
                PanelColumn {
                    PanelHeaderText(
                        text = stringResource(id = R.string.app_name),
                        modifier = Modifier.align(CenterHorizontally)
                    )
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                panelState.closePanels()
                            }
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.app_name)
                        )
                    }
                }
            }
        }
    )
}
