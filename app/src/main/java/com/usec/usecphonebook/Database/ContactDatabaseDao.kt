/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.usec.usecphonebook.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDatabaseDao {
    @Query("SELECT * FROM contact_address ORDER BY name")
    fun getAddresses(): Flow<List<ContactAddress>>

    @Query("SELECT * FROM contact_address ORDER BY name LIMIT 1 OFFSET :index ")
    fun getAddress(index: Int): Flow<ContactAddress>

    @Query("SELECT * FROM contact_address WHERE name LIKE :query OR phoneNumber LIKE :query OR email LIKE :query ORDER BY name")
    fun search(query: String): Flow<List<ContactAddress>>

    @Query("SELECT COUNT(*) FROM contact_address")
    fun getCount(): Flow<Int>

    @Insert
    fun insert(address: ContactAddress)

    @Query("SELECT * FROM contact_address WHERE _id == :id")
    fun getAddressById(id: Long): Flow<ContactAddress>

    @Delete
    fun delete(address: ContactAddress)

    @Query("DELETE FROM contact_address")
    fun deleteAll()

    @Update
    fun update(address: ContactAddress)

    companion object {
        fun delete(contactAddress: Any) {

        }
    }
}