package com.usec.usecphonebook.model

import android.location.Address
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.usec.usecphonebook.Database.ContactAddress
import com.usec.usecphonebook.Database.ContactDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import kotlinx.coroutines.launch
import androidx.lifecycle.*
import com.usec.usecphonebook.Database.ContactDatabaseDao.Companion.delete


class AddressListViewModel(private val addressDao: ContactDatabaseDao) : ViewModel() {
    val allItems: LiveData<List<ContactAddress>> = addressDao.getAddresses().asLiveData()

    fun insert(address: ContactAddress) {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                addressDao.insert(address)
            }
        }
    }

    fun delete(address: Address) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                ContactDatabaseDao.delete(address)
            }
        }
    }
}

private fun <T> Flow<T>.asLiveData(): LiveData<T> {
    TODO("Not yet implemented")
}
