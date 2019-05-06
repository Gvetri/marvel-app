package com.example.giuseppe.demoapp.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Helper class to calculate MD5 hash of given parameters.
 */
@Singleton
class HashCalculator @Inject constructor() {

    /**
     * Calculate the has using MD5 digest algorithm.
     *
     * @param args - arguments to concatenate and hash
     * @return - the MD5 hash of the concatenated args
     */
    fun calculate(args: List<String>): String? {
        val input = concatenateArgs(args)
        val digest = generateDigest(input)
        return digest?.toHex()
    }

    private fun concatenateArgs(args: List<String>): String {
        val stringBuilder = StringBuilder()
        for (arg in args) {
            stringBuilder.append(arg)
        }
        return stringBuilder.toString()
    }

    /**
     * Generates MD5 digest from an input string.
     *
     * @param input - input string
     * @return a byte array of the MD5 digest
     */
    private fun generateDigest(input: String): ByteArray? {
        try {
            val md = MessageDigest.getInstance("MD5")
            md.update(input.toByteArray())

            return md.digest()
        } catch (nsae: NoSuchAlgorithmException) {
            nsae.printStackTrace()
        }

        return null
    }

    /***
     * Extension function for convert ByteArray to Hex
     */
    fun ByteArray.toHex() = this.joinToString(separator = "") { it.toInt().and(0xff).toString(16).padStart(2, '0') }
}
