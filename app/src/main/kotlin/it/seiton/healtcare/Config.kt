package it.seiton.healtcare

import android.content.Context

/**
 * Created by lukasw44 on 17/10/2016.
 * Global project configuration.
 */
class Config(context: Context) {

    val version: Int
    val name: String
    val endpoint: String
    val connectTimeoutSec: Int
    val readTimeoutSec: Int
    val frequency: Long
    val writeTimeoutSec: Int
    val accountName: String
    val contentProvider: String
    val tablet: Boolean

    init {
        val res = context.resources

        this.version = res.getInteger(R.integer.database_version)
        this.name = res.getString(R.string.database_name)
        this.tablet = res.getBoolean(it.seiton.library.R.bool.tablet)

        this.endpoint = res.getString(R.string.endpoint)
        this.connectTimeoutSec = res.getInteger(R.integer.connect_timeout_sec)
        this.readTimeoutSec = res.getInteger(R.integer.read_timeout_sec)
        this.writeTimeoutSec = res.getInteger(R.integer.write_timeout_sec)

        this.frequency = res.getInteger(R.integer.sync_frequency).toLong()
        this.accountName = res.getString(R.string.sync_account_name)
        this.contentProvider = res.getString(R.string.sync_content_provider)
    }
}