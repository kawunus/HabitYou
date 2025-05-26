package com.kawunus.habityou.domain.usecase

import com.kawunus.habityou.domain.api.repository.UsefulHabitRepository
import com.kawunus.habityou.domain.api.usecase.GetEntriesUseCase
import com.kawunus.habityou.domain.api.usecase.GetUsefulHabitsWithEntriesUseCase
import com.kawunus.habityou.domain.model.UsefulHabitWithEntries
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

/**
 * Implementation of [GetUsefulHabitsWithEntriesUseCase] that returns a flow of all useful habits
 * along with their corresponding entries.
 *
 * This use case retrieves all useful habits from the [UsefulHabitRepository], and for each habit,
 * fetches its related entries using [GetEntriesUseCase]. It then combines each habit with its entries
 * into a [UsefulHabitWithEntries] object and emits a list of these objects as a Flow.
 *
 * The use of [flatMapLatest] ensures that if the list of habits changes, the entire downstream flow
 * will be recomputed with the latest data.
 *
 * If there are no habits, a flow emitting an empty list will be returned.
 *
 * @property usefulHabitRepository The repository to fetch useful habits from.
 * @property getEntries The use case to fetch entries for a given habit ID.
 */
class GetUsefulHabitsWithEntriesUseCaseImpl(
    private val usefulHabitRepository: UsefulHabitRepository,
    private val getEntries: GetEntriesUseCase
) : GetUsefulHabitsWithEntriesUseCase {

    /**
     * Returns a [Flow] of a list of [UsefulHabitWithEntries], where each element contains a useful habit
     * and its associated entries.
     *
     * @return A [Flow] that emits the combined data of habits and their entries.
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun invoke(): Flow<List<UsefulHabitWithEntries>> {
        return usefulHabitRepository.getAllUsefulHabits().flatMapLatest { habitsList ->
            val flows = habitsList.map { habit ->
                return@map getEntries(habit.id).map { entries ->
                    UsefulHabitWithEntries(habit, entries)
                }
            }

            if (flows.isEmpty()) return@flatMapLatest flowOf(listOf<UsefulHabitWithEntries>())

            return@flatMapLatest combine(flows) { it.toList() }
        }
    }
}