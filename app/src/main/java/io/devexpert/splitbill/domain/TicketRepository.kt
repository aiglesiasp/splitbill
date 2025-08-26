package io.devexpert.splitbill.domain

import android.graphics.Bitmap

interface TicketRepository {
    suspend fun processTicket(image: Bitmap): TicketData
    fun getTicketData(): TicketData?
}