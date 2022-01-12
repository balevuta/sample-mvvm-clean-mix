package com.ethan.bridj.data.mapper

interface Mapper<I, O> {

    fun map(input: I): O
}
