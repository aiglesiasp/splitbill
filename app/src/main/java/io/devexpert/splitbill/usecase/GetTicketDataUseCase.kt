package io.devexpert.splitbill.usecase

import io.devexpert.splitbill.domain.TicketRepository
import io.devexpert.splitbill.domain.model.TicketData

class GetTicketDataUseCase(private val ticketRepository: TicketRepository) {
    suspend operator fun invoke(): TicketData? = ticketRepository.getTicketData()
}