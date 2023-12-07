@file:OptIn(ExperimentalMaterial3Api::class)

package id.utdi.putridwioktaviani.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import id.utdi.putridwioktaviani.R
import id.utdi.putridwioktaviani.ui.screens.AppViewModel
import id.utdi.putridwioktaviani.ui.screens.HomeScreen

@Composable
fun AppScreen() { //composable yang digunakan untuk menampilkan konten dalam screen
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { MarsTopAppBar(scrollBehavior = scrollBehavior) } //menampilkan topbar
    ) {
        LazyColumn { //menggunakan lazycolumn agar dapat discroll secara vertikal
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                ) {
                    val marsViewModel: AppViewModel = viewModel()
                    HomeScreen( //menjalankan homescreen dalam class file HomeScreen
                        appUiState = marsViewModel.appUiState
                    )
                }
            }
        }
    }
}

@Composable
fun MarsTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) { //composable untuk membuat topbar
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.top_bar_title),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}
