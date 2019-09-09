package cn.iwenchaos.codelab.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by chaos
 * on 2019/9/9. 23:42
 * 文件描述：
 */
@Entity(tableName = "word_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)