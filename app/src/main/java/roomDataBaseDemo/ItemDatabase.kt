package roomDataBaseDemo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 2)
abstract class ItemDatabase :RoomDatabase(){
    abstract fun itemDao() : ItemDao
}