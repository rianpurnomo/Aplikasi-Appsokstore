package com.appsokstore.app.ui.warta


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.appsokstore.app.R
import com.appsokstore.app.databinding.FragmentWartaBinding
import com.appsokstore.app.ui.home.MainActivity

class WartaFragment : Fragment() {

    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentWartaBinding
    private val viewModel: WartaViewModel by lazy { WartaViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWartaBinding.inflate(inflater, container, false).apply {
            viewModel = this@WartaFragment.viewModel
            lifecycleOwner = this@WartaFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.recyclerView.adapter = WartaAdapter(parent)
        viewModel.listWarta()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listWarta()
        }
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it
        }
        viewModel.actionState.observe(viewLifecycleOwner) {
            if (it.isConsumed) {
                Log.i("ActionState", "isConsumed")
            } else if (!it.isSuccess) {
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}