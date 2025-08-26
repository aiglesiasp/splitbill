package io.devexpert.splitbill.data

import android.graphics.Bitmap
import io.devexpert.splitbill.domain.TicketData

interface TicketRepository {
    suspend fun processTicket(image: Bitmap): TicketData
    fun getTicketData(): TicketData?
}