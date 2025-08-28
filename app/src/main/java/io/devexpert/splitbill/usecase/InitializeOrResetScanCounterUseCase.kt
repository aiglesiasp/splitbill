package io.devexpert.splitbill.usecase

import io.devexpert.splitbill.domain.ScanCounterRepository

class InitializeOrResetScanCounterUseCase(private val scanCounterRepository: ScanCounterRepository)  {
    suspend operator fun invoke() {
        scanCounterRepository.initializeOrResetIfNeeded()
    }
}