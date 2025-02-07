package com.demo.hh.core.data.repository

import com.demo.hh.core.common.network.ConnectionError
import com.demo.hh.core.common.network.FetchError
import com.demo.hh.core.common.result.Result
import com.demo.hh.core.domain.repository.VacancyRepository
import com.demo.hh.core.model.Address
import com.demo.hh.core.model.Date
import com.demo.hh.core.model.EmploymentType
import com.demo.hh.core.model.Experience
import com.demo.hh.core.model.Salary
import com.demo.hh.core.model.Schedule
import com.demo.hh.core.model.Vacancy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VacancyRepositoryImpl : VacancyRepository {
    override fun getRelevant(count: Int): Flow<Result<List<Vacancy>, FetchError>> {
        return flow {
            emit(
                Result.Success(
                    listOf(
                        Vacancy(
                            id = "1",
                            lookingNumber = 101,
                            title = "Software Engineer",
                            address = Address("New York", "USA", ""),
                            company = "Tech Corp",
                            experience = Experience.From3To6Years,
                            publishedDate = Date(2023, 9, 15),
                            isFavorite = true,
                            salary = Salary.Exact(100000, '$'),
                            schedules = Pair(EmploymentType.FullTime, Schedule.FullTime),
                            appliedNumber = 50,
                            description = "Responsible for building scalable software solutions.",
                            responsibilities = "Develop software, maintain code, and collaborate with teams.",
                            questions = listOf(
                                "Why do you want to work with us?",
                                "What are your strengths?"
                            )
                        ),
                        Vacancy(
                            id = "2",
                            lookingNumber = 102,
                            title = "Product Manager",
                            address = Address("San Francisco", "USA", ""),
                            company = "Innovate Inc",
                            experience = Experience.From3To6Years,
                            publishedDate = Date(2023, 10, 1),
                            isFavorite = false,
                            salary = Salary.Exact(10000, '$'),
                            schedules = Pair(EmploymentType.PartTime, Schedule.Flexible),
                            appliedNumber = 30,
                            description = "Lead product strategy and manage product lifecycle.",
                            responsibilities = "Define product roadmap, work with engineering and design teams.",
                            questions = listOf(
                                "What is your experience with product management?",
                                "How do you handle tight deadlines?"
                            )
                        ),
                        Vacancy(
                            id = "3",
                            lookingNumber = 103,
                            title = "UX Designer",
                            address = Address("Los Angeles", "USA", ""),
                            company = "Design Studio",
                            experience = Experience.From3To6Years,
                            publishedDate = Date(2023, 11, 5),
                            isFavorite = true,
                            salary = Salary.Exact(14000, '$'),
                            schedules = Pair(EmploymentType.ProjectWork, Schedule.RemoteWork),
                            appliedNumber = 20,
                            description = "Create engaging and user-friendly design solutions.",
                            responsibilities = "Design prototypes, conduct user testing, and iterate based on feedback.",
                            questions = listOf(
                                "How do you approach user-centered design?",
                                "What tools do you use for prototyping?"
                            )
                        )
                    )
                )
            )
        }
    }

    override fun getRelevantCount(): Flow<Result<Int, FetchError>> {
        return flow { emit(Result.Success(3)) }
    }

    override suspend fun setFavorite(id: String, favorite: Boolean): Result<Unit, ConnectionError> {
        return Result.Success(Unit)
    }
}