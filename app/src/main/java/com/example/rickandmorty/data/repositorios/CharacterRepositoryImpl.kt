package com.example.rickandmorty.data.repositorios

import com.example.rickandmorty.data.Result
import com.example.rickandmorty.data.source.remote.Dto.toCharacter
import com.example.rickandmorty.data.source.remote.Dto.toListCharacters
import com.example.rickandmorty.data.source.remote.RickAndMorty
import com.example.rickandmorty.domain.model.Character
import com.example.rickandmorty.domain.model.Characters
import com.example.rickandmorty.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMorty
):CharacterRepository{
    override fun getCharacters(page: Int): Flow<Result<List<Characters>>> = flow{
        emit(Result.Loading())
        try {
            val response = api.getCharacters(page).toListCharacters()
            emit(Result.Success(response))
        }catch (e: HttpException){
            emit(Result.Error(
                message = "Que monda paso",
                data = null
            ))
        }
    }

    override suspend fun getCharacter(id: Int): Result<Character> {
        val response = try {
            api.getCharacterById(id)
        }catch (e: Exception){
            return Result.Error("Que monda paso")
        }
        return Result.Success(response.toCharacter())
    }

}