package io.devexpert.splitbill.data

import io.devexpert.splitbill.data.datasources.TicketDataSource
import io.devexpert.splitbill.domain.model.TicketData
import io.devexpert.splitbill.domain.TicketRepository

class TicketRepositoryImpl(private val ticketDataSource: TicketDataSource): TicketRepository {

    private var _ticketData: TicketData? = null

    override suspend fun processTicket(image: ByteArray) {
        val result = ticketDataSource.processTicket(image)
        _ticketData = result
    }

    override fun getTicketData(): TicketData? {
       return _ticketData
    }
}