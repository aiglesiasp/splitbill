package io.devexpert.splitbill.usecase

import io.devexpert.splitbill.domain.TicketRepository

class ProcessTicketUseCase(private val ticketRepository: TicketRepository) {
    suspend operator fun invoke(imageBytes: ByteArray) {
        ticketRepository.processTicket(imageBytes)
    }
}