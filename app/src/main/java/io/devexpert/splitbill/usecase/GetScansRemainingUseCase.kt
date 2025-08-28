package io.devexpert.splitbill.usecase

import io.devexpert.splitbill.domain.ScanCounterRepository
import kotlinx.coroutines.flow.Flow

class GetScansRemainingUseCase(private val scanCounterRepository: ScanCounterRepository)  {

    operator fun invoke(): Flow<Int> = scanCounterRepository.scansRemaining
}