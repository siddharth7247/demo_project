package roomDataBaseDemo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemDao {
    @Query("Select * from items")
    fun getAll() : List<Item>

    @Insert
    fun insertAll(vararg items : Item)

    @Delete
    fun delete(item : Item)

    @Update
    fun updateItem(item : Item)
}