package io.devexpert.splitbill

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.devexpert.splitbill.framework.MLTicketDataSource
import io.devexpert.splitbill.framework.MockTicketDataSource
import io.devexpert.splitbill.framework.ScanCounterDataSourceImpl
import io.devexpert.splitbill.data.ScanCounterRepositoryImpl
import io.devexpert.splitbill.data.TicketRepositoryImpl
import io.devexpert.splitbill.ui.theme.SplitBillTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dataSource = if (BuildConfig.DEBUG) MockTicketDataSource() else MLTicketDataSource()
        val repository = TicketRepositoryImpl(dataSource)
        val scanCounterDataSource = ScanCounterDataSourceImpl(this)
        val scanCounterRepository = ScanCounterRepositoryImpl(scanCounterDataSource)

        setContent {
            SplitBillTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        HomeScreen(
                            ticketRepository = repository,
                            scanCounterRepository = scanCounterRepository,
                            onTicketProcessed = { ticketData ->
                                // Navegar a la pantalla de detalle
                                navController.navigate("receipt")
                            }
                        )
                    }

                    composable("receipt") {
                        ReceiptScreen(
                            ticketRepository = repository,
                            onBackPressed = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}