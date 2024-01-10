package com.satyajitbiswal.crypto

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingData
import com.satyajitbiswal.crypto.data.repository.CryptoRepository
import com.satyajitbiswal.crypto.modals.Currency
import com.satyajitbiswal.crypto.presentation.home.HomeViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CryptoViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    @Mock
    lateinit var cryptoRepository: CryptoRepository

    // Subject under test
    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        homeViewModel = HomeViewModel(cryptoRepository)
    }

    @Test
    fun getCurrencies_method_should_provide_the_currencies() {
        testDispatcher.runBlockingTest {

            val fakeCurrencyList = createFakeCurrencyList(5)
            val pagingData = PagingData.from(fakeCurrencyList)
            Mockito.`when`(cryptoRepository.getCurrencies()).thenReturn(flowOf(pagingData))

            // When

            val result = homeViewModel.getCurrencies.first()

            // Then
            assertEquals(pagingData, result)
        }
    }

    private fun createFakeCurrency(
        name: String,
        symbol: String,
        iconUrl: String,
        exchangeRate: Double?
    ): Currency {
        return Currency(name, symbol, iconUrl, exchangeRate)
    }

    private fun createFakeCurrencyList(size: Int): List<Currency> {
        val fakeCurrencies = mutableListOf<Currency>()
        for (i in 1..size) {
            fakeCurrencies.add(
                createFakeCurrency(
                    "Currency$i",
                    "SYM$i",
                    "https://example.com/icon$i.png",
                    1.0
                )
            )
        }
        return fakeCurrencies
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

}