package com.example.lab9

import android.content.Context
import java.io.FileOutputStream

class DataFileHelper {

    companion object {
        fun writeDataToFile(context: Context, data: String) {
            try {
                val filename = "data.txt"
                val fileOutputStream: FileOutputStream = context.openFileOutput(filename, Context.MODE_APPEND)
                fileOutputStream.write(data.toByteArray())
                fileOutputStream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}