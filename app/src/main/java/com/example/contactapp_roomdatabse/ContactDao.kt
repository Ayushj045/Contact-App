package com.example.contactapp_roomdatabse

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import java.util.concurrent.Flow
import com.example.contactapp_roomdatabse.Contact as Contact
import kotlin.collections.List as List

@Dao
interface ContactDao {

    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

   @Query("SELECT * FROM contact ORDER BY firstName ASC")
   fun getContactsOrderedByFirstName(): kotlinx.coroutines.flow.Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY lastName ASC")
    fun getContactsOrderedByLastName(): kotlinx.coroutines.flow.Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY phoneNumber ASC")
    fun getContactsOrderedByPhoneNumber(): kotlinx.coroutines.flow.Flow<List<Contact>>
}