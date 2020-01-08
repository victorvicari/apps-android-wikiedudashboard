package org.wikiedufoundation.wikiedudashboard.ui.campaign.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.wikiedufoundation.wikiedudashboard.ui.campaign.data.CampaignListData

/**
 * This creates an interface for
 * querying the database
 **/
@Dao
interface ActiveCampaignDao {

    /**
     * This get all the campaigns
     *
     **/
    @Query("SELECT * from campaign_list ORDER BY id ASC")
    fun getAllCampaign(): LiveData<List<CampaignListData>>

    /**
     * This insert the data into the database
     *
     **/
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCampaign(campaignList: List<CampaignListData>)

}