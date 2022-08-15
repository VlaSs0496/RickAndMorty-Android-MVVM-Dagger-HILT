package com.example.rickandmorty.domain.use_case

import com.example.rickandmorty.data.Result
import com.example.rickandmorty.domain.model.Characters
import com.example.rickandmorty.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(
    val repository: CharacterRepository
){
    suspend operator fun invoke(page: Int): Flow<Result<List<Characters>>>{
        return repository.getCharacters(page)
    }
}