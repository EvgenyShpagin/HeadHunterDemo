package com.demo.hh.core.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
fun <T> rememberFlowWithLifecycle(
    flow: Flow<T>,
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle
): Flow<T> {
    return remember(flow, lifecycle) {
        flow.flowWithLifecycle(
            lifecycle,
            Lifecycle.State.STARTED
        )
    }
}

@Composable
fun <E : UiEffect> HandleUiEffects(flow: Flow<E>, onReceive: (E) -> Unit) {
    val uiEffect = rememberFlowWithLifecycle(flow)
    LaunchedEffect(uiEffect) {
        flow.collect { onReceive(it) }
    }
}
