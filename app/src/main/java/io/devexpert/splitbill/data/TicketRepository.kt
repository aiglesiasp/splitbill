package io.devexpert.splitbill.data

import android.graphics.Bitmap
import io.devexpert.splitbill.TicketData

interface TicketRepository {
    suspend fun processTicket(image: Bitmap): TicketData
}