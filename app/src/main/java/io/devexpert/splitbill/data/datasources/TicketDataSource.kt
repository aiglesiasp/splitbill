package io.devexpert.splitbill.data.datasources

import android.graphics.Bitmap
import io.devexpert.splitbill.domain.model.TicketData

interface TicketDataSource {
    suspend fun processTicket(image: Bitmap): TicketData
}