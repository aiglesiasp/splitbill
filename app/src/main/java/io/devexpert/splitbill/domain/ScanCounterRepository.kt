package io.devexpert.splitbill.domain

import kotlinx.coroutines.flow.Flow

interface ScanCounterRepository {
    val scansRemaining: Flow<Int>
    suspend fun initializeOrResetIfNeeded()
    suspend fun decrementScan()
}