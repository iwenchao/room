package cn.iwenchaos.codelab.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cn.iwenchaos.codelab.room.entity.Word

/**
 * Created by chaos
 * on 2019/9/11. 23:38
 * 文件描述：
 */
@Dao
interface WordDao {

    @Query("select * from word_table order by word asc")
    fun getAllWords():List<Word>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("delete from word_table")
    suspend fun deleteAll()

}