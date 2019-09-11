package cn.iwenchaos.codelab.room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cn.iwenchaos.codelab.room.dao.WordDao
import cn.iwenchaos.codelab.room.entity.Word

/**
 * Created by chaos
 * on 2019/9/11. 23:47
 * 文件描述：
 */
@Database(entities = arrayOf(Word::class), version = 1)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {

        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            var tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance

            }
        }
    }


}