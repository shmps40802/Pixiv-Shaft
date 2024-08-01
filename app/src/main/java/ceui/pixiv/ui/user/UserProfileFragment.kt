package ceui.pixiv.ui.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import ceui.lisa.R
import ceui.lisa.databinding.FragmentUserProfileBinding
import ceui.refactor.viewBinding

class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {

    private val binding by viewBinding(FragmentUserProfileBinding::bind)
    private val args by navArgs<UserProfileFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return 2
            }

            override fun createFragment(position: Int): Fragment {
                return if (position == 0) {
                    UserCreatedIllustsFragment().apply {
                        arguments = args.toBundle()
                    }
                } else {
                    UserBookmarkedIllustsFragment().apply {
                        arguments = args.toBundle()
                    }
                }
            }
        }
    }
}