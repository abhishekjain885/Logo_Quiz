package com.example.quiz

data class Response(
	val response: Array<ResponseItem>? = null
)

data class ResponseItem(
	val imgUrl: String? = null,
	val name: String? = null
)

