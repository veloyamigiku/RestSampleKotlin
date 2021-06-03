package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Logger(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val longitude: Double,

    val latitude: Double,

    val altitude: Double,

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val gpstime: LocalDateTime
)
