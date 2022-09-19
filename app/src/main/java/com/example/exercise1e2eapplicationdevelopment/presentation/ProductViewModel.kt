package com.example.exercise1e2eapplicationdevelopment.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.exercise1e2eapplicationdevelopment.data.db.ProductDatabase
import com.example.exercise1e2eapplicationdevelopment.data.repository.ProductRepository
import com.example.exercise1e2eapplicationdevelopment.domain.model.ProductModel
import kotlinx.coroutines.launch

class ProductViewModel(application: Application): AndroidViewModel(application) {

    val getAllProductList: LiveData<List<ProductModel>>
    val productRepository:ProductRepository

    init {
        val dao = ProductDatabase.getDatabase(application).getProductDao()
        productRepository = ProductRepository(dao)
        getAllProductList = productRepository.getAllProduct
    }

    fun productInsert(productModel: ProductModel) = viewModelScope.launch {
        productRepository.insert(productModel)
    }

    fun productUpdate(productModel: ProductModel) = viewModelScope.launch {
        productRepository.update(productModel)
    }

    fun deleteProduct(productModel: ProductModel) = viewModelScope.launch {
        productRepository.delete(productModel)
    }

}