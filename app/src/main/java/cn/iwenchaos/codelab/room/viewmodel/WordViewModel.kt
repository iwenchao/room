package cn.iwenchaos.codelab.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cn.iwenchaos.codelab.room.entity.Word
import cn.iwenchaos.codelab.room.repository.WordRepository
import cn.iwenchaos.codelab.room.room.WordRoomDatabase
import kotlinx.coroutines.launch

/**
 * Created by chaos
 * on 2019/9/11. 23:58
 * 文件描述：
 */
class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository

    val allWord: LiveData<List<Word>>

    init {
        val wordDao = WordRoomDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordDao)
        allWord = repository.allWord
    }


    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}