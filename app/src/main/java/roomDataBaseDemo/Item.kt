package roomDataBaseDemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "items")
data class Item (
    @PrimaryKey(autoGenerate = true) val uid : Int?,
    @ColumnInfo(name = "item_name") val name : String,
    @ColumnInfo(name = "created_at") val createdAt : String
):Serializable