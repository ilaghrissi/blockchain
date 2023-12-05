package com.example.blockchain

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlockchainApplication

fun main(args: Array<String>) {
	runApplication<BlockchainApplication>(*args){
		setBannerMode(Banner.Mode.OFF)
	}
}
