package com.example.giuseppe.demoapp.utils

import org.junit.Assert.*
import org.junit.Test

class HashCalculatorTest {
    @Test
    fun calculateHash(){
        val hashCalculator = HashCalculator()
        val array = listOf("The quick brown fox jumps over the lazy dog")
        assertEquals(
            "9e107d9d372bb6826bd81d3542a419d6",
            hashCalculator.calculate(array)
        )
        assertEquals("d41d8cd98f00b204e9800998ecf8427e", hashCalculator.calculate(listOf("")))
    }
}