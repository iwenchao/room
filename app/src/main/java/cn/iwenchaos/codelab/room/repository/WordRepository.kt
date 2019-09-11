package cn.iwenchaos.codelab.room.repository

import androidx.lifecycle.LiveData
import cn.iwenchaos.codelab.room.dao.WordDao
import cn.iwenchaos.codelab.room.entity.Word

/**
 * Created by chaos
 * on 2019/9/11. 23:54
 * 文件描述：
 */
class WordRepository(private val wordDao: WordDao) {

    val allWord: LiveData<List<Word>> = wordDao.getAllWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}