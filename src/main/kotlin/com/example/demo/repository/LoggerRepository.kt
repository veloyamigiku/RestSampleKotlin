package com.example.demo.repository

import com.example.demo.model.Logger
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LoggerRepository: JpaRepository<Logger, Long>
