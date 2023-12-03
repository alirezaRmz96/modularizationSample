package com.example.core.utils.di

interface CommandExecute {
    fun execute(command: Command): Boolean
}