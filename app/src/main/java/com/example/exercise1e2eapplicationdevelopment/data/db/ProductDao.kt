package com.example.exercise1e2eapplicationdevelopment.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.exercise1e2eapplicationdevelopment.domain.model.ProductModel

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(productModel: ProductModel)

    @Update
    suspend fun update(productModel: ProductModel)

    @Delete
    suspend fun delete(productModel: ProductModel)

    @Query("select * from products order by id ASC")
    fun getAllProducts(): LiveData<List<ProductModel>>

}