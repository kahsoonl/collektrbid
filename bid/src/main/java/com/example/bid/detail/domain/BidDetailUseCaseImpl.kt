package com.example.bid.detail.domain

import com.example.bid.detail.data.repository.BidDetailLocalRepository
import com.example.bid.detail.domain.model.BidModel
import com.example.bid.overview.domain.model.CollectableModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class BidDetailUseCaseImpl @Inject constructor(
    private val bidDetailLocalRepository: BidDetailLocalRepository,
) : BidDetailUseCase {
    override fun fetchCollectableDataFromLocal(collectableId: Int): Flow<CollectableModel> {
        return bidDetailLocalRepository.fetchCollectableDataFromLocal(collectableId = collectableId)
            .transform { collectableEntity ->
                emit(
                    CollectableModel(
                        collectableId = collectableEntity.collectable.collectableId,
                        collectableName = collectableEntity.collectable.collectableName,
                        collectableDesc = collectableEntity.collectable.collectableDescription,
                        collectableBids = collectableEntity.bids.map { bidEntity ->
                            BidModel(
                                bidId = bidEntity.bidId,
                                bidAmount = bidEntity.bidAmount,
                                userName = bidEntity.userName,
                            )
                        },
                    )
                )
            }
    }
}