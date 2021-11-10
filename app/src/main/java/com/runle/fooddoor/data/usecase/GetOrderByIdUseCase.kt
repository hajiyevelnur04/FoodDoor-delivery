package com.runle.fooddoor.data.usecase

import com.runle.fooddoor.data.repository.OrderRepository

/**
 * Created by elnur on 05.11.21
 */
class GetOrderByIdUseCase constructor(private val orderRepository: OrderRepository) {
    suspend fun execute() = orderRepository.getOrderById()
}