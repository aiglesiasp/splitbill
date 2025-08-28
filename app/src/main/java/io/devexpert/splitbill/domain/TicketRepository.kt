package io.devexpert.splitbill.domain

import io.devexpert.splitbill.domain.model.TicketData

interface TicketRepository {
    suspend fun processTicket(image: ByteArray): TicketData
    fun getTicketData(): TicketData?
}