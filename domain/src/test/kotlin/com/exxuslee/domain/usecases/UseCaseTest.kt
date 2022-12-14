package com.exxuslee.domain.usecases

import com.exxuslee.domain.repositories.RepositoryDB
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class UseCaseTest {

    @Mock
    private lateinit var repository: RepositoryDB
    private lateinit var useCase: UseCaseDB.Base

    @Before
    fun setUp() {
        useCase = UseCaseDB.Base(repository)
    }

    @Test
    fun useCase_calls_Repository() {
        runTest {
            useCase.players()
            Mockito.verify(repository).players()
        }
    }

    @Test
    fun `return data from repository`() {

        runTest {
//            val expected = Result(listOf( Player(id = 1, name = "1", level = 1, bonus = 1, icon = true)))
//            Mockito.`when`(repository.players()).thenReturn(expected)
//            val actual = useCase.getPlayer(1)
//
//            Assertions.assertEquals(expected, actual)
        }
    }

    @AfterEach
    fun tearDown(){
        Mockito.reset(repository)
        Mockito.reset(useCase)
    }
}