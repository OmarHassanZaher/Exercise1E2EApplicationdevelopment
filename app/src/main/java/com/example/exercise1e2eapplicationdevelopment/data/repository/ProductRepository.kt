package com.example.exercise1e2eapplicationdevelopment.data.repository

import androidx.lifecycle.LiveData
import com.example.exercise1e2eapplicationdevelopment.data.db.ProductDao
import com.example.exercise1e2eapplicationdevelopment.domain.model.ProductModel

class ProductRepository(private val productDao: ProductDao) {

    val getAllProduct: LiveData<List<ProductModel>> = productDao.getAllProducts()

    suspend fun insert(productModel: ProductModel){
        productDao.insert(productModel)
    }

    suspend fun update(productModel: ProductModel){
        productDao.update(productModel)
    }

    suspend fun delete(productModel: ProductModel){
        productDao.delete(productModel)
    }

}