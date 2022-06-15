package com.jmc.register.data.source

import com.jmc.register.data.repository.Remote
import javax.inject.Inject

class DataSourceFactory @Inject constructor(
    private val remote: Remote
) {
    fun getRemote(): Remote = remote
}