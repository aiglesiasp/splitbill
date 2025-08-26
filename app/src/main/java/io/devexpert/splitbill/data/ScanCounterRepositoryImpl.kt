package io.devexpert.splitbill.data

import io.devexpert.splitbill.data.datasources.ScanCounterDataSource
import io.devexpert.splitbill.domain.ScanCounterRepository
import kotlinx.coroutines.flow.Flow

class ScanCounterRepositoryImpl(private val scanCounterDataSource: ScanCounterDataSource):
    ScanCounterRepository {

    override val scansRemaining: Flow<Int> = scanCounterDataSource.scansRemaining

    override suspend fun initializeOrResetIfNeeded() {
        scanCounterDataSource.initializeOrResetIfNeeded()
    }

    override suspend fun decrementScan() {
        scanCounterDataSource.decrementScan()
    }
}