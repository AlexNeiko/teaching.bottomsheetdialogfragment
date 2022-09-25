package com.teaching.bottomsheetdialogfragment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.teaching.bottomsheetdialogfragment.databinding.FragmentHomeBinding
import com.teaching.bottomsheetdialogfragment.model.Card
import com.teaching.bottomsheetdialogfragment.ui.dialog.ChooseCardDialogFragment

class HomeFragment : Fragment(), ChooseCardDialogFragment.CardDialogListener {

  /** UI */
  private var _binding: FragmentHomeBinding? = null
  private val binding get() = _binding!!
  /** Dialog */
  lateinit var dialog: ChooseCardDialogFragment /** BottomSheetDialogFragment for choose card */
  lateinit var listener: ChooseCardDialogFragment.CardDialogListener /** Listener for choose card */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listener = this  /** set listener of BottomSheetDialogFragment */
    }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root

        /** Create and open dialog */
        binding.button.setOnClickListener {
            dialog = ChooseCardDialogFragment(listener, homeViewModel.cards)
            dialog.show(this.parentFragmentManager, "tag")
        }

    return root
  }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /** override click to item from dialog */
    override fun chooseCardClick(card: Card) {
        binding.textView.text = "You choose  ${card.text}"
        dialog.dismiss()
    }

    /** override click to additional logic */
    override fun newCardClick() {
        binding.textView.text = "You need to create new card"
        dialog.dismiss()
    }
}