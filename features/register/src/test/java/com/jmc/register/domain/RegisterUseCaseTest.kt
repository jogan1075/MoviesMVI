package com.jmc.register.domain

import com.jmc.register.domain.repository.Repository
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class RegisterUseCaseTest{

    private val mockedRepository: Repository = mock()
    private val registerUseCase = RegisterUseCase(mockedRepository)

    @Test
    fun `given valid request when addProductToList then get stateSuccessful`() {
//        val addProductToListRequestDomain = makeAddProductToListRequestDomain()
//        val stateSuccessful = makeResultStateStateSuccessful()

       /* doReturnSingle(stateSuccessful).whenever(mockedRepository).addProductToList(any())

        addProductToListUseCase.execute(addProductToListRequestDomain)
            .test().assertValue(stateSuccessful)*/
    }
}

