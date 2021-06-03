package com.example.demo.controller

import com.example.demo.model.Logger
import com.example.demo.repository.LoggerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class LoggerController(private val loggerRepository: LoggerRepository) {

    @GetMapping("/logger")
    fun getAllLoggers(): List<Logger> =
        loggerRepository.findAll()

    @PostMapping("/logger")
    fun createNewLogger(@Valid @RequestBody logger: Logger): Logger =
        loggerRepository.save(logger)

    @GetMapping("/logger/{id}")
    fun getLoggerById(@PathVariable(value = "id") id: Long): ResponseEntity<Logger> {
        return loggerRepository.findById(id).map { logger ->
            ResponseEntity.ok(logger)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/logger/{id}")
        fun updateLoggerById(@PathVariable(value = "id") id: Long,
                             @Valid @RequestBody newLogger: Logger): ResponseEntity<Logger> {
        return loggerRepository.findById(id).map { existingLogger ->
            val updateLogger: Logger = existingLogger.copy(
                longitude = newLogger.longitude,
                latitude = newLogger.latitude,
                altitude = newLogger.altitude,
                gpstime = newLogger.gpstime)
            ResponseEntity.ok().body(loggerRepository.save(updateLogger))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/logger/{id}")
    fun deleteLoggerById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return loggerRepository.findById(id).map { logger ->
            loggerRepository.delete(logger)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}
