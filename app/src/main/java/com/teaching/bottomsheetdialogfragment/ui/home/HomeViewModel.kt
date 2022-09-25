package com.teaching.bottomsheetdialogfragment.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teaching.bottomsheetdialogfragment.R
import com.teaching.bottomsheetdialogfragment.model.Card

class HomeViewModel : ViewModel() {

    val cards = getCardsMockup()

    /** LOCAL MOCKUP */
    private fun getCardsMockup(): List<Card> {
        val cards: MutableList<Card> = mutableListOf()
        cards.add(Card(id = "1", text = "••••  5282", icon = R.drawable.ic_card_type_visa))
        cards.add(Card(id = "2", text = "••••  4450", icon = R.drawable.ic_card_type_mc))
        cards.add(Card(id = "3", text = "••••  3498", icon = R.drawable.ic_card_type_def))
        cards.add(Card(id = "4", text = "••••  0244", icon = R.drawable.ic_card_type_visa))
        return cards
    }
}