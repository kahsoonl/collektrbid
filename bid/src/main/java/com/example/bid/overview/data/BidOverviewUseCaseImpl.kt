package com.example.bid.overview.data

import com.example.bid.detail.domain.model.BidModel
import com.example.bid.overview.data.repository.BidOverviewLocalRepository
import com.example.bid.overview.domain.model.CollectableModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class BidOverviewUseCaseImpl @Inject constructor(
    private val bidOverviewLocalRepository: BidOverviewLocalRepository,
) : BidOverviewUseCase {
    override fun getCollectableList(): Flow<List<CollectableModel>> {
        return bidOverviewLocalRepository.getCollectableFromLocal().transform { collectableList ->
            emit(
                collectableList.map { collectableEntity ->
                    CollectableModel(
                        collectableId = collectableEntity.collectable.collectableId,
                        collectableName = collectableEntity.collectable.collectableName,
                        collectableDesc = collectableEntity.collectable.collectableDescription,
                        collectableBids = collectableEntity.bids.map { bidEntity ->
                            BidModel(
                                bidId = bidEntity.bidId,
                                bidAmount = bidEntity.bidAmount,
                                bidDateTime = bidEntity.bidDateTime,
                                userName = bidEntity.userName,
                            )
                        },
                    )
                }
            )
        }
    }
}