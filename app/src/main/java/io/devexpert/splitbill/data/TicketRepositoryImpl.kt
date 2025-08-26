package io.devexpert.splitbill.data

import android.graphics.Bitmap
import io.devexpert.splitbill.TicketData

class TicketRepositoryImpl(private val ticketDataSource: TicketDataSource): TicketRepository {

    private var _ticketData: TicketData? = null

    override suspend fun processTicket(image: Bitmap): TicketData {
        val result = ticketDataSource.processTicket(image)
        _ticketData = result
        return result
    }

    override fun getTicketData(): TicketData? {
       return _ticketData
    }
}