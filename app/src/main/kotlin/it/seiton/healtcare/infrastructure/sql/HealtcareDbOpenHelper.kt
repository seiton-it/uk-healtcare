package it.seiton.healtcare.infrastructure.datasource.sql

import android.content.Context
import android.content.ContextWrapper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import it.seiton.common.infrastructure.file.copyInputStreamToFile
import it.seiton.healtcare.Config
import timber.log.Timber
import java.io.File

/**
 * Created by lukasw44 on 18/10/2016.
 */
class HealtcareDbOpenHelper(context: Context, config: Config) : SQLiteOpenHelper(context, config.name, null, config.version) {

    val databasePath: File

    init {
        val contextWrapper: ContextWrapper = ContextWrapper(context)
        databasePath = contextWrapper.getDatabasePath(databaseName)

        if (!databasePath.exists()) {
            moveDatabase(context)
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        //db.execSQL(HospitalModel.CREATE_TABLE)
        Timber.tag(TAG).d("::onCreate(db)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Timber.tag(TAG).d("::onUpdate(db, oldVersion, newVersion), oldVersion: $oldVersion, newVersion: $newVersion, dbName: $databaseName")
    }

    private fun moveDatabase(context: Context) {
        Timber.tag(TAG).d("copy database from assets into databases folder")
        val parent = databasePath.parentFile
        try {
            if (!parent.exists()) {
                Timber.tag(TAG).d("Parent directory for database do not exist try create new one for location: ${parent.absolutePath}")
                if (parent.mkdirs()) {
                    copyDataBase(context)
                } else {
                    Timber.tag(TAG).e("Error create parents directories for database")
                }
            } else {
                copyDataBase(context)
            }
        } catch (e: Exception) {
            Timber.tag(TAG).e(e, "Error while try to copy database from assets into databases directory")
        }
    }
    private fun copyDataBase(context: Context) {
        if (databasePath.createNewFile()) {
            databasePath.copyInputStreamToFile(context.assets.open(ASSETS_DB_FILE_NAME))
            Timber.tag(TAG).d("Database copied successful")
        } else {
            Timber.tag(TAG).e("Error create new database file")
        }
    }

    companion object {
        private val TAG = "HealtcareDbOpenHelper"

        const val ASSETS_DB_FILE_NAME = "healtcare.db"
    }
}
